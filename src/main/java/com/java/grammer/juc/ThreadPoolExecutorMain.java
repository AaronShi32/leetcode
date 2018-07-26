package com.java.grammer.juc;

import com.google.common.util.concurrent.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * 1. 首先线程池判断基本线程池是否有空闲线程？有则交给空闲线程执行，无则进入下个流程。
 * 2. 基本线程池是否已满？没满，创建线程执行。满了进入下一个流程。
 * 3. 工作队列是否已满？没满，存储在工作队列里。满了，则进入下个流程。
 * 4. 整个线程池是否已满？没满，创建新线程来执行任务，满了，则交给饱和策略。
 * 5. 空闲线程 达到存活时间后会进行释放
 */
public class ThreadPoolExecutorMain {

    private static ThreadFactory createThreadFactory = new ThreadFactoryBuilder().setNameFormat("create thread pool").build();


    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10, 2000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), createThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);

        final List<Long> jobList = new ArrayList<>();
        jobList.add(1L);
        jobList.add(2L);
        jobList.add(3L);
        jobList.add(4L);
        final List<Long> resultList = Collections.synchronizedList(new ArrayList<>());
        final CountDownLatch latch = new CountDownLatch(jobList.size());

        for(final Long job:  jobList){
            ListenableFuture<Long> futureResult = executorService.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    return job * 2;
                }
            });

            Futures.addCallback(futureResult, new FutureCallback<Long>() {
                @Override
                public void onSuccess(Long result) {
                    //doSomething();
                    resultList.add(result);
                    latch.countDown();
                }

                @Override
                public void onFailure(Throwable throwable) {
                    //doSomething();
                    latch.countDown();
                }
            });

            latch.await(5L, TimeUnit.SECONDS);
        }

        System.out.println(resultList);
    }
}
