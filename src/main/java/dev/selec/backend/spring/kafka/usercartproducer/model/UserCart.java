package dev.selec.backend.spring.kafka.usercartproducer.model;

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
    private LocalDateTime createdAt = LocalDateTime.now();

}
