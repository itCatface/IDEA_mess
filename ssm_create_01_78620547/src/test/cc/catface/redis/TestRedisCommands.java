package cc.catface.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class TestRedisCommands {

    JedisPool jedisPool;
    Jedis jedis;

    @Before
    public void setUp() {
        jedis = new Jedis("localhost");
    }


    @Test
    public void testString() {
        jedis.set("test_name", "alistar");
        System.out.println(jedis.get("test_name"));
    }

}
