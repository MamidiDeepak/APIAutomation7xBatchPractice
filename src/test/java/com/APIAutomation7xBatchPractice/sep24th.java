package com.APIAutomation7xBatchPractice;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.util.HashMap;

public class sep24th {

    @Test
    void testAssertions(){

        File file = new File(".\\body.json");

        assertThat(file).exists().isFile().canRead();

        HashMap<String,String> hm = new HashMap<>();
        hm.put("fName","Deepak");
        hm.put("lName","Mamidi");

        assertThat(hm).containsEntry("fName","Deepak");

    }
}
