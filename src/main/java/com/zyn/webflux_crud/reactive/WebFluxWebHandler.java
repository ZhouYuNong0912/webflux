package com.zyn.webflux_crud.reactive;

import com.zyn.webflux_crud.User;
import com.zyn.webflux_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author: zyn
 * @Create: 2020-12-07 16:19
 * @Description:
 **/
@Component
public class WebFluxWebHandler {

    @Autowired
    private UserService userService;

    /**
     * 商品保存
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        //1、先将ServerRequest转换成bodyToMono
        return serverRequest.bodyToMono(User.class)
                //2、将数据保存到数据库中
                .flatMap(i -> userService.save(i))
                //3、向前端发送相应，同时将保存的数据一并返回给前台
                .flatMap(p -> ServerResponse.ok().bodyValue(p));
    }

    /**
     * 商品查询
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> find(ServerRequest serverRequest) {
        Integer id = Integer.parseInt(serverRequest.pathVariable("id"));
        //1、查询商品
        return userService.find(id)
                //2、如果存在该商品，则返回数据到前端
                .flatMap(i -> ServerResponse.ok().bodyValue(i))
                //2、如果没有查询到，则默认给个空
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        Integer id = Integer.parseInt(serverRequest.pathVariable("id"));
        //1、删除操作前同样先判断是否存在数据，只有存在数据才会进flatMap
        return userService.find(id)
                //2、存在则删除数据
                .flatMap(i -> userService.delete(id))
                //3、向前端返回结果
                .then(ServerResponse.ok().build())
                //4、判断是否为空
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /**
     * 数据修改
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        Integer id = Integer.parseInt(serverRequest.pathVariable("id"));
        //1、删除操作前同样先判断是否存在数据，只有存在数据才会进flatMap
        return userService.find(id)
                //2、存在则修改数据,需要先转换为Mono数据然后才进行数据修改
                .flatMap(p -> serverRequest.bodyToMono(User.class).flatMap(i -> userService.save(i)))
                //3、向前端返回结果
                .flatMap(p -> ServerResponse.ok().bodyValue(p))
                //4、判断是否为空
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userService.findAll(),User.class);
    }

}
