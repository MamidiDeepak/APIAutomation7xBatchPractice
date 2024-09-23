package com.APIAutomation7xBatchPractice.sep23rd;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
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

        assert firstName != null;
        assert checkOutDate != null;

       int statusCode = response.statusCode();
       assertThat(statusCode).isEqualTo(200);

       String brkfst = jsonPath.getString("booking.additionalneeds");
       assertThat(brkfst).isEqualTo("Breakfast");

       String statusText = response.statusLine();
       assertThat(statusText).isEqualTo("HTTP/1.1 200 OK");

       long responseTime = response.getTime();
       assertThat(responseTime).isLessThan(3000L);

       String contentType = response.getHeader("Content-Type");
       assertThat(contentType).isEqualTo("application/json; charset=utf-8");

       Headers headers = response.getHeaders();
//        System.out.println(headers);

        for(Header h :headers){

            if(h.equals("Content-Type")){
                System.out.println("From for and if loop " +response.getHeader("Content-Type"));
            }
        }


    }
}
