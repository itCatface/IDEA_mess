package cc.catface.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
/* redis当前有五种数据类型：String、List、Hash、Set、Sorted Set */
public class TestRedisCommands {

    JedisPool jedisPool;
    Jedis jedis;

    @Before
    public void setUp() {
        jedis = new Jedis("localhost");
    }


    @Test   // String基操
    public void testString() {
        jedis.set("test_name", "ahri");
        System.out.println(jedis.get("test_name") + "---\r\n");

        jedis.append("test_name", "_lol");
        System.out.println(jedis.get("test_name") + "---\r\n");


        jedis.set("test_name", "akali");
        System.out.println(jedis.get("test_name") + "---\r\n");

        jedis.del("test_name");
        System.out.println(jedis.get("test_name") + "---\r\n");

        /* 添加map:{"name":"alistar", "sex":"male"} */
        jedis.mset("name", "alistar", "sex", "male");
        System.out.println(jedis.mget("name") + " || " + jedis.mget("sex") + "---\r\n");
    }


    @Test   // map基操
    public void testMap() {
        Map<String, String> user = new HashMap<>();
        user.put("name", "amumu");
        user.put("sex", "boy");
        user.put("pwd", "password");
        jedis.hmset("user", user);
        List<String> rsmap = jedis.hmget("user", "name", "sex", "pwd");
        System.out.println(rsmap + "---\r\n");

        System.out.println(jedis.hmget("user", "name"));
        System.out.println(jedis.hlen("user"));
        System.out.println(jedis.exists("user"));
        jedis.hdel("user", "pwd");
        System.out.println(jedis.hkeys("user"));
        System.out.println(jedis.hvals("user"));

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
    }


    @Test   // list基操
    public void testList() {
        jedis.del("test_list");
        System.out.println("---\r\n" + jedis.lrange("test_list", 0, -1) + "---\r\n");  // -1表示从0到所有的位置
        jedis.lpush("test_list", "spring");
        jedis.lpush("test_list", "spring_mvc");
        jedis.lpush("test_list", "mybatis");
        jedis.rpush("test_list", "right_stand...");
        System.out.println(jedis.lrange("test_list", 0, -1) + "---\r\n");
    }


    @Test   // set基操
    public void testSet() {
        jedis.sadd("sname", "avinia");
        jedis.sadd("sname", "annie");
        jedis.sadd("sname", "ashe");
        jedis.sadd("sname", "blitzcrank");
        jedis.sadd("sname", "brand");
        jedis.sadd("sname", "caitlyn");
        jedis.srem("sname", "blitzcrank");
        System.out.println(jedis.smembers("sname"));    // 所有value
        System.out.println(jedis.sismember("sname", "meepo"));  // 元素是否存在于set内
        System.out.println(jedis.srandmember("sname"));
        System.out.println(jedis.scard("sname"));   // 元素个数
    }


    @Test
    public void test() throws InterruptedException {
        System.out.println(jedis.keys("*"));    // 库中所有key
        System.out.println(jedis.keys("*name"));    // 库中所有包含模糊name的key
        System.out.println(jedis.del("sanmdde"));   //删除该key-value(成功1失败0)
        System.out.println(jedis.ttl("sname")); // 指定key有效期(-1永久有效)
        jedis.setex("timekey", 10, "min");  // 指定key有效期(s)

        /*  */
        Thread.sleep(5000);

        System.out.println(jedis.ttl("timekey"));
        jedis.setex("timekey", 1, "min");
        System.out.println(jedis.ttl("timekey"));
        System.out.println(jedis.exists("key"));
        System.out.println(jedis.rename("timekey", "time"));
        System.out.println(jedis.get("timekey"));
        System.out.println(jedis.get("time"));

        // lpush/rpush操作双向链表
        jedis.del("a");
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));
        System.out.println(jedis.sort("a"));
        System.out.println(jedis.lrange("a", 0, -1));
    }
}
