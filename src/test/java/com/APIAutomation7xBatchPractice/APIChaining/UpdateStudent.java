package com.APIAutomation7xBatchPractice.APIChaining;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class UpdateStudent {

    @Test
    void updateStudent(ITestContext context) throws FileNotFoundException {

        File f = new File(".\\bbody.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);


                String id = (String) context.getAttribute("userId");

        given()
                .contentType("application/json")
                .body(data.toString())
                .pathParams("id",id)
                .when()
                .put("http://localhost:3000/students/{id}")
                .jsonPath().get("id");

//                .then()
//                    .statusCode(201)
//                    .log().all();

        System.out.println("received Id : " + id);
    }
}