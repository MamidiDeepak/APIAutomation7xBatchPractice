package com.APIAutomation7xBatchPractice;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ThirdAPITest {

    int id;

    @Test
    void getUserDetails(){
                given()
                .when()
                        .get("https://reqres.in/api/users?page")
                .then()
                        .statusCode(200)
                        .body("page",equalTo(1))
                        .body("data[0].first_name",equalTo("George"))
                        .log().all();
    }

    @Test
    void CreateUser(){

        HashMap<String,String> hm = new HashMap<>();
        hm.put("name","Deepak");
        hm.put("job","QA");

           id = given()
                        .contentType("application/json")
                        .body(hm)
                    .when()
                        .post("https://reqres.in/api/users")
                    .jsonPath().getInt("id");
//                    .then()
//                    .statusCode(201)
//                    .log().all();
    }

    @Test
    void updateUser(){
        HashMap<String,String> hm = new HashMap<>();
        hm.put("name","Pranithaqw");
        hm.put("job","Engineer");

            given()
                    .contentType("application/json")
                    .body(hm)
                    .when()
                    .put("https://reqres.in/api/users/id")
                    .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test
    void deleteCreateUser(){
            given()

                    .when()
                    .delete("https://reqres.in/api/users/id")
                    .then()
                    .statusCode(204);
    }
}
