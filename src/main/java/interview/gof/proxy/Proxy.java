package interview.gof.proxy;

public class Proxy implements doSth {

    private Person person;

    public Proxy(Person person){
        this.person = person;
    }

    @Override
    public void work() {
        System.out.println("Proxy ----> before");
        this.person.work();
        System.out.println("Proxy ----> after");
    }

    @Override
    public void exercise() {
        this.person.exercise();
    }

    @Override
    public void music() {
        this.person.music();
    }

    @Override
    public void read() {
        this.person.read();
    }
}
