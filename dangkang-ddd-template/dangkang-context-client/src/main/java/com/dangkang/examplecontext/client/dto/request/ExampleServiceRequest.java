package com.dangkang.examplecontext.client.dto.request;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;
import com.dangkang.application.dto.request.AbstractRequest;

import com.dangkang.examplecontext.client.dto.validator.PhoneNumberValidator;
import org.hibernate.validator.constraints.NotBlank;

public class ExampleServiceRequest extends AbstractRequest {

    @NotBlank(message = "邮箱不能为空'")
    private String email;
    @FluentValidate(PhoneNumberValidator.class)
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
