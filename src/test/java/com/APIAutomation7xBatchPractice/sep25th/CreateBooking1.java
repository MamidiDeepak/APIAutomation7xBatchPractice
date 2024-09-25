package com.APIAutomation7xBatchPractice.sep25th;

import com.APIAutomation7xBatchPractice.sep25th.PojoClasses.BookingClass;
import com.APIAutomation7xBatchPractice.sep25th.PojoClasses.BookingDatesClass;
import com.APIAutomation7xBatchPractice.sep25th.PojoClasses.BookingResponse;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class CreateBooking1 {

    @Test
    void createBooking1(){

     BookingClass bookingData = new BookingClass();
     bookingData.setFirstname("Deepak");
     bookingData.setLastname("Mamidi");
     bookingData.setTotalprice(505);
     bookingData.setDepositpaid(false);

     BookingDatesClass bookingDates = new BookingDatesClass();
     bookingDates.setCheckin("2024-09-25");
     bookingDates.setCheckout("2024-09-30");

     bookingData.setBookingdates(bookingDates);
     bookingData.setAdditonalneeds("Dinner");

//     System.out.println(bookingData);

     Gson gson = new Gson();
     String converetedPayload = gson.toJson(bookingData);
     System.out.println("Converted Payload "+converetedPayload);

     RequestSpecification postVariable = RestAssured.given();
     postVariable.baseUri("https://restful-booker.herokuapp.com");
     postVariable.basePath("/booking");
     postVariable.contentType("application/json");
     postVariable.body(converetedPayload);

     Response response = postVariable.when().post();

     String convertedResponse = response.asString();

     System.out.println("Converted Response "+convertedResponse);


     BookingResponse bookingResponseForAssertion = gson.fromJson(convertedResponse, BookingResponse.class);
     System.out.println(bookingResponseForAssertion.getBookingid());

     assertThat(bookingResponseForAssertion.getBooking().getFirstname()).isEqualTo("Deepak");















    }
}

