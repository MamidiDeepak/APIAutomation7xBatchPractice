package com.APIAutomation7xBatchPractice.APIChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class CreateStudent {

    @Test
    void createStudent() throws FileNotFoundException {

//        Faker fakeData = new Faker();

//        PojoClass data = new PojoClass();
//        data.setName(fakeData.name().firstName());
//        data.setLocation(fakeData.internet().publicIpV4Address());
//        data.setPhone(fakeData.phoneNumber().cellPhone());
//
//        String[] arr = {"fakeData.name()","fakeData.name()"};
//        data.setCourses(arr);

//        PojoClass data = new PojoClass();
//        data.setName("Deepu");
//        data.setLocation("BJhills");
//        data.setPhone("9939333948");
//
//        String arr[] = {"TestA","TestB"};
//        data.setCourses(arr);

        File f = new File(".\\bbody.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);


                 given()
                    .contentType("application/json")
                    .body(data.toString())
                .when()
                    .post("http://localhost:3000/students")

                .then()
                    .statusCode(201)
                    .log().all();
    }
}
