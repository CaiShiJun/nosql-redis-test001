package org.github.caishijun.connection;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LettuceWithSpring008 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringTest-context.xml");

        RedisClient client = context.getBean(RedisClient.class);

        StatefulRedisConnection<String, String> connection = client.connect();

        RedisCommands<String, String> sync = connection.sync();
        System.out.println("PING: " + sync.ping());
        connection.close();

        MySpringBean008 mySpringBean008 = context.getBean(MySpringBean008.class);
        System.out.println("PING: " + mySpringBean008.ping());

        context.close();
    }

}


