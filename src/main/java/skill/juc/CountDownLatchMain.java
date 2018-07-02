package skill.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 门阀
 *
 * 1.启动主线程
 * 2.为n个子线程创建一个CountDownLatch, 计数器
 * 3.n个子线程开始执行, Thread.start()
 * 4.主线程等待 latch.await();
 * 5.n个子线程完成各自的任务 latch.countDown();
 * 6.主线程开始继续执行
 */
public class CountDownLatchMain {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static class CThread extends Thread {

        private CountDownLatch latch;

        public CThread(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void run() {
            try{
                System.out.println("Thread " + Thread.currentThread().getName() + " begin at " + sdf.format(new Date()));
                work();// 线程执行自己的任务
                System.out.println("Thread " + Thread.currentThread().getName() + " end at " + sdf.format(new Date()));
            }finally {
                latch.countDown();
            }
        }

        private void work() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始执行...");
        CountDownLatch latch = new CountDownLatch(3);
        CThread c1 = new CThread(latch);
        CThread c2 = new CThread(latch);
        CThread c3 = new CThread(latch);
        c1.start();
        c2.start();
        c3.start();
        latch.await();
        System.out.println("主线程继续执行...");
    }
}
