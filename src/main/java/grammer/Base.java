package grammer;

public class Base {

    public void changeWorld(){
        System.out.println("wanna change world?");
    }

    public void sayHello(){
        System.out.println("say hello");
        changeWorld();
    }

}
