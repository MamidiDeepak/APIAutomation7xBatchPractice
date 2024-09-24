package com.APIAutomation7xBatchPractice.sep23rd;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class RunXmlFiles {

    public static void main(String[] args) {

        List<String> xmlList = new ArrayList<>();
        xmlList.add("qa.xml");
        xmlList.add("stag.xml");
        xmlList.add("preprod.xml");

        TestNG testNG = new TestNG();
        testNG.setTestSuites(xmlList);
        testNG.run();
    }
}
