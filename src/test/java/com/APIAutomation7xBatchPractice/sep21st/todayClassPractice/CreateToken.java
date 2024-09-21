package com.APIAutomation7xBatchPractice.sep21st.todayClassPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateToken {

    String actualToken;
    RequestSpecification varRestAssured =  RestAssured.given();

    String tokenPayload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    @Test
    public String createTokenMethod(){

        varRestAssured.baseUri("https://restful-booker.herokuapp.com/auth");
        varRestAssured.contentType("application/json");
        varRestAssured.body(tokenPayload);

        Response tokenResponse = varRestAssured.when().post();
//        ValidatableResponse response = (ValidatableResponse) tokenResponse.then().log();

        actualToken = tokenResponse.jsonPath().get("token");

        System.out.println("Generated token is : >>> "+actualToken);

        return actualToken;
    }
}
