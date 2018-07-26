package skill.redis;

public class Example {

    public static void main(String[] args){
        Service service = new ServiceImpl();
        for (int i = 0; i < 50; i++) {
            RobotThread t = new RobotThread(service);
            t.start();
        }
    }
}
