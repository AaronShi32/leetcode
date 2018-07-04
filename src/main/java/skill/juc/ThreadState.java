package skill.juc;

import javax.jws.Oneway;

public class ThreadState {

    private static void getState(Thread t){
        System.out.println(t.getName() + " is " + t.getState());
    }



    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();

        ThreadDemo t = new ThreadDemo(a);
        t.start();
        a.wait();
        System.out.println("主线程执行中...");
        // t.join(); // Running -> Waiting
        //Thread.yield(); // 出让CPU使用权 Running -> Runnable
        System.out.println("主线程等待 t 完成后在执行...");
    }

}

class ThreadDemo extends Thread {

    private Object a;

    public ThreadDemo(Object a){
        this.a = a;
    }

    public void run(){
        System.out.println("begin: " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
        a.notify();
        System.out.println("end: " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
    }

    private void work(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
