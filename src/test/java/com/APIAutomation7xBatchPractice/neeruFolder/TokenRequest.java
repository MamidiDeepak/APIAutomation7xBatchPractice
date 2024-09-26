package com.APIAutomation7xBatchPractice.neeruFolder;

import java.util.HashMap;

public class TokenRequest {

    public HashMap <String, String> tokenPayload(){
        HashMap <String, String> hm = new HashMap<>();
        hm.put("username" , "admin");
        hm.put("password" , "password123");

        return hm;
    }
}
