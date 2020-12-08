package com.zyn.webflux;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: zyn
 * @Create: 2020-12-04 12:43
 * @Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    //id
    private Integer id;
    //价格
    private BigDecimal price;
    //库存
    private Integer stock = 100;
    //种类
    private String classify;

    public static void nameOf(Product product) {
        System.out.println("产品名字：" + product);
    }

    public Integer reduceStock(Integer productNum) {
        System.out.println("减库存：-" + productNum);
        return this.stock -= productNum;
    }

    public Integer reduceStock(Integer stock, Integer productNum) {
        System.out.println("减库存：-" + productNum);
        return this.stock = stock - productNum;
    }



}
