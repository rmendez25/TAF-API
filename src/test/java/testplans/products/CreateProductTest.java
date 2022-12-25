package testplans.products;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.req.ProductRequest;
import pojo.res.ProductResponse;
import utils.BaseTest;
import utils.RestUtils;

import static org.testng.AssertJUnit.assertEquals;
import static seeds.ProductSeeds.createProductHappyPath;

public class CreateProductTest extends BaseTest {

    @Test
    public void createProductHappyPath() {
        ProductRequest payload = createProductHappyPath;
        Response response = RestUtils.post("/products", payload);
        assertEquals(response.statusCode(), 200);

        ProductResponse productResponse = response.as(ProductResponse.class);
        assertEquals("21", productResponse.getId());
        assertEquals(payload.getTitle(), productResponse.getTitle());
        assertEquals(payload.getPrice(), productResponse.getPrice());
        assertEquals(payload.getDescription(), productResponse.getDescription());
        assertEquals(payload.getCategory(), productResponse.getCategory());
    }
}
