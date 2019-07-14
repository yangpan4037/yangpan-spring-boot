package site.yangpan.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.redis.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * RedisController
 * Created by yangpan on 2019-07-14 17:08.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 一.RedisTemplate对5种数据结构操作:
     * redisTemplate.opsForValue();//操作字符串
     * redisTemplate.opsForHash();//操作hash
     * redisTemplate.opsForList();//操作list
     * redisTemplate.opsForSet();//操作set
     * redisTemplate.opsForZSet();//操作有序set
     *
     * 二.常用的方法：
     * delete();//删除操作
     * hasKey();//查看是否含有指定key
     * expire();//设置过期时间
     * getExpire();//获取过期时间
     * keys();//根据传入的正则表达式返回所有的key
     * persist();//取消指定key的过期时间
     * rename();//将指定key改成目标key
     *
     */


    /**
     * set方法
     * @param key
     * @return
     */
    @GetMapping("/set/{key}/{value}")
    public Object set(@PathVariable("key") String key, @PathVariable("value") String value){
        redisTemplate.opsForValue().set(key, value);
        Boolean expire = redisTemplate.expire(key, 30, TimeUnit.SECONDS);
        return "设置成功！";
    }


    /**
     * get方法
     * @param key
     * @return
     */
    @GetMapping("/get/{key}")
    public Object get(@PathVariable("key") String key){
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 移除
     * @param key
     * @return
     */
    @GetMapping("/delete/{key}")
    public Object delete(@PathVariable("key") String key){
        return redisTemplate.delete(key);
    }


    @GetMapping("/test")
    public void test(){
        User user1 = new User("111", "22", "333");
        User user2 = new User("111", "22", "333");

        //hash
        redisTemplate.opsForHash().put("hashValue","map1",user1);
        redisTemplate.opsForHash().put("hashValue","map2",user2);
        Map<String,User> map = redisTemplate.opsForHash().entries("hashValue");
        System.out.println("通过entries(H key)方法获取变量中的键值对:" + map);

        //list
        List list = new ArrayList();
        list.add(user1);
        list.add(user2);
        redisTemplate.opsForList().rightPushAll("listValue", list);
        List result = redisTemplate.opsForList().range("listValue", 0, -1);
        System.out.println("通过leftPushAll(K key, Collection<V> values)方法以集合的方式批量添加元素:" + result);

    }
}
