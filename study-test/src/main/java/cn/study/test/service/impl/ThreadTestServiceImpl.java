package cn.study.test.service.impl;

import cn.study.test.service.ThreadTestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName ThreadTestServiceImpl
 * @Description TODO
 * @Author v-xupengyuan
 * @Date 2023/4/20 16:27
 * @Version 1.0
 */
@Service
public class ThreadTestServiceImpl implements ThreadTestService {


    @Async("asyncTaskExecutor")
    public void function01() throws InterruptedException {
        System.out.println("f1:"+Thread.currentThread().getName()+"  "+ UUID.randomUUID());

        Thread.sleep(10000);
        System.out.println("function01");

    }


    @Async("asyncTaskExecutor")
    public void function02() throws InterruptedException {
        System.out.println("f2:"+Thread.currentThread().getName()+"  "+ UUID.randomUUID());

        Thread.sleep(100);
        System.out.println("function02");

    }



    @Async("asyncTaskExecutor")
    public CompletableFuture<String> pullDataA()throws InterruptedException{
        System.out.println("A:"+Thread.currentThread().getName()+"  "+ UUID.randomUUID());
        Thread.sleep(2000);
        System.out.println("数据A拉去成功");
        return CompletableFuture.completedFuture("A");
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<String> pullDataB()throws InterruptedException{
        System.out.println("B:"+Thread.currentThread().getName()+"  "+ UUID.randomUUID());
        Thread.sleep(2000);
        System.out.println("数据B拉去成功");
        return CompletableFuture.completedFuture("B");
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<String> pullDataC()throws InterruptedException{
        System.out.println("C:"+Thread.currentThread().getName()+"  "+ UUID.randomUUID());
        Thread.sleep(2000);
        System.out.println("数据C拉去成功");
        return CompletableFuture.completedFuture("C");
    }
}
