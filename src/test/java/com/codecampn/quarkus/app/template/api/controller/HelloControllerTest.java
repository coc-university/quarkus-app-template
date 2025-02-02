package com.codecampn.quarkus.app.template.api.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HelloControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello/json")
          .then()
                .statusCode(200)
                .body(is("Hello json"));
    }

}