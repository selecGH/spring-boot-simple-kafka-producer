package dev.selec.backend.spring.kafka.usercartproducer.config;

import dev.selec.backend.spring.kafka.usercartproducer.model.UserCart;
import dev.selec.backend.spring.kafka.usercartproducer.serializer.UserCartSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaClusterConfig clusterConfig;

    public Map<String, Object> kafkaProps() {
        HashMap<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, clusterConfig.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UserCartSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String, UserCart> kafkaProducerFactory() {
        return new DefaultKafkaProducerFactory<>(kafkaProps());
    }

    @Bean
    public KafkaTemplate<String, UserCart> kafkaTemplate(ProducerFactory<String, UserCart> kafkaProducerFactory) {
        return new KafkaTemplate<>(kafkaProducerFactory);
    }

}
