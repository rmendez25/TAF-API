package seeds;

import com.github.javafaker.Faker;
import pojo.req.ProductRequest;

public class ProductSeeds {

    private static Faker faker = new Faker();
    private final static String image = "'https://i.pravatar.cc";

    public static ProductRequest createProductHappyPath = ProductRequest
            .builder()
            .title(faker.commerce().productName())
            .price(Double.parseDouble(faker.commerce().price()))
            .description(faker.lorem().words(4).toString())
            .image(image)
            .category(faker.commerce().department())
            .build();
}
