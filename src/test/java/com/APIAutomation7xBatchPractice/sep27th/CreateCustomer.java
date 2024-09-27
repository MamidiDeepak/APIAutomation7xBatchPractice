package com.APIAutomation7xBatchPractice.sep27th;

import com.APIAutomation7xBatchPractice.sep27th.pojoClass.CreateCustomerPojoClass;
import com.APIAutomation7xBatchPractice.sep27th.pojoClass.CreateResponsePojoClass;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.processing.SupportedSourceVersion;

public class CreateCustomer {

    RequestSpecification createVariable = RestAssured.given();

    Faker fakeData = new Faker();

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test creation of Customer with Valid Details")
    @Test
    public void creationOfCustomer(ITestContext context){

       String token = (String) context.getAttribute("token");

        CreateCustomerPojoClass createCustomerPojoClass = new CreateCustomerPojoClass();
        createCustomerPojoClass.setFirstName(fakeData.name().firstName());
        createCustomerPojoClass.setLastName(fakeData.name().lastName());
        createCustomerPojoClass.setMobile(fakeData.phoneNumber().cellPhone());
        createCustomerPojoClass.setEmail(fakeData.name().firstName()+"@gmail.com");
        createCustomerPojoClass.setSource("PARTNER");
        createCustomerPojoClass.setPartnerId("5e5c615b-003d-480c-92cb-701eacc819ea");
        createCustomerPojoClass.setEntityId("c3ae1e1c-6054-4bf1-a997-5cb4708f4e86");

        Gson gson = new Gson();
        String jsonReponse = gson.toJson(createCustomerPojoClass);
        System.out.println(jsonReponse);

        createVariable.baseUri("https://api-testing.mymoneykarma.com/kpapi");
        createVariable.basePath("/customers");
        createVariable.contentType("application/json");
        createVariable.header("Authorization","Bearer "+token);
        createVariable.body(jsonReponse);

        Response response = createVariable.when().post();
        response.then().log().all();

        String convertToString = response.asString();
        System.out.println(convertToString);

//        Convert back to Java Object
        CreateResponsePojoClass  backToJava = gson.fromJson(convertToString, CreateResponsePojoClass.class);
            String id = backToJava.getBookingId();
        System.out.println(id);

        assertThat(backToJava.getCreateRequest().getFirstName()).isEqualTo("asda");



    }
}
