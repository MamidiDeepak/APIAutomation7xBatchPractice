package com.APIAutomation7xBatchPractice.sep16th;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ThirdClassPathAndQueryParams {

//    https://reqres.in/api/users?page=2

    @Test
    void verifyPathAndQueryParams(){
        given()
                .pathParams("myPath","users")
                .queryParams("page",2)

                .when()
                .get("https://reqres.in/api/{myPath}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
