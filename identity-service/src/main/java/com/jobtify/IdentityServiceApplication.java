package com.jobtify;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Slf4j
@EnableJpaAuditing
@SpringBootApplication
public class IdentityServiceApplication implements CommandLineRunner {

    private static RedisConnectionFactory redisConnectionFactory;

    public IdentityServiceApplication(RedisConnectionFactory redisConnectionFactory) {
        IdentityServiceApplication.redisConnectionFactory = redisConnectionFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(IdentityServiceApplication.class, args);

        log.info("REDIS STATUS: " + redisConnectionFactory.getConnection().ping());
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
