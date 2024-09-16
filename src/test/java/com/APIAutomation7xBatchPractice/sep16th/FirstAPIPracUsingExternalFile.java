package com.APIAutomation7xBatchPractice.sep16th;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;


//https://reqres.in/api/users?page
//https://reqres.in/api/users
//https://reqres.in/api/users/id
//https://reqres.in/api/users/

public class FirstAPIPracUsingExternalFile {

    int id;

    @Test (priority = 1)
    void createUser() throws Exception {

        File f = new File(".\\body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);


      id = given()
                .contentType("application/json")
                .body(data.toString())
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
    void updateUser() throws FileNotFoundException {
        File f = new File(".\\Updatedbody.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())
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

