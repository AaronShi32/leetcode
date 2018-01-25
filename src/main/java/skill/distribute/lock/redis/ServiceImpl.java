package skill.distribute.lock.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ServiceImpl implements Service{


    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(200);

        config.setMaxIdle(8);

        config.setMaxWaitMillis(1000 * 100);

        config.setTestOnBorrow(true);

        pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
    }

    private DistributedLock lock = new DistributedLock(pool);

    private int N = 500;

    public void seckill() {
        // String indentifier = lock.acquirelock("resource", 5000, 1000);
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--N);
        // lock.releaseLock("resource", indentifier);
    }
}
