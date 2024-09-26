package com.APIAutomation7xBatchPractice.sep26th.realTimeAPIs;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class FetchLoggedInUserDetails {

    RequestSpecification FetchVariable = RestAssured.given();

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Generation of Token with valid userName & Password.")
    @Test
    void getTokenWithValidUserNameAndPassword(ITestContext context) {

        String tokenn = (String) context.getAttribute("token");


        FetchVariable.baseUri("https://api-testing.mymoneykarma.com/");
        FetchVariable.basePath("kpapi/auth/me");
        FetchVariable.contentType("application/json");
        FetchVariable.header("Authorization","Bearer "+tokenn);

        Response response = FetchVariable.when().get();

        System.out.println(response.asString());

    }
}
