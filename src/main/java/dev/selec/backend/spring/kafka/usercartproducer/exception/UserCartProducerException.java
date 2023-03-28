package dev.selec.backend.spring.kafka.usercartproducer.exception;

public class UserCartProducerException extends RuntimeException {
    public UserCartProducerException(String message) {
        super(message);
    }

    public UserCartProducerException(String message, Throwable cause) {
        super(message, cause);
    }
}
