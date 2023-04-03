package dev.selec.backend.spring.kafka.usercartproducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UsercartProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsercartProducerApplication.class, args);
    }

}
