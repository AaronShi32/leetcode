package skill.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行
 */
public class CyclicBarrierMain {

    static class Task implements Runnable{

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier){
            this.barrier=barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 哥已到");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " 哥已就坐，其他哥几个赶快啊，哥饿啦.");
                this.barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "终于都到啦，哥开吃啦，哈哈。");
        }
    }

    public static void main(String[] args){
        final CyclicBarrier barrier = new CyclicBarrier(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));
        for(int i = 0; i < 10; i++){
            Task t = new Task(barrier);
            executor.execute(t);
        }

    }


}
