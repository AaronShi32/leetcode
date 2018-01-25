package skill.distribute.lock.redis;

public class RobotThread extends Thread{

    private Service service;

    public RobotThread(Service service){
        this.service = service;
    }

    public void run(){
        service.seckill();
    }
}
