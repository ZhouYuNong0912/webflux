package com.zyn.webflux.stream.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @Author: zyn
 * @Create: 2020-12-04 13:55
 * @Description:
 **/
public class ReactiveDemo {
    public static void main(String[] args) {

        //发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        //订阅者
        Flow.Subscriber subscriber = new Flow.Subscriber() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("第一次连接成功(onSubscribe)");
                this.subscription.request(1);
            }

            @Override
            public void onNext(Object item) {
                System.out.println("数据接受成功，item=" + item);
                this.subscription.request(1);

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("连接异常");
            }

            @Override
            public void onComplete() {
                System.out.println("数据发送完毕");
            }
        };
        //处理器Processor
        ReactiveProcessor reactiveProcessor = new ReactiveProcessor();
        //建议订阅关系    处理器绑定订阅者
        reactiveProcessor.subscribe(subscriber);
        //建议订阅关系    发布者绑定处理器
        publisher.subscribe(reactiveProcessor);
        try {
            //发数据
            publisher.submit("WebFlux");
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭
            publisher.close();
        }


    }

}
