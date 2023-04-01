package dev.selec.backend.spring.kafka.usercartproducer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.selec.backend.spring.kafka.usercartproducer.serializer.JsonDateDeserializer;
import dev.selec.backend.spring.kafka.usercartproducer.serializer.JsonDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class UserCart implements Serializable {

    @Serial
    private static final long serialVersionUID = -8084879420242414947L;

    private Long userId;
    private List<UserProduct> products;

    @Builder.Default
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    public static UserCart createRandom() {
        return UserCart.builder()
                .userId(1L)
                .products(List.of(UserProduct.builder()
                                .product(Product.builder()
                                        .id(1)
                                        .name("product_name")
                                        .company("company")
                                        .price(12.4)
                                        .build())
                                .quantity(1)
                        .build()))
                .build();
    }

}
