package com.APIAutomation7xBatchPractice.sep25th;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateToken1 {

    RequestSpecification varToken = RestAssured.given();

    String tokenPayload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    @Test
    void createToken1(){

        varToken.baseUri("https://restful-booker.herokuapp.com");
        varToken.basePath("/auth");
        varToken.contentType("application/json");
        varToken.body(tokenPayload);

        Response tokenResponse = varToken.when().post();

//        String stringResponse = tokenResponse.jsonPath().getString("token");
        String stringResponse = tokenResponse.asString();
//        System.out.println(stringResponse);

        String generatedToken = tokenResponse.jsonPath().getString("token");
        System.out.println("Generated token is : "+generatedToken);


    }
}
