package com.APIAutomation7xBatchPractice.neeruFolder;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateBookingRequest {

    public String bookingRequest() {
        BookingPojo bp = new BookingPojo();
        BookingDatesPojo bdp = new BookingDatesPojo();

        Faker f = new Faker();
        bp.setFirstname(f.name().firstName());
        bp.setLastname(f.name().lastName());
        bp.setTotalprice(Integer.valueOf(f.number().digits(3)));
        bp.setDepositpaid(true);

        bdp.setCheckout("2024-10-01");
        bdp.setCheckin("2024-09-28");

        bp.setBookingdates(bdp);
//        Bought from up to here
        bp.setAdditionalneeds(f.food().ingredient());


        Gson g = new Gson();
        String payload = g.toJson(bp);
        System.out.println(payload);


        return payload;
    }

}
