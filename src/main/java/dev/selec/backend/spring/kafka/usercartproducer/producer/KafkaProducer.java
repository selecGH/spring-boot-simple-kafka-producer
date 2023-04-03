package dev.selec.backend.spring.kafka.usercartproducer.producer;

import dev.selec.backend.spring.kafka.usercartproducer.exception.UserCartProducerException;
import dev.selec.backend.spring.kafka.usercartproducer.model.UserCart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, UserCart> kafkaTemplate;

    @EventListener(ApplicationStartedEvent.class)
    public void onStart() {
        Executors.newSingleThreadExecutor().submit(() -> {
            while (true) {
                UserCart userCart = UserCart.createRandom();
                log.info("Send new cart to Kafka topic {}", userCart.toString());
                CompletableFuture<SendResult<String, UserCart>> send = kafkaTemplate.send("user-carts", userCart);
                send.whenComplete((data, throwable) -> {
                   if (throwable != null) {
                       log.error("Received error during kafka sending message: {}", throwable.getMessage());
                   }
                });
                sleep(10000L);
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
