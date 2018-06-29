package skill.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger aint = new AtomicInteger(0);

    public static void main(String[] args){

        Thread other = new Thread(() -> {
            System.out.println("thread: " + aint.incrementAndGet());
        });

        other.start();

        while(!aint.compareAndSet(0, 3)){
            System.out.println("waiting...");
        }

        System.out.println("main: " + aint.get());


    }
}
