package skill.juc;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BlockingQueue 实现生产者和消费者
 */
public class CustomerAndProducerMain {

    private static LinkedBlockingQueue<Integer> workbench = new LinkedBlockingQueue<>(10);

    public static void main(String[] args){

        Thread customer = new Thread(new Customer(workbench));

        Thread producer = new Thread(new Producer(workbench));

        customer.start();

        producer.start();
    }
}


class Customer implements Runnable {

    private LinkedBlockingQueue<Integer> workbench;

    private Random rand = new Random();

    public Customer(LinkedBlockingQueue<Integer> workbench){
        this.workbench = workbench;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep( 2000);
                Integer work = workbench.poll();
                while(work == null){
                    System.out.println("Warning: Workbench is empty now");
                    work = workbench.poll();
                }
                System.out.println("Customer take a work: " + work + " at " + new Date().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

class Producer implements Runnable {

    private LinkedBlockingQueue<Integer> workbench;

    private Random rand = new Random();

    public Producer(LinkedBlockingQueue<Integer> workbench){
        this.workbench = workbench;
    }

    @Override
    public void run() {
        while(true){
            try {
                int work = rand.nextInt(5);
                Thread.sleep(work * 1000);
                // workbench.put(work);
                while (!workbench.offer(work)){
                    System.out.println("Warning: Workbench is full now");
                }
                System.out.println("Producer put a work: " + work + " at " + new Date().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
