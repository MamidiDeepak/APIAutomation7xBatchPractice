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
import static org.assertj.core.api.Assertions.*;

public class GetCreatedBookingDetails {

    RequestSpecification varGetGiven = RestAssured.given();

//    CreateBooking id = new CreateBooking();
//    String bookingId = id.getBookingId();

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Getting created Booking Id")
    @Test
    public void getCreatedBookingDetails(ITestContext context){

        String bookingId = (String) context.getAttribute("bookedId");
        
            varGetGiven.baseUri("https://restful-booker.herokuapp.com");
            varGetGiven.basePath("/booking/"+bookingId);
            varGetGiven.contentType("application/json");

            Response response = varGetGiven.when().get();

//        System.out.println(response.asString());

        JsonPath jsonPath = new JsonPath(response.asString());
        String fName = jsonPath.getString("firstname");
        assertThat(fName).isEqualToIgnoringCase("deepak");
        System.out.println("first Name is : "+fName);

        int statusCode = response.statusCode();
        assertThat(statusCode).isEqualTo(200);
        System.out.println("Status Code is : "+statusCode);

        String statusText = response.statusLine();
        assertThat(statusText).isEqualTo("HTTP/1.1 200 OK");
        System.out.println("Status Text is : "+statusText);

        long responseTime = response.getTime();
        assertThat(responseTime).isBetween(0L,5000L);
        System.out.println("Response Time is : "+responseTime);

        System.out.println("_____________________________");
//        return bookingId;

    }
}
