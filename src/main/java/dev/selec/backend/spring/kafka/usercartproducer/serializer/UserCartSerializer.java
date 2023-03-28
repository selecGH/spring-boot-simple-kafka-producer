package dev.selec.backend.spring.kafka.usercartproducer.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.selec.backend.spring.kafka.usercartproducer.exception.UserCartProducerException;
import dev.selec.backend.spring.kafka.usercartproducer.model.UserCart;
import org.apache.kafka.common.serialization.Serializer;

public class UserCartSerializer implements Serializer<UserCart> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, UserCart userCart) {
        if (userCart == null) {
            throw new UserCartProducerException("Received null user cart in serializer");
        }
        try {
            return objectMapper.writeValueAsBytes(userCart);
        } catch (JsonProcessingException e) {
            throw new UserCartProducerException("Producer exception while serializing the user cart...!", e.getCause());
        }
    }

}
