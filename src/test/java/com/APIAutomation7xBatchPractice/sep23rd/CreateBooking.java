package com.APIAutomation7xBatchPractice.sep23rd;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

public class CreateBooking {

    String bookingId;

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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Creation of Booking Id.")
    @Test
    public void getBookingId(ITestContext context){

        varCreateGiven.baseUri("https://restful-booker.herokuapp.com");
        varCreateGiven.basePath("/booking");
        varCreateGiven.contentType("application/json");
        varCreateGiven.body(requestPayload);

        Response response = varCreateGiven.when().post();

//        System.out.println(response.asString());

        JsonPath jsonPath = new JsonPath(response.asString());

        bookingId = jsonPath.getString("bookingid");
        assertThat(bookingId).isNotNull().isLessThanOrEqualTo("5000");

        String firstName = jsonPath.getString("booking.firstname");
        assertThat(firstName).isEqualToIgnoringCase("Deepak");

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
       assertThat(responseTime).isLessThan(5000L);

       String contentType = response.getHeader("Content-Type");
       assertThat(contentType).isEqualTo("application/json; charset=utf-8");

       Headers headers = response.getHeaders();
//        System.out.println(headers);

        for(Header h :headers){
                System.out.println(h.getName()+ " = " +h.getValue());
        }

        System.out.println("_____________________________");

        context.setAttribute("bookedId", bookingId);
    }
}
