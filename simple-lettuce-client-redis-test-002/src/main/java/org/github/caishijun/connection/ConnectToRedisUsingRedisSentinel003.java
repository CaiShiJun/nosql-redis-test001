package org.github.caishijun.connection;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

/**
 * 使用Redis Sentinel 哨兵连接到Redis
 */
public class ConnectToRedisUsingRedisSentinel003 {

    public static void main(String[] args) {

        // Syntax: redis-sentinel://[password@]host[:port][,host2[:port2]][/databaseNumber]#sentinelMasterId
        RedisClient redisClient = RedisClient.create("redis-sentinel://localhost:26379,localhost:26380/0#mymaster");

        StatefulRedisConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis using Redis Sentinel");

        connection.close();
        redisClient.shutdown();
    }

}
