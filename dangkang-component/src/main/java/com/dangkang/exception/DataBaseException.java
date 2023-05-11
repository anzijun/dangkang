package com.dangkang.exception;

public class DataBaseException extends DangKangAppException {

    public static final String ERR_DATABASE_CODE="D001";


    public DataBaseException(){
        setErrorCode(ERR_DATABASE_CODE);
    }
}
