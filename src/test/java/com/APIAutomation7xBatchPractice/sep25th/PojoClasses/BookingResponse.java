package com.APIAutomation7xBatchPractice.sep25th.PojoClasses;

public class BookingResponse {

    private Integer bookingid;
    private BookingClass booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingClass getBooking() {
        return booking;
    }

    public void setBooking(BookingClass booking) {
        this.booking = booking;
    }
}
