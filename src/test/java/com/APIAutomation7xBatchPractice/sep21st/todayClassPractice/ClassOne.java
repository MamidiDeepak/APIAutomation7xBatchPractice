package com.APIAutomation7xBatchPractice.sep21st.todayClassPractice;

import org.testng.annotations.Test;

public class ClassOne {

    @Test (groups = {"qa","stag"})
    public void test1(){
        System.out.println("sanity");
    }

    @Test (groups = {"qa"})
    public void test2(){
        System.out.println("smoke");
    }

    @Test (groups = {"qa","stag","preprod"})
    public void test3(){
        System.out.println("Regression");
    }

}
