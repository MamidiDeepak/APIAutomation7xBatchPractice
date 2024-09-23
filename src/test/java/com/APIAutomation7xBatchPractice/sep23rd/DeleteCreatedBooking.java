package com.APIAutomation7xBatchPractice.sep23rd;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteCreatedBooking {

    RequestSpecification varDeleteGiven = RestAssured.given();

    GetUpdatedBookingDetails id = new GetUpdatedBookingDetails();
   String bookingId = id.getUpdatedBookingDetails();

   CreateToken tokken = new CreateToken();
   String token = tokken.getToken();

    @Test
    public String deleteCreateBooking(){

        varDeleteGiven.baseUri("https://restful-booker.herokuapp.com");
        varDeleteGiven.basePath("/booking/"+bookingId);
        varDeleteGiven.contentType("application/json");
        varDeleteGiven.cookie("token",token);

        Response response = varDeleteGiven.when().delete();

        System.out.println(response.asString());

        return bookingId;
    }
}
