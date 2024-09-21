package com.APIAutomation7xBatchPractice.sep21st;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUser {

    RequestSpecification r = RestAssured.given();

    String payload = " {\n" +
            "     \"name\": \"deepu\",\n" +
            "      \"location\": \"hyderabd\",\n" +
            "      \"course\": [\n" +
            "        \"java\",\n" +
            "        \"selenium\"\n" +
            "      ]\n" +
            "    }";

    @Test
    public void createUserAPI(ITestContext context) {
        r.baseUri("http://localhost:3000/students");
        r.contentType("application/json").log().all();
        r.body(payload);

        Response response = r.when().post();

        ValidatableResponse result = response.then()
                .log().all();

        String id = response.jsonPath().get("id");

        System.out.println("Created id is : >>>>> "+id);

        context.setAttribute("userId", id);

    }
}
