package com.APIAutomation7xBatchPractice.sep23rd;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class CreateToken {

    RequestSpecification varGiven = RestAssured.given();

    String tokenPayload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    public String getToken(){

        varGiven.baseUri("https://restful-booker.herokuapp.com");
        varGiven.basePath("/auth");
        varGiven.contentType("application/json");
        varGiven.body(tokenPayload);

        Response response = varGiven.when().post();

        String actualToken = response.jsonPath().getString("token");

        System.out.println("Generated token is : >>> " +actualToken);

            int statusCode = response.statusCode();
            assertThat(statusCode).isEqualTo(200);
            System.out.println("Token-Status Code is : "+statusCode);

            String statusText = response.statusLine();
            assertThat(statusText).isEqualTo("HTTP/1.1 200 OK");
            System.out.println("Token-Status Text is : "+statusText);

            long time = response.getTime();
            assertThat(time).isBetween(1000L,3000L);
            System.out.println("Token-Response Time in ms : "+time);

            String contentData = response.getHeader("Content-Type");
            assertThat(contentData).isEqualTo("application/json; charset=utf-8");
            System.out.println("Token-Header is : "+contentData);

            ResponseBody responseBody = response.body();
            System.out.println("Token-Response Body is: "+responseBody.asString());

            assertThat(actualToken).isNotNull().isNotBlank();

            return actualToken;

    }
}
