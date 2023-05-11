package com.dangkang.examplecontext.domain.facade;

/**
 * @date 2022/12/30 13:57
 */
public class CallRequest<T> {

    private String email;
    private String phoneNumber;

    private T callData;

    public String getEmail() {
        return email;
    }

    public CallRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CallRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public T getCallData() {
        return callData;
    }

    public void setCallData(T callData) {
        this.callData = callData;
    }
}
