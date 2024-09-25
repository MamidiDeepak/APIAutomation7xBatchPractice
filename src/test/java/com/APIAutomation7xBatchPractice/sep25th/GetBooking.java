package com.APIAutomation7xBatchPractice.sep25th;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetBooking {

    @Test
    void getCreatedBooking(ITestContext context){

        Integer bookingId1 = (Integer) context.getAttribute("bookingId");

        RequestSpecification getVariable = RestAssured.given();
        getVariable.baseUri("https://restful-booker.herokuapp.com");
        getVariable.basePath("/booking/"+4976);
        getVariable.contentType("application/json");


       Response response = getVariable.when().get();

        System.out.println(response);

        String convertedResponse = response.asString();
        System.out.println(convertedResponse);

    }
}
