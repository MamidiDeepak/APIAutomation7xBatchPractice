package com.APIAutomation7xBatchPractice.sep26th;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Verification {

    @Test
    public void verifyAssertions(){

        String name = "DEEPAK";
        assertThat(name).isNotNull().isNotBlank().isUpperCase();

        List<String> list = new ArrayList<>();
        list.add("Deepak");
        list.add("mamidi");

        assertThat(list).hasSize(2).contains("mamidi");
        assertThat(list).isNotNull();

        LocalDate local = LocalDate.now();
        System.out.println(local.getMonth());

        assertThat(local).isAfterOrEqualTo(LocalDate.of(2024, 9, 26));
        assertThat(local).isBetween(LocalDate.of(2024,9,26), LocalDate.of(2024,9,27));



    }
}
