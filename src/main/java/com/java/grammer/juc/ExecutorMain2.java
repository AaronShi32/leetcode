package com.java.grammer.juc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

/**
 * Java线程池的完整构造函数
 * public ThreadPoolExecutor(
 *     int corePoolSize, // 正式工数量
 *     int maximumPoolSize, // 工人数量上限，包括正式工和临时工
 *     long keepAliveTime, TimeUnit unit, // 临时工游手好闲的最长时间，超过这个时间将被解雇
 *     BlockingQueue<Runnable> workQueue, // 排期队列
 *     ThreadFactory threadFactory, // 招人渠道
 *     RejectedExecutionHandler handler) // 拒单方式
 */

public class ExecutorMain2 {

    // corePoolSize -> 任务队列 -> maximumPoolSize -> 拒绝策略

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int coreSize = 5;
        int maxSize = 10;

        ExecutorService exec = new ThreadPoolExecutor(coreSize, maxSize, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.DiscardPolicy());
        for(int i = 0; i < 10; i++) {
            Future<Integer> task = exec.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 42;
                }
            });
            System.out.println(task.get());
        }
        // exec.execute(() -> System.out.println(Thread.currentThread().getName() + " is work"));
        exec.awaitTermination(1000, TimeUnit.MILLISECONDS);
        exec.shutdown();

        // 获取多个结果
        exec = new ThreadPoolExecutor(coreSize, maxSize, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.DiscardPolicy());

        Collection<Callable<Integer>> solvers = new ArrayList<>();
        solvers.add(() -> 1);
        solvers.add(() -> 2);
        solvers.add(() -> 3);
        solvers.add(() -> 4);

        CompletionService<Integer> ecs = new ExecutorCompletionService<>(exec);
        for (Callable<Integer> s : solvers)// 提交所有任务
            ecs.submit(s);

        int n = solvers.size();
        for (int i = 0; i < n; ++i) {// 获取每一个完成的任务
            Integer r = ecs.take().get(); // 获取顺序是任意的，取决于任务的完成顺序
            if (r != null)
                System.out.println(r);
        }
        exec.awaitTermination(1000, TimeUnit.MILLISECONDS);
        exec.shutdown();
    }
}
