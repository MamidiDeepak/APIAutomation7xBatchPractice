package com.APIAutomation7xBatchPractice.sep21st.todayClassPractice;

import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.given;
//import io.qameta.allure.*;

public class CreateBooking {

    RequestSpecification varRequestGiven = RestAssured.given();
    int bookingId;

    String RequestPayload = "{\n" +
            "    \"firstname\" : \"Deepak\",\n" +
            "    \"lastname\" : \"Mamidi\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify this test is working")
    @Test
    public void createBooking(){

        varRequestGiven.baseUri("https://restful-booker.herokuapp.com");
        varRequestGiven.basePath("/booking");
        varRequestGiven.contentType("application/json");
        varRequestGiven.body(RequestPayload);

        Response responsePayload = varRequestGiven.when().post();

//        ValidatableResponse responseData = responsePayload.then().log().all().statusCode(200);

       bookingId = responsePayload.then().extract().path("bookingid");
       String fName =  responsePayload.then().extract().path("booking.firstname");
       String addN = responsePayload.then().extract().path("booking.additionalneeds");

        assertThat(fName).isNotEmpty().isNotNull().isEqualToIgnoringCase("deepak");
        assertThat(addN).isNotEmpty().isNotNull().isEqualToIgnoringCase("Breakfast");

        System.out.println("Booking Id >>>>> "+bookingId);
    }

}
