package org.github.caishijun.connection;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

/**
 * 连接到Redis
 */
public class ConnectToRedis001 {

    public static void main(String[] args) {

        // Syntax: redis://[password@]host[:port][/databaseNumber]
        //RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/0");
        RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis");

        connection.close();
        redisClient.shutdown();
    }

}
