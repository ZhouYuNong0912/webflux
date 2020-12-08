package com.zyn.webflux.stream.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * @Author: zyn
 * @Create: 2020-12-04 15:13
 * @Description:
 **/
public class reactorDemo {

    public static void main(String[] args) {
        //使用Mono创建一个元素
        Mono<String> mono = Mono.just("mono");
        mono.subscribe(i -> System.out.println(i));

        //使用Flx创建多个元素
        Flux<String> flux0 = Flux.just("flux1", "flux2", "flux3");
        flux0.subscribe(i -> System.out.println(i));
        Flux.fromIterable(Arrays.asList("flux1", "flux2", "flux3"));

        //使用程序创建一个Flux
        Flux.create(i ->{

        });


    }
}
