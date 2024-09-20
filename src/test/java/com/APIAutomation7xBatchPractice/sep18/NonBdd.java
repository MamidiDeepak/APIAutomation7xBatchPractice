package com.APIAutomation7xBatchPractice.sep18;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBdd {

   static RequestSpecification r = RestAssured.given();

    public static void main(String[] args) {
        r.baseUri("https://reqres.in");
        test1();
        test2();
    }

    public static void test1(){
            r.basePath("/api/users?page=2");
            r.when().get();
            r.then().log().all().statusCode(200);
    }


    public static void test2(){
        r.basePath("/api/users?page=2");
        r.when().get();
        r.then().log().all().statusCode(201);
    }
}
