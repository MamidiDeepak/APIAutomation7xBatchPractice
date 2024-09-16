package com.APIAutomation7xBatchPractice.sep16th;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersDemoRePrac {

    @Test (priority = 1)
    void verifyHeaders(){
        given()

                .when()
                .get("https://www.google.com")

                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Cache-Control","private, max-age=0");
    }

    @Test
    void printAllHeaders(){

       Response res =given()

                .when()
                .get("https://www.google.com");

       Headers headers = res.getHeaders();

       for(Header h :headers){

           System.out.println(h.getName()+ " >>>> "+h.getName());
       }


    }
}
