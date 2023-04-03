package dev.selec.backend.spring.kafka.usercartproducer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "internal.kafka.topics.user-carts")
@Data
public class KafkaTopicUserCartProps {
    private String name;
    private Integer partitions;
    private Integer replicas;
}
