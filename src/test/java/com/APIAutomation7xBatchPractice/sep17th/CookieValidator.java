package com.APIAutomation7xBatchPractice.sep17th;

import org.testng.annotations.Test;

import java.util.Map;

public class CookieValidator {

    @Test
    void validateCookie(){

        Map<String, String> cookie_value = res.getCookies();

        System.out.println(cookie_value.keySet());

        for(String k : cookie_value.keySet()){

            String value = res.getCookie(k);
            System.out.println(k+" >>> "+value);
        }

        @Test
        void validateheader(){



        }
    }
}
