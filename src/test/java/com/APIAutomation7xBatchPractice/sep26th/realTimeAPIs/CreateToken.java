package com.APIAutomation7xBatchPractice.sep26th.realTimeAPIs;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateToken {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Generation of Token with valid userName & Password.")
    @Test
    void getTokenWithValidUserNameAndPassword(ITestContext context){

        RequestSpecification tokenVariable = RestAssured.given();

        String tokenPayload = "{\n" +
                "  \"username\": \"john@yopmail.com\",\n" +
                "  \"password\": \"password\"\n" +
                "}";

        tokenVariable.baseUri("https://api-testing.mymoneykarma.com");
        tokenVariable.basePath("/kpapi/auth/login");
        tokenVariable.contentType("application/json");
        tokenVariable.body(tokenPayload);

        Response response = tokenVariable.when().post();

        // Convert the response body to String
        String responseBody = response.getBody().asString();

        // Parse the response to extract accessToken
        JSONObject responseJson = new JSONObject(responseBody);
        String accessToken = responseJson.getJSONObject("data").getString("accessToken");

        // Print the access token
        System.out.println("Access Token: " + accessToken);

        context.setAttribute("token", accessToken);

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Validating the error message when sent invalid username.")
    @Test
    void getTokenWithInvalidUserNameToCheckErrorMessage(){

        RequestSpecification tokenVariable = RestAssured.given();

        String tokenPayload = "{\n" +
                "  \"username\": \"john@yopmail\",\n" +
                "  \"password\": \"password\"\n" +
                "}";

        tokenVariable.baseUri("https://api-testing.mymoneykarma.com");
        tokenVariable.basePath("/kpapi/auth/login");
        tokenVariable.contentType("application/json");
        tokenVariable.body(tokenPayload);

        Response response = tokenVariable.when().post();
            String convertedResponse = response.asString();
        System.out.println(convertedResponse);

        JsonPath jsonPath = new JsonPath(convertedResponse);
        String errorMessage = jsonPath.getString("error.messages[0].error");

        Assert.assertEquals(errorMessage,"username must be an email");

    }
}
