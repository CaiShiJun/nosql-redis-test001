package org.github.caishijun.basicusage;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.concurrent.ExecutionException;

/**
 * 基本使用
 */
public class BasicUsage001 {

    public static void main(String[] args) {
        simpleSync();
        simpleAsync();
    }

    private static void simpleSync(){
        RedisClient client = RedisClient.create(RedisURI.create("redis://localhost:6379"));
        StatefulRedisConnection<String, String> connect = client.connect();

        /* 同步执行的命令 */
        RedisCommands<String, String> commands = connect.sync();

        String setReturn = commands.set("BasicUsage001_simpleSync","SSSSSS");
        System.out.println("Sync : "+setReturn);
        String getReturn = commands.get("BasicUsage001_simpleSync");
        System.out.println("Sync : "+getReturn);

        connect.close();
        client.shutdown();
    }

    private static void simpleAsync(){
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connect = client.connect();

        /*  异步执行的命令  */
        RedisAsyncCommands<String, String> commands = connect.async();

        try {
            RedisFuture<String> setFuture = commands.set("BasicUsage001_simpleAsync","AAAAAA");
            System.out.println("Async : "+setFuture.get());
            RedisFuture<String> getFuture = commands.get("BasicUsage001_simpleAsync");
            System.out.println("Async : "+getFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            connect.close();
            client.shutdown();
        }

    }

}
