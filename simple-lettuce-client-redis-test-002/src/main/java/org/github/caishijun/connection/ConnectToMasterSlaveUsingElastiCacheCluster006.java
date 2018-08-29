package org.github.caishijun.connection;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.codec.Utf8StringCodec;
import io.lettuce.core.masterslave.MasterSlave;
import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;

import java.util.Arrays;
import java.util.List;

/**
 * 连接到 可扩展缓存 的主从节点
 */
public class ConnectToMasterSlaveUsingElastiCacheCluster006 {

    public static void main(String[] args) {

        // Syntax: redis://[password@]host[:port][/databaseNumber]
        RedisClient redisClient = RedisClient.create();

        List<RedisURI> nodes = Arrays.asList(RedisURI.create("redis://host1"),
                RedisURI.create("redis://host2"),
                RedisURI.create("redis://host3"));

        StatefulRedisMasterSlaveConnection<String, String> connection = MasterSlave
                .connect(redisClient, new Utf8StringCodec(), nodes);
        connection.setReadFrom(ReadFrom.MASTER_PREFERRED);

        System.out.println("Connected to Redis");

        connection.close();
        redisClient.shutdown();
    }

}
