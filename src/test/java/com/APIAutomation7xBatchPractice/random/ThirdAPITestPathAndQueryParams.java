package com.APIAutomation7xBatchPractice.random;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ThirdAPITestPathAndQueryParams {

//     https://reqres.in/api/users?page=2&id=7

    @Test
    void ValidatePathAndQueryParams(){

            given()
                    .pathParams("myPath","users")
                    .queryParams("page",2)
                    .queryParams("id",7)
                    .when()
                    .get("https://reqres.in/api/{myPath}")
                    .then()
                    .statusCode(200)
                    .log().all();
    }
}
