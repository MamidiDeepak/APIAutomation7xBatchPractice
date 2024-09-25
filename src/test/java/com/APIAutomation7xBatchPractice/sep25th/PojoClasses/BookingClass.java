package com.APIAutomation7xBatchPractice.sep25th.PojoClasses;

public class BookingClass {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDatesClass bookingdates;
    private String additonalneeds;

    public BookingDatesClass getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesClass bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditonalneeds() {
        return additonalneeds;
    }

    public void setAdditonalneeds(String additonalneeds) {
        this.additonalneeds = additonalneeds;
    }
}
