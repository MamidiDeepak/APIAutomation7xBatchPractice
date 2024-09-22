package com.APIAutomation7xBatchPractice.sep21st.todayClassPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class UpdateBooking {

    RequestSpecification varUpdateGiven = RestAssured.given();

    @Test
    public void updateBookingUsingExistingBooking(){

        CreateToken ct = new CreateToken();
        String token = ct.createTokenMethod();

        CreateBooking createdBookingIdInUpdate = new CreateBooking();
        int id = createdBookingIdInUpdate.bookingId;

        String updateRequestPayload = "{\n" +
                "    \"firstname\" : \"Shah\",\n" +
                "    \"lastname\" : \"Khan\",\n" +
                "    \"totalprice\" : 991,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        varUpdateGiven.baseUri("https://restful-booker.herokuapp.com");
        varUpdateGiven.basePath("/booking/"+id);
//        varUpdateGiven.header("Authorization", "Bearer "+token);

//        varUpdateGiven.contentType(ContentType.JSON);
        varUpdateGiven.cookie("token",token);
        varUpdateGiven.contentType("application/json");
        varUpdateGiven.body(updateRequestPayload);

        Response res = varUpdateGiven.when().put();

        res.then().log().all().statusCode(200);
    }
}
