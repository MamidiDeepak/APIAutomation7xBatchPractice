package com.APIAutomation7xBatchPractice.sep27th.pojoClass;

public class CreateResponsePojoClass {

    private String bookingId;
    private CreateCustomerPojoClass createRequest;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public CreateCustomerPojoClass getCreateRequest() {
        return createRequest;
    }

    public void setCreateRequest(CreateCustomerPojoClass createRequest) {
        this.createRequest = createRequest;
    }
}
