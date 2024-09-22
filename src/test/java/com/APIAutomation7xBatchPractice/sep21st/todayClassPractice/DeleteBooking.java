package com.APIAutomation7xBatchPractice.sep21st.todayClassPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteBooking {


    RequestSpecification varDeleteGiven = RestAssured.given();
    @Test
    public void deleteCreatedBooking(){

        CreateToken ct = new CreateToken();
        String token = ct.createTokenMethod();

        CreateBooking createdBookingIdInUpdate = new CreateBooking();
        int id = createdBookingIdInUpdate.bookingId;

        varDeleteGiven.baseUri("https://restful-booker.herokuapp.com");
        varDeleteGiven.basePath("/booking/"+id);
//        varUpdateGiven.header("Authorization", "Bearer "+token);

//        varUpdateGiven.contentType(ContentType.JSON);
        varDeleteGiven.cookie("token",token);

        Response res = varDeleteGiven.when().delete();

        res.then().log().all().statusCode(201);
    }
}
