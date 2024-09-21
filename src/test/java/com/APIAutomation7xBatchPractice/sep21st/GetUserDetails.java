package com.APIAutomation7xBatchPractice.sep21st;

//import com.sun.org.apache.xpath.internal.operations.String;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUserDetails {

    @Test
    public void GetCreateUserDetails(ITestContext context){

       String id = (String) context.getAttribute("userId");

       RequestSpecification r = RestAssured.given();
//       r.pathParams("id",id);
            r.baseUri("http://localhost:3000/students/"+id);


            r.when().get();
            r.then().log().all().statusCode(200);

        System.out.println("Fetched UserId is : >>> "+id);


    }
}
