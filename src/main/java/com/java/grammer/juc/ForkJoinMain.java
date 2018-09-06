package com.java.grammer.juc;


import java.util.concurrent.*;

/**
 * RecursiveTask代表有返回值的任务
 * <p>
 * RecursiveAction代表没有返回值的任务
 */
public class ForkJoinMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 提交可分解的PrintTask任务
        forkJoinPool.submit(new PrintTask(0, 200));
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);//阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束
        // 关闭线程池



        Future<Integer> future = forkJoinPool.submit(new SumTask(0, 200));

        System.out.println("计算出来的总和=" + future.get());

        forkJoinPool.shutdown();

    }
}

class PrintTask extends RecursiveAction {

    private static final int MAX = 50;

    private int start;
    private int end;

    PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // 当end-start的值小于MAX时候，开始打印
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值:"
                        + i);
            }
        } else {
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            // 并行执行两个小任务
            left.fork();
            right.fork();
        }
    }
}

class SumTask extends RecursiveTask<Integer>{

    private final int MAX = 50;

    private int start;

    private int end;

    private int sum = 0;

    public SumTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            SumTask left = new SumTask(start, middle);
            SumTask right = new SumTask(middle, end);

            left.fork();
            right.fork();

            return left.join() + right.join();
        }
    }
}