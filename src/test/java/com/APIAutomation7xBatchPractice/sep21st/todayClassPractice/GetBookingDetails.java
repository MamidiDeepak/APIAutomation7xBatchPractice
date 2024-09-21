package com.APIAutomation7xBatchPractice.sep21st.todayClassPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class GetBookingDetails {

    RequestSpecification varGiven = RestAssured.given();
    int id;
    @Test
    public void getBookingId(){

        CreateBooking createdBookingId = new CreateBooking();
        int id = createdBookingId.createBooking();
//        id = createdBookingId.bookingId;

        varGiven.baseUri("https://restful-booker.herokuapp.com");
        varGiven.basePath("booking/"+id);
//        varGiven.contentType("application/json");

        Response response = varGiven.when().get();

        String firstName = response.then().extract().path("firstname");

        assertThat(firstName).isEqualToIgnoringCase("Deepak");


    }
}
