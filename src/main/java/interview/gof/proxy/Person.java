package interview.gof.proxy;

public class Person implements doSth {

    @Override
    public void work() {
        System.out.println("Person ---> work");
    }

    @Override
    public void exercise() {
        System.out.println("Person ---> exercise");
    }

    @Override
    public void music() {
        System.out.println("Person ---> music");
    }

    @Override
    public void read() {
        System.out.println("Person ---> read");
    }
}
