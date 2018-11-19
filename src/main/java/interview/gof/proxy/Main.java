package interview.gof.proxy;

public class Main {

    public static void main(String[] args){

        Person person = new Person();
        Proxy proxy = new Proxy(person);
        proxy.work();

        // 实现相同接口, 构造函数传入

    }

}
