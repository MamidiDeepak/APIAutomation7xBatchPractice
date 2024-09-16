package com.APIAutomation7xBatchPractice.sep16th;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class APIChaining {

    @Test
    void generateIdOnCreatingUser(){

        Faker fake = new Faker();

        JSONObject data = new JSONObject();

        data.put("name", fake.name().fullName());
        data.put("gender", "male");
        data.put("email", fake.internet().emailAddress());
        data.put("status","active");

//        HashMap<String, String> map = new HashMap<>();
//        map.put("name", "deepak");
//        map.put("gender", "male");
//        map.put("email", "deepak@yopmail.com");
//        map.put("status", "active");

        String token = "3ffefa723cae1d9f714209ff50534c7775bcbd3b4eebb0f90fdd42d1e57a6fc2";

      int id = given()
                    .header("Authorization","Bearer "+token)
                    .contentType("application/json")
                    .body(data.toString())
                .when()
                    .post("https://gorest.co.in/public/v2/users")
                    .jsonPath().getInt("id");

        System.out.println("Created ID is "+id);



    }
}
