package com.APIAutomation7xBatchPractice.random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.HashMap;

//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;


public class FirstAPITest {

    int id;

    @Test (priority = 2)
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

    @Test (priority = 1)
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

    @Test (priority = 3)
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
                    .header("content-Type",equalTo("application/json"))

                        .log().all();
    }

    @Test (priority = 4)
    void deleteCreateUser(){
            given()

                    .when()
                        .delete("https://reqres.in/api/users/id")
                    .then()
                        .statusCode(204);
    }
}
