package com.APIAutomation7xBatchPractice.sep26th.FinalPractice.pojoClasses;

public class BookingResponseFields {

    private String bookingid;
    private CreateBookingFields bookingFields;

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public CreateBookingFields getBookingFields() {
        return bookingFields;
    }

    public void setBookingFields(CreateBookingFields bookingFields) {
        this.bookingFields = bookingFields;
    }
}
