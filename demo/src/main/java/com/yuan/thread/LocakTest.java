package com.yuan.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class LocakTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
//        scheduledThreadPool.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("延迟三秒");
//            }
//        }, 3, TimeUnit.SECONDS);
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("延迟 1 秒后每三秒执行一次");
//            }
//        }, 1, 3, TimeUnit.SECONDS);

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setMaxPoolSize(3);
        taskExecutor.setQueueCapacity(3);
        taskExecutor.initialize();
        taskExecutor.setThreadNamePrefix("taskExecutor");
        Future<String> future = taskExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "已提交");
                if (true) {
                    throw new RuntimeException("test");
                }
                return "SUCCESS";
            }
        });
        Object o = future.get();
        System.out.println(o);


    }
}
