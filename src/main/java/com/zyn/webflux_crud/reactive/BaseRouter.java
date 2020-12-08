package com.zyn.webflux_crud.reactive;

import com.zyn.webflux_crud.config.RouterPath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Author: zyn
 * @Create: 2020-12-07 16:25
 * @Description: WebFlux首先会进入到Router请求，然后根据映射的路径找到Handler所对应的方法
 **/
@Configuration
public class BaseRouter {

    @Bean
    public RouterFunction<ServerResponse> router(WebFluxWebHandler webHandler) {
        return RouterFunctions.route()
                .POST(RouterPath.save, webHandler::save)
                .GET(RouterPath.find,webHandler::find)
                .DELETE(RouterPath.delete,webHandler::delete)
                .PUT(RouterPath.update,webHandler::update)
                .GET(RouterPath.findAll,webHandler::findAll)
                .build();

    }
}
