package com.dangkang.exception;

/**
 * @date 2022/12/30 15:46
 */
public class ValidationException extends DangKangAppException {

    public static final String errorCode = "V001";

    public ValidationException(){
        setErrorCode(errorCode);
    }

}
