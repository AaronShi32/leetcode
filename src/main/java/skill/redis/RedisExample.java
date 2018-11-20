package skill.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

public class RedisExample {

    private static JedisPool jedisPool;

    private static Jedis redis;

    private static JedisPubSub jedisPubSub;

    static {

        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(200);

        config.setMaxIdle(8);

        config.setMaxWaitMillis(1000 * 100);

        config.setTestOnBorrow(true);

        jedisPool = new JedisPool(config, "127.0.0.1", 6379, 3000);

        redis = jedisPool.getResource();
    }

    private static void ex1(){

    }


    public static void main(String[] args){
        redis.subscribe(jedisPubSub, "cctv1", "cctv2");
    }

}
