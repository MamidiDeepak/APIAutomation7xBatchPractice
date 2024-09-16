package com.APIAutomation7xBatchPractice.sep16th;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DifferentTypeLogs {

    @Test(priority = 1)
    void verifyOnlyHeaders(){
        given()

                .when()
                .get("https://www.google.com")

                .then()
                .log().headers();
    }

    @Test(priority = 2)
    void verifyOnlyCookies(){
        given()

                .when()
                .get("https://www.google.com")

                .then()
                .log().cookies();
    }

    @Test(priority = 2)
    void verifyOnlyBody(){
        given()

                .when()
                .get("https://www.google.com")

                .then()
                .log().body();
    }
}
