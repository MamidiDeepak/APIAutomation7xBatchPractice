package com.APIAutomation7xBatchPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class sep19th {

    RequestSpecification r = RestAssured.given();
    String payload = "{\n" +
            "    \"name\": \"Deepak\",\n" +
            "    \"job\": \"Mamidi\"\n" +
            "}";

    //    public static void main(String[] args) {
    @Test
    public void createUser(){


            r.baseUri("https://reqres.in");
            r.basePath("/api/users");
            r.contentType("application/json").log().all();

            TestUserCreation();

    }

        public void TestUserCreation(){

            r.body(payload);
            Response response = r.when().post();

            ValidatableResponse vr = response.then();
            vr.statusCode(201);
        }

}
