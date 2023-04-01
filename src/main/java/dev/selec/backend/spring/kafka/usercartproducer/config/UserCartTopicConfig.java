package dev.selec.backend.spring.kafka.usercartproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class UserCartTopicConfig {

    @Bean
    public NewTopic userCartTopic() {
        return TopicBuilder.name("user-carts")
                .replicas(2)
                .partitions(2)
                .build();
    }

}
