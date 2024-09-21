package com.APIAutomation7xBatchPractice;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestfailingAPI {

    @Test
    public void createUser() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", "Neeru1");
        hm.put("gender", "Female");
        hm.put("email", "neeruqa1@yopmail.com");
        hm.put("status", "active");

        String token = "808a2bc2eb9e8131dae29763db501fa07384201c55087828373ba6f51f175f5b";
        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(hm)

                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(201)
                .log().all();

    }

}
