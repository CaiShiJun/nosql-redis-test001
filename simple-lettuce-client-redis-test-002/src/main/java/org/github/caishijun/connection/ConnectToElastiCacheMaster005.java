package org.github.caishijun.connection;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.resource.DefaultClientResources;
import io.lettuce.core.resource.DirContextDnsResolver;

/**
 * 连接到单个 可扩展缓存 主节点
 */
public class ConnectToElastiCacheMaster005 {

    public static void main(String[] args) {

        // Syntax: redis://[password@]host[:port][/databaseNumber]

        DefaultClientResources clientResources = DefaultClientResources.builder() //
                .dnsResolver(new DirContextDnsResolver()) // Does not cache DNS lookups
                .build();

        RedisClient redisClient = RedisClient.create(clientResources, "redis://password@localhost:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis");

        connection.close();
        redisClient.shutdown();
    }

}
