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

public class UpdateCreatedBooking {

    RequestSpecification varUpdateBooking = RestAssured.given();

    String payload = "{\n" +
            "    \"firstname\" : \"Rohit\",\n" +
            "    \"lastname\" : \"Sharma\",\n" +
            "    \"totalprice\" : 999,\n" +
            "    \"depositpaid\" : false,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2020-01-01\",\n" +
            "        \"checkout\" : \"2021-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"dinner\"\n" +
            "}";

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Updating the created Booking Id")
    @Test (groups = {"qa","stag","preprod"})
    public void updateExistingBooking(ITestContext context){

        String bookingId = (String) context.getAttribute("bookedId");
        String token = (String) context.getAttribute("token");

                varUpdateBooking.baseUri("https://restful-booker.herokuapp.com");
                varUpdateBooking.basePath("/booking/"+bookingId);
                varUpdateBooking.cookie("token", token);
                varUpdateBooking.contentType("application/json");
                varUpdateBooking.body(payload);

                Response response = varUpdateBooking.when().put();

//        System.out.println(response.asString());

        JsonPath jsonPath = new JsonPath(response.asString());
        String fName = jsonPath.getString("firstname");
        assertThat(fName).isEqualToIgnoringCase("rohit");
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

    }
}
