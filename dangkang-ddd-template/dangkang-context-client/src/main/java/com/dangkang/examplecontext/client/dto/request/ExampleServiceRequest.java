package com.dangkang.examplecontext.client.dto.request;

import com.dangkang.application.dto.request.AbstractRequest;


public class ExampleServiceRequest extends AbstractRequest {


    private String email;

    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
