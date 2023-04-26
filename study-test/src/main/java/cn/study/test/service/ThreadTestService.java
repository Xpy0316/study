package cn.study.test.service;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName ThreadTestService
 * @Description TODO
 * @Author v-xupengyuan
 * @Date 2023/4/20 16:27
 * @Version 1.0
 */
public interface ThreadTestService {

    void function01() throws InterruptedException;

    void function02() throws InterruptedException;

    CompletableFuture<String> pullDataA() throws InterruptedException;

    CompletableFuture<String> pullDataB() throws InterruptedException;

    CompletableFuture<String> pullDataC() throws InterruptedException;



}
