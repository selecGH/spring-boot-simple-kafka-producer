package dev.selec.backend.spring.kafka.usercartproducer;

import dev.selec.backend.spring.kafka.usercartproducer.exception.UserCartProducerException;
import dev.selec.backend.spring.kafka.usercartproducer.model.UserCart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.Executors;

@SpringBootApplication
@Slf4j
public class UsercartProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsercartProducerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, UserCart> kafkaTemplate) {
        return args -> Executors.newSingleThreadExecutor().submit(() -> {
            while (true) {
                log.info("Send message to Kafka-topic");
                kafkaTemplate.send("user-carts", UserCart.createRandom());
                sleep(1000L);
            }
        });
    }

    private static void sleep(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new UserCartProducerException("Error produced while sleeping a Thread");
        }
    }
}
