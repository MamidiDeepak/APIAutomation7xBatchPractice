package com.APIAutomation7xBatchPractice.sep17th;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class FirstClass {

    @Test (priority = 1)
    void createUser(){
        POJOClass data = new POJOClass();
        data.setName("Deepak");
        data.setJob("QA");

       int id = given()
                .contentType("application/json; charset=utf-8")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

//                .then()
//                .statusCode(201)
//                .log().all();
    }

    @Test (priority = 2)
    void getUser(){
        given()
                .pathParams("myPath", "users")
                .queryParams("page",2)

                .when()
                .get("https://reqres.in/api/{myPath}")

                .then()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .body("data[2].first_name",equalTo("Tobias"))
                .log().all();
    }

    @Test (priority = 3)
    void updateUser(){

        POJOClass data = new POJOClass();
        data.setName("Mamidi");
        data.setJob("Engineer");

        String token = "";

        given()
//                .header("Authorization","Bearer "+token)
                .contentType("application/json; charset=utf-8")
                .body(data)
                .pathParams("myPath", "users")
                .queryParams("page",2)

                .when()
                .put("https://reqres.in/api/{myPath}/")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test (priority = 4)
    void deleteUser(){
        given()

                .when()
                .delete("https://reqres.in/api/users/2")

                .then()
                .statusCode(204)
                .log().all();
    }

}
