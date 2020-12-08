package com.zyn.webflux.stream.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @Author: zyn
 * @Create: 2020-12-04 14:54
 * @Description:
 **/
public class ReactiveProcessor extends SubmissionPublisher<String> implements Flow.Processor<String,String>{
    private Flow.Subscription subscription;



    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Processor建立订阅关系");
        this.subscription = subscription;
        this.subscription.request(1);

    }

    @Override
    public void onNext(String item) {
        System.out.println("Processor的onNext方法,item=" + item);
        if (item.equals("WebFlux")) {
            System.out.println("Hello,WebFlux");
        }
        //中间处理
        this.submit(item.toUpperCase());
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {
        System.out.println("Processor数据接受完成");
    }
}
