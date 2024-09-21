package com.APIAutomation7xBatchPractice.sep20th;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class TestNGClass {

    @BeforeSuite
    void beforeSuite(){
        System.out.println("bf suite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("before Test");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("before Class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("before Method-1");
    }

    @Test
    void test1(){
        System.out.println("Test-1");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("after Method-1");
    }

    @BeforeMethod
    void beforeMethod1(){
        System.out.println("before Method-2");
    }

    @Test
    void test2(){
        System.out.println("Test-2");
    }

    @AfterMethod
    void afterMethod2(){
        System.out.println("after Method-2");
    }

    @AfterClass
    void afterClass(){
        System.out.println("after Class");
    }

    @AfterTest
    void afterTest(){
        System.out.println("after Test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("after Suite");
    }
}
