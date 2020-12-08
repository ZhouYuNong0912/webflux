package com.zyn.webflux.stream.reactor;

import com.zyn.webflux.Product;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * @Author: zyn
 * @Create: 2020-12-04 15:46
 * @Description:
 **/
public class ReactorDemo2 {

    public static Product[] products = new Product[]{
            new Product(1, new BigDecimal("9.92"), 100, "E"),
            new Product(2, new BigDecimal("19.92"), 200, "E"),
            new Product(3, new BigDecimal("29.92"), 500, "E"),

            new Product(4, new BigDecimal("19.92"), 200, "C"),
            new Product(5, new BigDecimal("9.32"), 300, "C"),
            new Product(6, new BigDecimal("33.92"), 100, "C"),

            new Product(7, new BigDecimal("23.76"), 300, "M"),
            new Product(8, new BigDecimal("11.92"), 222, "M"),
            new Product(9, new BigDecimal("88.92"), 3400, "M"),
    };

    public Flux<Product> getFluxProduct() {
        //1、将数据转换为流
        return Flux.just(products)
                //2、排序
                .collectMultimap(Product::getClassify)
                //3、将流转成成Map
                .flatMapMany(i -> Flux.fromIterable(i.entrySet()))
                //4、获取Map的Value值,转为Flux
                .flatMap(i -> Flux.fromIterable(i.getValue())
                        //5、排序
                        .sort(
                                Comparator.comparing(Product::getPrice).reversed()).next());

    }


    public static void main(String[] args) {
        ReactorDemo2 reactorDemo2 = new ReactorDemo2();
        reactorDemo2.getFluxProduct().subscribe(i -> System.out.println(i));
    }
}
