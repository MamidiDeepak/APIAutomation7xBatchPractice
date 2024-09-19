package com.APIAutomation7xBatchPractice.APIChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class CreateStudent {

    @Test
    void createStudent(ITestContext context) throws FileNotFoundException {

        File f = new File(".\\bbody.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);


              String id = given()
                    .contentType("application/json")
                    .body(data.toString())
                .when()
                    .post("http://localhost:3000/students")
                         .jsonPath().get("id");

//                .then()
//                    .statusCode(201)
//                    .log().all();

        System.out.println("received Id : "+id);
        context.setAttribute("userId",id);
    }
}
