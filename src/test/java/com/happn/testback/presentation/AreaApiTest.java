package com.happn.testback.presentation;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AreaApiTest {

    @LocalServerPort
    private int port;

    @Before
    public void setup(){
        RestAssured.port = port;
    }

    @Test
    public void getAreaWithoutParametersMustReturnBadRequestStatus(){
        when()
                .get("/api/v0/areas").
        then()
                .statusCode(400);
    }

    @Test
    public void getAreaWithParametersMustReturnOkStatus(){
        given().
                param("minLat", 6.5).
                param("minLon", -7).
        when()
                .get("/api/v0/areas").
        then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("area-schema.json"));
    }
}
