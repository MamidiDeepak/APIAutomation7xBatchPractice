package com.APIAutomation7xBatchPractice.sep16th;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.*;

public class CookiesDemo {

    @Test (priority = 1)
    void verifyCookiesExists(){

        given()

                .when()
                .get("https://www.google.com")

                .then()
                .cookie("cookie","sdffsd")
                .log().all();
    }

    @Test (priority = 2)
    void verifySingleCookie(){

       Response res = given()

                .when()
                .get("https://www.google.com");

                String cookie_value = res.getCookie("AEC");
        System.out.println("cookie value is >>>>> "+cookie_value);

    }

    @Test (priority = 3)
    void getAllCookies(){

        Response res = given()

                .when()
                .get("https://www.google.com");

        Map<String,String> cookies_Values = res.getCookies();

//        System.out.println(cookies_Values.keySet());

        for(String key : cookies_Values.keySet()){

            String value = res.getCookie(key);
            System.out.println(key+" >>> " +value);
        }
    }

}
