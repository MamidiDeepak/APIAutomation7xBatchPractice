package com.APIAutomation7xBatchPractice.sep25th;

import com.APIAutomation7xBatchPractice.sep25th.PojoClasses.BookingClass;
import com.APIAutomation7xBatchPractice.sep25th.PojoClasses.BookingDatesClass;
import com.APIAutomation7xBatchPractice.sep25th.PojoClasses.BookingResponse;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateBooking2 {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Creation of new User with valid details")
    @Test (groups = {"qa"})
    void createBookingWithValidDetails(ITestContext context){

     BookingClass bookingDetails = new BookingClass();
     bookingDetails.setFirstname("Deepak");
     bookingDetails.setLastname("Mamidi");
     bookingDetails.setTotalprice(10001);
     bookingDetails.setDepositpaid(true);

     BookingDatesClass bookingDates = new BookingDatesClass();
     bookingDates.setCheckin("2024-09-25");
     bookingDates.setCheckout("2024-09-25");

     bookingDetails.setBookingdates(bookingDates);
     bookingDetails.setAdditonalneeds("Lunch");

//     Converting Java Object to JsonObject
     Gson gson = new Gson();
     String convertedPayload = gson.toJson(bookingDetails);
     System.out.println(convertedPayload);

//     Sending Payload to api
     RequestSpecification postVariable = RestAssured.given();
     postVariable.baseUri("https://restful-booker.herokuapp.com");
     postVariable.basePath("/booking");
     postVariable.contentType("application/json");
     postVariable.body(convertedPayload);

//     Extracting the reponse
     Response jsonResponse = postVariable.when().post();
//     Convert the Json Response to String
     String convertedResponse = jsonResponse.asString();
     System.out.println(convertedResponse);

//Assertion
     int code = jsonResponse.statusCode();
     assertThat(code).isEqualTo(200);

     String statusText = jsonResponse.statusLine();
     assertThat(statusText).isEqualTo("HTTP/1.1 200 OK");

     long responseTime = jsonResponse.getTime();
     assertThat(responseTime).isBetween(0L,3000L);

     String headerValue = jsonResponse.getHeader("Content-Type");
     assertThat(headerValue).contains("application/json");

//     Convert JsonResponse to String Object
     BookingResponse bookingResponse = gson.fromJson(convertedResponse, BookingResponse.class);
     Integer id = bookingResponse.getBookingid();
     System.out.println(id);

//     Assertion
     assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Deepak");
     assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("Mamidi");
     assertThat(bookingResponse.getBooking().getBookingdates().getCheckin()).isEqualTo("2024-09-25");
     assertThat(bookingResponse.getBooking().getAdditonalneeds()).isNotNull();

     context.setAttribute("bookingId",id);
    }


 @Severity(SeverityLevel.NORMAL)
 @Description("Test Creation of new User by keeping last name field blank")
 @Test (groups = {"qa"})
 void createBookingWithBlankLastName(){

  BookingClass bookingDetails = new BookingClass();
  bookingDetails.setFirstname("Deepak");
  bookingDetails.setLastname(" ");
  bookingDetails.setTotalprice(10001);
  bookingDetails.setDepositpaid(true);

  BookingDatesClass bookingDates = new BookingDatesClass();
  bookingDates.setCheckin("2024-09-25");
  bookingDates.setCheckout("2024-090-25");

  bookingDetails.setBookingdates(bookingDates);
  bookingDetails.setAdditonalneeds("Lunch");

//     Converting Java Object to JsonObject
  Gson gson = new Gson();
  String convertedPayload = gson.toJson(bookingDetails);
  System.out.println(convertedPayload);

//     Sending Payload to api
  RequestSpecification postVariable = RestAssured.given();
  postVariable.baseUri("https://restful-booker.herokuapp.com");
  postVariable.basePath("/booking");
  postVariable.contentType("application/json");
  postVariable.body(convertedPayload);

//     Extracting the reponse
  Response jsonResponse = postVariable.when().post();
//     Convert the Json Response to String
  String convertedResponse = jsonResponse.asString();
  System.out.println(convertedResponse);

//Assertion
  int code = jsonResponse.statusCode();
  assertThat(code).isEqualTo(200);

  String statusText = jsonResponse.statusLine();
  assertThat(statusText).isEqualTo("HTTP/1.1 200 OK");

  long responseTime = jsonResponse.getTime();
  assertThat(responseTime).isBetween(0L,3000L);

  String headerValue = jsonResponse.getHeader("Content-Type");
  assertThat(headerValue).contains("application/json");

 }

 @Severity(SeverityLevel.NORMAL)
 @Description("Test Creation of new User by keeping numbers in last name field")
 @Test (groups = {"qa"})
 void createBookingWithNumbersInLastNameField(){

  BookingClass bookingDetails = new BookingClass();
  bookingDetails.setFirstname("Deepak");
  bookingDetails.setLastname("565789");
  bookingDetails.setTotalprice(10001);
  bookingDetails.setDepositpaid(true);

  BookingDatesClass bookingDates = new BookingDatesClass();
  bookingDates.setCheckin("2024-09-25");
  bookingDates.setCheckout("2024-090-25");

  bookingDetails.setBookingdates(bookingDates);
  bookingDetails.setAdditonalneeds("Lunch");

//     Converting Java Object to JsonObject
  Gson gson = new Gson();
  String convertedPayload = gson.toJson(bookingDetails);
  System.out.println(convertedPayload);

//     Sending Payload to api
  RequestSpecification postVariable = RestAssured.given();
  postVariable.baseUri("https://restful-booker.herokuapp.com");
  postVariable.basePath("/booking");
  postVariable.contentType("application/json");
  postVariable.body(convertedPayload);

//     Extracting the reponse
  Response jsonResponse = postVariable.when().post();
//     Convert the Json Response to String
  String convertedResponse = jsonResponse.asString();
  System.out.println(convertedResponse);

//Assertion
  int code = jsonResponse.statusCode();
  assertThat(code).isEqualTo(200);

  String statusText = jsonResponse.statusLine();
  assertThat(statusText).isEqualTo("HTTP/1.1 200 OK");

  long responseTime = jsonResponse.getTime();
  assertThat(responseTime).isBetween(0L,3000L);

  String headerValue = jsonResponse.getHeader("Content-Type");
  assertThat(headerValue).contains("application/json");
 }

 @Severity(SeverityLevel.NORMAL)
 @Description("Test Creation of new User by leaving Booking Dates field empty")
 @Test (groups = {"qa"})
 void createBookingByLeavingBookingDatesFieldEmpty(){

  BookingClass bookingDetails = new BookingClass();
  bookingDetails.setFirstname("Deepak");
  bookingDetails.setLastname("565789");
  bookingDetails.setTotalprice(10001);
  bookingDetails.setDepositpaid(true);

  BookingDatesClass bookingDates = new BookingDatesClass();
  bookingDates.setCheckin("2024-09-25");
  bookingDates.setCheckout("2024-090-25");

//  bookingDetails.setBookingdates(bookingDates);
  bookingDetails.setAdditonalneeds("Lunch");

//     Converting Java Object to JsonObject
  Gson gson = new Gson();
  String convertedPayload = gson.toJson(bookingDetails);
  System.out.println(convertedPayload);

//     Sending Payload to api
  RequestSpecification postVariable = RestAssured.given();
  postVariable.baseUri("https://restful-booker.herokuapp.com");
  postVariable.basePath("/booking");
  postVariable.contentType("application/json");
  postVariable.body(convertedPayload);

//     Extracting the reponse
  Response jsonResponse = postVariable.when().post();
//     Convert the Json Response to String
  String convertedResponse = jsonResponse.asString();
  System.out.println(convertedResponse);

//Assertion
  int code = jsonResponse.statusCode();
  assertThat(code).isEqualTo(500);

  String statusText = jsonResponse.statusLine();
  assertThat(statusText).isEqualTo("HTTP/1.1 500 Internal Server Error");

  long responseTime = jsonResponse.getTime();
  assertThat(responseTime).isBetween(0L,3000L);

  String headerValue = jsonResponse.getHeader("Content-Type");
  assertThat(headerValue).contains("text/plain; charset=utf-8");
 }
}

