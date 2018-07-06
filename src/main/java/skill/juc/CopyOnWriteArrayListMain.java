package skill.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 并发容器: CopyOnWriteArrayList and CopyOnWriteSet
 *
 * refer: http://www.cnblogs.com/dolphin0520/p/3938914.html
 */
public class CopyOnWriteArrayListMain {

    private static CopyOnWriteArrayList<Integer> coa = new CopyOnWriteArrayList<>();

    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.submit(new WriteTask(coa));

        executor.submit(new WriteTask(coa));

        executor.submit(new ReadTask(coa));

        executor.submit(new ReadTask(coa));

        executor.submit(new ReadTask(coa));

        executor.submit(new ReadTask(coa));

        executor.shutdown();
    }
}

class ReadTask implements Runnable {

    private CopyOnWriteArrayList<Integer> coa;

    private Random rand = new Random();

    public ReadTask(CopyOnWriteArrayList<Integer> coa){
        this.coa = coa;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1500); // 读 > 写的场景
            int e = this.coa.get(rand.nextInt(this.coa.size()));
            System.out.println(Thread.currentThread().getName() + " 获取到: " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WriteTask implements Runnable {

    private CopyOnWriteArrayList<Integer> coa;

    private Random rand = new Random();

    public WriteTask(CopyOnWriteArrayList<Integer> coa){
        this.coa = coa;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500); // 读 > 写的场景
            int e = rand.nextInt(100);
            this.coa.addIfAbsent(e);
            System.out.println(Thread.currentThread().getName() + " 添加: " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}