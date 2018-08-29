package org.github.caishijun.connection;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;

public class MySpringBean008 {

    private RedisClient redisClient;

    @Autowired
    public void setRedisClient(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    public String ping() {

        StatefulRedisConnection<String, String> connection = redisClient.connect();

        RedisCommands<String, String> sync = connection.sync();
        String result = sync.ping();
        connection.close();
        return result;
    }

}
