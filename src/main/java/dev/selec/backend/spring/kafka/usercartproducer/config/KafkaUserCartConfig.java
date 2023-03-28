package dev.selec.backend.spring.kafka.usercartproducer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka-topic")
@Data
public class KafkaUserCartConfig {
    private String userCart;
}
