package skill.juc;

public class SyncMain {

    private ThreadLocal<Long> al = new ThreadLocal<>();

    public static void main(String[] args){
        LongWidget w = new LongWidget();
        w.work();
    }
}

class Widget {

    public synchronized void work(){
        System.out.println("super is working...");
    }

}

class LongWidget extends Widget {

    public synchronized void work(){
        System.out.println("sub is working...");
        super.work();
    }
}