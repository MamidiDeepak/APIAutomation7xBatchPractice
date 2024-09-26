package com.APIAutomation7xBatchPractice.neeruFolder;

public class ResponsePojo {
    private String bookingid;
    private BookingPojo book;

    public BookingPojo getBook() {
        return book;
    }

    public void setBook(BookingPojo book) {
        this.book = book;
    }

    public CreateBookingRequest getBooking() {
        return booking;
    }

    public void setBooking(CreateBookingRequest booking) {
        this.booking = booking;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    CreateBookingRequest booking;


}
