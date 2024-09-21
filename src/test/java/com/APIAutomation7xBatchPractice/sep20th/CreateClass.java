package com.APIAutomation7xBatchPractice.sep20th;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

//import java.lang.classfile.instruction.StackInstruction;

public class CreateClass {

    static RequestSpecification r = RestAssured.given();

    static String payload = "{\n" +
            "    \"name\":\"deepakmamidi\", \n" +
            "    \"gender\":\"male\", \n" +
            "    \"email\":\"testdddsdsdddsdwddddddeepaasdakemail@yopmail.com\", \n" +
            "    \"status\":\"active\"\n" +
            "} ";

//    public static void main(String[] args) {
    @Test
    public void runClass(){


        String token = "3ffefa723cae1d9f714209ff50534c7775bcbd3b4eebb0f90fdd42d1e57a6fc2";

        r.baseUri("https://gorest.co.in");
        r.basePath("/public/v2/users");
        r.header("Authorization","Bearer "+token);
        r.contentType("application/json");
        r.body(payload);

        createUserwithValidDetails();
    }

    public static void createUserwithValidDetails(){

        r.body(payload);
        Response response = r.when().post();

        ValidatableResponse actualResponse = response.then()
                                             .log().all().statusCode(201);
    }

}
