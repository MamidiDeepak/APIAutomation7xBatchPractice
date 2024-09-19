package com.APIAutomation7xBatchPractice.APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteStudent {

    @Test
    void deleteStudent(ITestContext context){

        String id = (String) context.getAttribute("userId");

        given()
                .pathParams("id",id)
                .when()
                .delete("http://localhost:3000/students/{id}")
                .then()
                    .statusCode(204)
                    .log().all();

    }
}
