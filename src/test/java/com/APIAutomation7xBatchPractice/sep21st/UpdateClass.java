package com.APIAutomation7xBatchPractice.sep21st;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateClass {

    RequestSpecification r = RestAssured.given();

    String payload = " {\n" +
            "     \"name\": \"deepu\",\n" +
            "      \"location\": \"Bangalore\",\n" +
            "      \"course\": [\n" +
            "        \"C++\",\n" +
            "        \"Python\"\n" +
            "      ]\n" +
            "    }";

    @Test
    public void updateDetails(ITestContext context){

        String id = (String) context.getAttribute("userId");

        r.baseUri("http://localhost:3000/students/"+id);
        r.body(payload);

        Response response = r.when().put();

        ValidatableResponse result = response.then()
                .log().all();

        System.out.println("Updated id is : >>>>> "+id);

    }
}
