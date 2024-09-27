package com.APIAutomation7xBatchPractice.sep26th.realTimeAPIs;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.lang.reflect.Array;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.instanceOf;

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

//        System.out.println(response);

        response.then().log().all();

        int responseCode = response.statusCode();
        assertThat(responseCode).isEqualTo(200);

        String responseText = response.statusLine();
        assertThat(responseText).isEqualTo("HTTP/1.1 200 OK");

        Long responseTime = response.getTime();
        assertThat(responseTime).isLessThan(3000L);

        Headers headers = response.getHeaders();
        assertThat(headers).isNotEmpty();

        JsonPath jsonPath = new JsonPath(response.asString());

//                Validate the response data type.
        assertThat("data").isInstanceOf(String.class);

//        Validate the fields Data Type
        assertThat("data.firstName").isInstanceOf(String.class);
        assertThat("data.isActive").isInstanceOf(String.class);
        assertThat("data.isForcedResetPassword").isInstanceOf(String.class);
        assertThat("data.location").isInstanceOf(String.class);

//        Validate the Fields Value in the response.
        String fName = jsonPath.getString("data.firstName");
        Assert.assertEquals(fName, "manager");



    }
}
