package com.APIAutomation7xBatchPractice.sep23rd;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetDeletedBookingDetails {

    RequestSpecification varGetGiven = RestAssured.given();

    @Severity(SeverityLevel.MINOR)
    @Description("Verify getting deleted Booking Id")
    @Test (groups = {"stag","preprod"})
    public void getDeletedBookingDetails(ITestContext context){

        String bookingId = (String) context.getAttribute("bookedId");

            varGetGiven.baseUri("https://restful-booker.herokuapp.com");
            varGetGiven.basePath("/booking/"+bookingId);
            varGetGiven.contentType("application/json");

            Response response = varGetGiven.when().get();

//        System.out.println(response.asString());

        int statusCode = response.statusCode();
        assertThat(statusCode).isEqualTo(404);
        System.out.println("Status Code is : "+statusCode);

        long responseTime = response.getTime();
        assertThat(responseTime).isBetween(0L,5000L);
        System.out.println("Response Time is : "+responseTime);

    }
}
