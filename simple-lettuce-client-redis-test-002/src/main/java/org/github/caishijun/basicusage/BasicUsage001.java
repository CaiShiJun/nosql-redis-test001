package org.github.caishijun.basicusage;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * 基本使用
 */
public class BasicUsage001 {

    public static void main(String[] args){
        RedisClient client = RedisClient.create("redis://localhost");

        StatefulRedisConnection<String, String> connection = client.connect();

        RedisCommands<String, String> commands = connection.sync();

        String setResult = commands.set("foo","bar");
        String getResult = commands.get("foo");

        System.out.println("setResult："+setResult);
        System.out.println("getResult："+getResult);

        connection.close();
        client.shutdown();

    }

}
