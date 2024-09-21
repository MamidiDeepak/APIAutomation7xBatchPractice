package com.APIAutomation7xBatchPractice.sep20th;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class getUser {

  RequestSpecification r = RestAssured.given();

//    public static void main(String[] args) {
@Test
    public void getUserDetails(){
        String token = "3ffefa723cae1d9f714209ff50534c7775bcbd3b4eebb0f90fdd42d1e57a6fc2";

        r.baseUri("https://gorest.co.in");
        r.baseUri("/public/v2/users/6940804");
        r.header("Authorization","Bearer "+token);

    r.when().get();

    r.then().log().all().statusCode(200);
    }


}
