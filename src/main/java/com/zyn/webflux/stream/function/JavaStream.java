package com.zyn.webflux.stream.function;

import com.zyn.webflux.Product;

import java.util.function.*;

/**
 * @Author: zyn
 * @Create: 2020-12-04 12:36
 * @Description:
 **/
public class JavaStream {

    public static void main(String[] args) {
        //Consumer 输入T 没有输出
        Product p = new Product();
        Consumer<Product> consumerTest = product -> Product.nameOf(product);
        consumerTest.accept(p);
        //方法引用
        Consumer<Product> consumerTestCite = Product::nameOf;
        consumerTestCite.accept(p);

        //创建Supplier容器,声明类型，此时并不会调用对象的构造对象，也就是说没有创建对象 没有输入，一个输出R
        Supplier<Product> supplierTest = Product::new;
        //当调用get方法的时候则会调用对象中的构造方法
        supplierTest.get();

        //Function 一个输入 T ,一个输出 R
        Function<Integer, Integer> functionTest = p::reduceStock;
        System.out.println("减库存成功，剩余库存(Function) " + functionTest.apply(10));

        //UnaryOperator一元函数 输入输出都是T
        UnaryOperator<Integer> unaryOperatorTest = p::reduceStock;
        System.out.println("减库存成功，剩余库存(UnaryOperator) " + functionTest.apply(20));

        //BiFunction二元函数 T、U输入参数 R返回参数
        BiFunction<Integer, Integer, Integer> biFunctionTest = p::reduceStock;
        System.out.println("减库存成功，剩余库存(BiFunction) " + biFunctionTest.apply(100,30));

        //BinaryOperator二元函数 当输入(T、U),输出(R)都为同个类型时，可以简化为这个API
        BinaryOperator<Integer> binaryOperatorTest = p::reduceStock;
        System.out.println("减库存成功，剩余库存(BinaryOperator) " + binaryOperatorTest.apply(100,90));


    }

}


