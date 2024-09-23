package com.APIAutomation7xBatchPractice.sep23rd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetUpdatedBookingDetails {

    RequestSpecification varGetGiven = RestAssured.given();

    UpdateCreatedBooking id = new UpdateCreatedBooking();
    String bookingId = id.updateExistingBooking();

    @Test
    public String getUpdatedBookingDetails(){

            varGetGiven.baseUri("https://restful-booker.herokuapp.com");
            varGetGiven.basePath("/booking/"+bookingId);
            varGetGiven.contentType("application/json");

            Response response = varGetGiven.when().get();

//        System.out.println(response.asString());

        JsonPath jsonPath = new JsonPath(response.asString());
        String fName = jsonPath.getString("firstname");
        assertThat(fName).isEqualToIgnoringCase("Rohit");
        System.out.println("first Name is : "+fName);

        int statusCode = response.statusCode();
        assertThat(statusCode).isEqualTo(200);
        System.out.println("Status Code is : "+statusCode);

        String statusText = response.statusLine();
        assertThat(statusText).isEqualTo("HTTP/1.1 200 OK");
        System.out.println("Status Text is : "+statusText);

        long responseTime = response.getTime();
        assertThat(responseTime).isBetween(0L,5000L);
        System.out.println("Response Time is : "+responseTime);

        return bookingId;

    }
}
