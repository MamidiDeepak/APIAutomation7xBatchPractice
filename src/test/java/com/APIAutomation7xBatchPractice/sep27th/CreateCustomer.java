package com.APIAutomation7xBatchPractice.sep27th;

import com.APIAutomation7xBatchPractice.sep27th.pojoClass.CreateCustomerPojoClass;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateCustomer {

    RequestSpecification createVariable = RestAssured.given();

    Faker fakeData = new Faker();

    @Test
    public void creationOfCustomer(){

        CreateCustomerPojoClass createCustomerPojoClass = new CreateCustomerPojoClass();
        createCustomerPojoClass.setFirstName(fakeData.name().firstName());
        createCustomerPojoClass.setLastName(fakeData.name().lastName());
        createCustomerPojoClass.setMobile("9993338293");
        createCustomerPojoClass.setEmail(fakeData.name()+"@gmail.com");
        createCustomerPojoClass.setSource("PARTNER");
        createCustomerPojoClass.setPartnerId("5e5c615b-003d-480c-92cb-701eacc819ea");
        createCustomerPojoClass.setEntityId("c3ae1e1c-6054-4bf1-a997-5cb4708f4e86");

        Gson gson = new Gson();
        String jsonReponse = gson.toJson(createCustomerPojoClass);
        System.out.println(jsonReponse);



    }
}
