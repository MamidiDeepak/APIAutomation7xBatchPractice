package com.APIAutomation7xBatchPractice.sep21st;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteClass {

    RequestSpecification r = RestAssured.given();

    @Test
    public void deleteCreatedDetails(ITestContext context){

        String id = (String) context.getAttribute("userId");

        r.baseUri("http://localhost:3000/students/"+id);

        Response response = r.when().delete();

        ValidatableResponse result = response.then()
                .log().all();

        System.out.println("deleted id is : >>>>> "+id);

    }
}
