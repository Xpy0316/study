package cn.study.test.controller;

import cn.study.test.service.ThreadTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName ThreadTestController
 * @Description TODO
 * @Author v-xupengyuan
 * @Date 2023/4/20 16:07
 * @Version 1.0
 */
@RestController
@RequestMapping("/thread")
public class ThreadTestController {

    @Autowired
    private ThreadTestService threadTestService;


    /**
     * 异步线程
     * @throws InterruptedException
     */
    @GetMapping("/testAsync")
    public void test01() throws InterruptedException {
        threadTestService.function01();
        threadTestService.function02();
    }

    /**
     * 多线程处理任务，需要等待线程处理结果
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @GetMapping("/testCompletableFuture")
    public void test02() throws InterruptedException, ExecutionException {
        CompletableFuture<String> a = threadTestService.pullDataA();
        CompletableFuture<String> b = threadTestService.pullDataB();
        CompletableFuture<String> c = threadTestService.pullDataC();
        CompletableFuture.allOf(a,b,c).join();
        System.out.println(a.get()+"--"+b.get()+"--"+c.get());

    }

}
