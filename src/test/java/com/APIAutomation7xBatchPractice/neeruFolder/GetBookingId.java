package com.APIAutomation7xBatchPractice.neeruFolder;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GetBookingId {

    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response response;
    ValidatableResponse vr;

    @Test
    public void createBooking(){
        CreateBookingRequest cbr = new CreateBookingRequest();
        String payload = cbr.bookingRequest();

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType("application/json");
        rs.body(payload);

        response = rs.when().post();
        String convertedResponse = response.asString();

        vr = response.then().statusCode(200);

        String bookingId = response.jsonPath().getString("bookingid");
        System.out.println("Booking Id is : "+bookingId);

        Gson gson = new Gson();
        ResponsePojo responseBackToString = gson.fromJson(convertedResponse,ResponsePojo.class);

        System.out.println(("Id after de-serialization : " +responseBackToString.getBookingid()));

        responseBackToString.getBookingid();

        responseBackToString.getBook().getFirstname();
        responseBackToString.getBook().getLastname();
        responseBackToString.getBook().getTotalprice();
        responseBackToString.getBook().getDepositpaid();
        responseBackToString.getBook().getBookingdates();
        responseBackToString.getBook().getAdditionalneeds();




//        return bookingId;
    }
}
