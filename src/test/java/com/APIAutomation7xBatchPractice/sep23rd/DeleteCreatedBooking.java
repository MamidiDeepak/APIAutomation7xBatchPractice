package com.APIAutomation7xBatchPractice.sep23rd;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteCreatedBooking {

    RequestSpecification varDeleteGiven = RestAssured.given();

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify deleting the created Booking Id")
    @Test (groups = {"qa","stag","preprod"})
    public void deleteCreateBooking(ITestContext context){

        String bookingId = (String) context.getAttribute("bookedId");
        String token = (String) context.getAttribute("token");

        varDeleteGiven.baseUri("https://restful-booker.herokuapp.com");
        varDeleteGiven.basePath("/booking/"+bookingId);
        varDeleteGiven.contentType("application/json");
        varDeleteGiven.cookie("token",token);

        Response response = varDeleteGiven.when().delete();

        System.out.println(response.asString());

        System.out.println("_____________________________");
    }
}
