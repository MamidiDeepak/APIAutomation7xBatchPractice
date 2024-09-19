package com.APIAutomation7xBatchPractice.sep18;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreateUser {

//    public static void main(String[] args) {

    @Test
   void testM() {

        String payLoad = "{\n" +
                "    \"name\": \"deepak\",\n" +
                "    \"job\": \"qa\"\n" +
                "}";

        RestAssured.given().baseUri("https://reqres.in")
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                .body(payLoad)
                .when().post()
                .then().log().all().statusCode(201);
    }
}
