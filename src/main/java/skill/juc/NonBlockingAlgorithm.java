package skill.juc;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 非阻塞算法, 乐观锁, lock-free, 显示的自旋
 */
public class NonBlockingAlgorithm {

    private AtomicLong count= new AtomicLong(0);

    public void lock(){
        boolean updated = false;
        while(!updated){
            long prevCount = this.count.get();
            updated = this.count.compareAndSet(prevCount, count.incrementAndGet());
        }
    }
}
