package com.APIAutomation7xBatchPractice.sep23rd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetDeletedBookingDetails {

    RequestSpecification varGetGiven = RestAssured.given();

    DeleteCreatedBooking id = new DeleteCreatedBooking();
    String bookingId = id.deleteCreateBooking();

    @Test
    public String getDeletedBookingDetails(){

            varGetGiven.baseUri("https://restful-booker.herokuapp.com");
            varGetGiven.basePath("/booking/"+bookingId);
            varGetGiven.contentType("application/json");

            Response response = varGetGiven.when().get();

//        System.out.println(response.asString());

        int statusCode = response.statusCode();
        assertThat(statusCode).isEqualTo(204);
        System.out.println("Status Code is : "+statusCode);

        long responseTime = response.getTime();
        assertThat(responseTime).isBetween(0L,5000L);
        System.out.println("Response Time is : "+responseTime);

        return bookingId;

    }
}
