package dev.selec.backend.spring.kafka.usercartproducer.util;

import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class UserCartRandom {

    public static String getRandomName() {
        Faker faker = new Faker();
        return faker.name().name();
    }

    public static String getRandomCompanyName() {
        Faker faker = new Faker();
        return faker.company().name();
    }

    public static String getRandomProductName() {
        Faker faker = new Faker();
        return faker.beer().name();
    }
    public static Integer getRandomProductId() {
        return ThreadLocalRandom.current().nextInt(1, 10000);
    }

    public static Long getRandomUserId() {
        return ThreadLocalRandom.current().nextLong(1L, 1000000L);
    }

    public static Double getRandomProductPrice() {
        double price = ThreadLocalRandom.current().nextDouble() * 100;
        BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static Integer getRandomQuantity() {
        return ThreadLocalRandom.current().nextInt(10) + 1;
    }

}
