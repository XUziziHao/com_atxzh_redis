package com.atxzh.com_redis7.demo;

import redis.clients.jedis.Jedis;

public class jedisDemo {
    public static void main(String[] args) {

        //获得redis的连接。
        Jedis jedis = new Jedis("10.0.0.200", 6379);

        //指定访问服务器的密码
        jedis.auth("123456");

        //访问redis客户端
        System.out.println(jedis.ping());
    }
}
