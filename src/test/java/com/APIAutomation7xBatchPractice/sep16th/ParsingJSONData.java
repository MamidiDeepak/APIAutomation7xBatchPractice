package com.APIAutomation7xBatchPractice.sep16th;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ParsingJSONData {

//    @Test
    void testJSONResponse(){
//          Approach-1
            given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .body("book[3].title",equalTo("football game"));
    }

    //          Approach-2
    @Test
    void testJSONResponseData(){
       Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

            JSONObject data = new JSONObject(res.asString());

            boolean status= false;

            for(int i=0; i<data.getJSONArray("book").length();i++) {
                String value = data.getJSONArray("book").getJSONObject(i).get("title").toString();
//                System.out.println(value);

                if (value.equalsIgnoreCase("Of the baseball")) {

                    status = true;
                    break;
                }

            }
        Assert.assertEquals(status,true);


        //    Validate the sum of the price

        double totalPrice =0;
        for(int i=0; i<data.getJSONArray("book").length(); i++){
            String price = data.getJSONArray("book").getJSONObject(i).get("price").toString();

            totalPrice += Double.parseDouble(price);
        }

        System.out.println(totalPrice);


    }
}
