package com.APIAutomation7xBatchPractice.sep16th;

import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestWithTOken {

    @Test
    void RunWithToken(){

        HashMap<String,String> map = new HashMap<>();
        map.put("name","Deepak");
        map.put("gender", "male");
        map.put("email","deepakqa@yopmail.com");
        map.put("status","active");

        given()
                .cookie("cookie-token",
                        "455635bd00a783d2b3e9d82e7a7cf0a869a65d7e6e5d61c7494175ff9b2bb130")
                .contentType(ContentType.JSON)
                .body(map)

                .when()
                .post("https://gorest.co.in/public/v2/users")

                .then()
                .statusCode(201)
                .log().all();
    }

}

//{
//    "name":"Tenali Ramakrishna",
//        "gender":"male",
//        "email":"tenali.ramakrishna@15ce.com",
//        "status":"active"
//}
