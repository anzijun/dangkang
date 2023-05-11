package com.dangkang.shclearinghouse.domain.model.openedaccounts.field;


import com.dangkang.report.domain.model.Field;
import com.dangkang.shclearinghouse.domain.model.util.FieldFormat;

/**
 * @author Orkesh
 * @date 2023/2/21 12:27
 * 描述 :         身份识别码Field对象
 */
public class IdentityNumberField implements Field {

    public static final Integer SH_FORMAT_C_20 = 20 ;

    private String identityNumber ;

    public IdentityNumberField (String originalIdentityNumber) {
        this.identityNumber = FieldFormat.rightFillFormat(originalIdentityNumber,
                SH_FORMAT_C_20) ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    public String format() {
        return this.identityNumber ;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }
}
