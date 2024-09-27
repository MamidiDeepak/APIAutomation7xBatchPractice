package com.APIAutomation7xBatchPractice.sep27th;

import com.APIAutomation7xBatchPractice.sep27th.pojoClass.TokenPojoClass;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateToken {

    RequestSpecification tokenVariable = RestAssured.given();

    @Severity(SeverityLevel.CRITICAL)
    @Description("Creation of Token with valid Username and Password")
    @Test
    public void getToken(ITestContext context){

        TokenPojoClass tokenPojoClass = new TokenPojoClass();
        tokenPojoClass.setUsername("john@yopmail.com");
        tokenPojoClass.setPassword("password");

//        Serialize the Java Object to JSON Object / Byte Stream
        Gson gson = new Gson();
        String jsonStringPayload = gson.toJson(tokenPojoClass);

        tokenVariable.baseUri("https://api-testing.mymoneykarma.com/kpapi");
        tokenVariable.basePath("/auth/login");
        tokenVariable.contentType("application/json");
        tokenVariable.body(jsonStringPayload);

        Response response = tokenVariable.when().post();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,201);

        JsonPath jsonPath = new JsonPath(response.asString());
        String fetchedToken = jsonPath.getString("data.accessToken");
        System.out.println(fetchedToken);

        context.setAttribute("token",fetchedToken);
    }
}
