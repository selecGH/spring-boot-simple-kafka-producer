package dev.selec.backend.spring.kafka.usercartproducer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsercartProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UsercartProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
