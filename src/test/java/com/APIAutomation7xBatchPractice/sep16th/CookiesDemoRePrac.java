package com.APIAutomation7xBatchPractice.sep16th;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemoRePrac {

    @Test (priority = 1)
    void verifyCookiesExists(){

        given()

                .when()
                .get("https://www.google.com")

                .then()
                .cookie("AEC","tysd");
    }

    @Test (priority = 2)
    void GetSingleCookie(){

        Response res = given()

                .when()
                .get("https://www.google.com");

        System.out.println(res.getCookie("AEC"));
    }

    @Test (priority = 3)
    void GetAllCookies(){

        Response res = given()

                .when()
                .get("https://www.google.com");

         Map<String,String> cookies = res.getCookies();

         for(String keys : cookies.keySet()){

             String value = res.getCookie(keys);
             System.out.println(keys+" >>> "+value);
         }
    }



}
