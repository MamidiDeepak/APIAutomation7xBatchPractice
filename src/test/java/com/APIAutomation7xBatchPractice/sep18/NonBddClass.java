package com.APIAutomation7xBatchPractice.sep18;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static com.APIAutomation7xBatchPractice.sep18.NonBdd.r;

public class NonBddClass {
    static RequestSpecification rr = RestAssured.given();

    public static void main(String[] args) {
        rr.baseUri("https://api.zippopotam.us");

        step1();
    }


   public static void step1(){
        rr.basePath("/IN/500034");
        rr.when().get();
        rr.then().log().all().statusCode(200);
    }
}
