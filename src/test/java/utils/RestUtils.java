package utils;

import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtils {
    public Response get(String url) {
        return given()
                .expect()
                .defaultParser(Parser.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public Response get(String url, Map<String, String> pathParams) {
        return given()
                .pathParams(pathParams)
                .expect()
                .defaultParser(Parser.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public Response post(String url, Object payload) {
        return given()
                .body(payload)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    public Response put(String url, Object payload, Map<String, String> pathParams) {
        return given()
                .pathParams(pathParams)
                .body(payload)
                .when()
                .put(url)
                .then()
                .extract()
                .response();
    }

    public Response delete(String url, Map<String, String> pathParams) {
        return given()
                .pathParams(pathParams)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}
