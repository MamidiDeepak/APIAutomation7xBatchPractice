package com.APIAutomation7xBatchPractice.sep26th.FinalPractice;

import com.APIAutomation7xBatchPractice.sep26th.FinalPractice.pojoClasses.BookingResponseFields;
import com.APIAutomation7xBatchPractice.sep26th.FinalPractice.pojoClasses.CreateBookingDateFields;
import com.APIAutomation7xBatchPractice.sep26th.FinalPractice.pojoClasses.CreateBookingFields;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateBooking {

    RequestSpecification createBookingVariable = RestAssured.given();

    @Test
    public void getBookingId(){

        Faker fakeData = new Faker();

        CreateBookingFields bookingClassVariable = new CreateBookingFields();
        bookingClassVariable.setFirstname(fakeData.name().firstName());
        bookingClassVariable.setLastname(fakeData.name().lastName());
        bookingClassVariable.setTotalprice(Integer.valueOf(fakeData.number().digits(3)));
        bookingClassVariable.setDepositpaid(true);

        CreateBookingDateFields bookingDateClassVariable = new CreateBookingDateFields();
        bookingDateClassVariable.setCheckin("2024-09-26");
        bookingDateClassVariable.setCheckout("2024-09-26");

        bookingClassVariable.setBookingdates(bookingDateClassVariable);
        bookingClassVariable.setAdditionalneeds(fakeData.food().sushi());

//        Printing Java Object
//        System.out.println(bookingClassVariable);

//      Convert Java Object to Byte Stream / JSON Object

        Gson gson = new Gson();
        String jsonStringPayload = gson.toJson(bookingClassVariable);
//        System.out.println(jsonStringPayload);

        createBookingVariable.baseUri("https://restful-booker.herokuapp.com");
        createBookingVariable.basePath("/booking");
        createBookingVariable.contentType("application/json");
        createBookingVariable.body(jsonStringPayload);

        Response response = createBookingVariable.when().post();

//        Convert the response to String Object
        String convertedResponse = response.asString();
//        System.out.println(convertedResponse);

//        De-serialization
        BookingResponseFields backtoStringResponse = gson.fromJson(convertedResponse, BookingResponseFields.class);
        System.out.println(backtoStringResponse.getBookingid());

        assertThat(backtoStringResponse.getBookingFields().getFirstname()).isEqualTo("Deepak");

    }

}
