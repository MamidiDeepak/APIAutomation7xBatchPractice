package com.APIAutomation7xBatchPractice.sep23rd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

public class CreateBooking {

    RequestSpecification varCreateGiven = RestAssured.given();

    String requestPayload = "{\n" +
            "    \"firstname\" : \"Deepak\",\n" +
            "    \"lastname\" : \"Mamidi\",\n" +
            "    \"totalprice\" : 444,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2024-10-01\",\n" +
            "        \"checkout\" : \"2024-10-06\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    @Test
    public void getBookingId(){

        varCreateGiven.baseUri("https://restful-booker.herokuapp.com");
        varCreateGiven.basePath("/booking");
        varCreateGiven.contentType("application/json");
        varCreateGiven.body(requestPayload);

        Response response = varCreateGiven.when().post();

        System.out.println(response.asString());

        JsonPath jsonPath = new JsonPath(response.asString());

        String bookingId = jsonPath.getString("bookingid");
        assertThat(bookingId).isNotNull().isLessThanOrEqualTo("5000");

        String firstName = jsonPath.getString("booking.firstname");
        assertThat(firstName).isEqualToIgnoringCase("deepak");

        String checkOutDate = jsonPath.getString("booking.bookingdates.checkout");
        assertThat(checkOutDate).isEqualTo("2024-10-06");

        assert firstName instanceof String;
        assert checkOutDate instanceof String;

       int statusCode = response.statusCode();
       assertThat(statusCode).isEqualTo(200);



    }
}
