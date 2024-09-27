package com.APIAutomation7xBatchPractice.sep27th;

import com.APIAutomation7xBatchPractice.sep27th.pojoClass.TokenPojoClass;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateToken {

    RequestSpecification tokenVariable = RestAssured.given();

    @Test
    public void getToken(){

        TokenPojoClass tokenPojoClass = new TokenPojoClass();
        tokenPojoClass.setUsername("john@yopmail.com");
        tokenPojoClass.setPassword("password");

//        Serialize the Java Object to JSON Object / Byte Stream
        Gson gson = new Gson();
        String jsonStringPayload = gson.toJson(tokenPojoClass);
//        Printing the json payload
        System.out.println(jsonStringPayload);

        tokenVariable.baseUri("https://api-testing.mymoneykarma.com/kpapi");
        tokenVariable.basePath("/auth/login");
        tokenVariable.contentType("application/json");
        tokenVariable.body(jsonStringPayload);

        Response response = tokenVariable.when().post();
//        Printing the response log
        response.then().log().all();

//        Convert the response to String

        String convertedResponse = response.asString();
        System.out.println(convertedResponse);

//        Convert the convertedResponse to String using Gson

        gson.fromJson(convertedResponse,)


    }
}
