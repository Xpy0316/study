package cn.study.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadConfig
 * @Description TODO
 * @Author v-xupengyuan
 * @Date 2023/4/19 11:00
 * @Version 1.0
 */
@EnableAsync
@Configuration
public class ThreadConfig {
    /**
     * 当池子大小小于corePoolSize，就新建线程，并处理请求
     * 当池子大小等于corePoolSize，把请求放入workQueue(QueueCapacity)中，池子里的空闲线程就去workQueue中取任务并处理
     * 当workQueue放不下任务时，就新建线程入池，并处理请求，如果池子大小撑到了maximumPoolSize，就用RejectedExecutionHandler来做拒绝处理
     * 当池子的线程数大于corePoolSize时，多余的线程会等待keepAliveTime长时间，如果无请求可处理就自行销毁
     */

    // 核心线程池大小
    private int corePoolSize = 50;

    // 最大可创建的线程数
    private int maxPoolSize = 200;

    // 队列最大长度
    private int queueCapacity = 1000;

    // 线程池维护线程所允许的空闲时间
    private int keepAliveSeconds = 300;

    /**
     * 执行需要依赖线程池，这里就来配置一个线程池
     * @return
     */
    @Bean("asyncTaskExecutor")
    public Executor getExecutor(){
        ThreadPoolTaskExecutor executor  = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);


        executor.setThreadNamePrefix("Async-Thread");//设置线程名


        /**
         *  (1) 默认的ThreadPoolExecutor.AbortPolicy   处理程序遭到拒绝将抛出运行时RejectedExecutionException;
         *  (2) ThreadPoolExecutor.CallerRunsPolicy 线程调用运行该任务的 execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度
         *  (3) ThreadPoolExecutor.DiscardPolicy  不能执行的任务将被删除;
         *  (4) ThreadPoolExecutor.DiscardOldestPolicy  如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）。
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); //对拒绝task的处理策略

        executor.initialize();//初始化线程
        return  executor;

    }
}
