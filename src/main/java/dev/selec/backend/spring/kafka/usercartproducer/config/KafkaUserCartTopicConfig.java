package dev.selec.backend.spring.kafka.usercartproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class KafkaUserCartTopicConfig {

    private final KafkaTopicUserCartProps props;

    @Bean
    public NewTopic userCartTopic() {
        return TopicBuilder.name(props.getName())
                .replicas(props.getReplicas())
                .partitions(props.getPartitions())
                .build();
    }

}
