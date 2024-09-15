package com.APIAutomation7xBatchPractice;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;


public class SecondAPIUsingPojoClass {

    @Test (priority = 1)
    void CreateUserUsingPojoClass(){

      POJOClass data = new POJOClass();
        data.setName("DeepakMamidi");
        data.setJob("QA Analyst");

           given()
                        .contentType("application/json")
                        .body(data)
                    .when()
                        .post("https://reqres.in/api/users")
                    .then()
                        .statusCode(201)
                        .log().all();
    }

    @Test (priority = 2)
    void CreateUserUsingExternalFile() throws FileNotFoundException {

        File f = new File(".\\body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().all();
    }


}
