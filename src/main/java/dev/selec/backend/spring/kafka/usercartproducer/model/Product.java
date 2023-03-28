package dev.selec.backend.spring.kafka.usercartproducer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = -8947004701156514167L;

    private Integer id;
    private String name;
    private String company;
    private Double price;

}
