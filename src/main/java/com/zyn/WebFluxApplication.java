package com.zyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zyn
 * @Create: 2020-12-07 15:55
 * @Description:
 **/
@SpringBootApplication
//@RestController
//@RequestMapping("/webFlux")
public class WebFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);
    }

//    @RequestMapping("/get")
//    public Mono<String> get() {
//        return Mono.just("Hello,WebFlux");
//    }

}
