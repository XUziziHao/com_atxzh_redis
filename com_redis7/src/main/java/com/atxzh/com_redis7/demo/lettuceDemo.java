package com.atxzh.com_redis7.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.List;

public class lettuceDemo {
    public static void main(String[] args) {
        //使用构建器
        RedisURI uri = RedisURI.builder().redis("10.0.0.200")
                .withPort(6379)
                .withAuthentication("default","123456")
                .build();
        //创建连接客户端
        RedisClient redisClient = RedisClient.create(uri);
        StatefulRedisConnection connect = redisClient.connect();

        //创建操作的Command
        RedisCommands commands = connect.sync();

        //keys
        List keys = commands.keys("*");

        //String
        commands.set("k5","hello");
        System.out.println(commands.get("k5"));




        //关闭释放资源
        connect.close();
        redisClient.shutdown();
    }
}
