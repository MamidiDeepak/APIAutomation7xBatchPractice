package com.APIAutomation7xBatchPractice.sep16th;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


//https://reqres.in/api/users?page
//https://reqres.in/api/users
//https://reqres.in/api/users/id
//https://reqres.in/api/users/

public class FirstAPIPracUsingPOJOClass {

    int id;

    @Test (priority = 1)
    void createUser(){

        POJOClass data = new POJOClass();
        data.setName("Deepak");
        data.setJob("QA Engineer");

      id = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
               .jsonPath().getInt("id");
    }

    @Test (priority = 2)
    void getUser(){

        given()
                .when()
                .get("https://reqres.in/api/users?page/")
                .then()
                .statusCode(200)
//                .body("page",equalTo(1))
                .log().all();
    }

    @Test (priority = 3)
    void updateUser(){
        POJOClass data = new POJOClass();
        data.setName("Mamidi");
        data.setJob("Analyst");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/id")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test (priority = 4)
    void deleteUser(){
        given()

                .when()
                .delete("https://reqres.in/api/users/id")
                .then()
                .statusCode(204)
                .log().all();
    }

}

