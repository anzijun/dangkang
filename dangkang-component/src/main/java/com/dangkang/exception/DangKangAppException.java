package com.dangkang.exception;

/**
 * @date 2022/12/19 11:05
 */
public class DangKangAppException extends RuntimeException {

    private String errorCode;
    private String promptMessage;
    private String detailMessage;
    private Throwable cause;

    public DangKangAppException(){}

    public DangKangAppException setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public DangKangAppException setPromptMessage(String promptMessage, String... values) {
        this.promptMessage = String.format(promptMessage,values);
        return this;
    }

    public DangKangAppException setDetailMessage(String detailMessage, String... values) {
        this.detailMessage = String.format(detailMessage,values);
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public Throwable getCause() {
        return cause;
    }

    public DangKangAppException setCause(Throwable cause) {
        this.cause = cause;
        return this;
    }
}
