package com.dangkang.shclearinghouse.domain.model.openedaccounts.field;


import com.dangkang.report.domain.model.Field;
import com.dangkang.shclearinghouse.domain.model.util.FieldFormat;

/**
 * @author Orkesh
 * @date 2023/2/21 13:29
 * 描述 :         投资人全称 Field 对象
 */
public class InvestorFullnameField implements Field {

    public static final Integer SH_FORMAT_C_200 = 200 ;

    private String investorFullName ;

    public InvestorFullnameField(String originalFullname ) {
        this.investorFullName = FieldFormat.rightFillFormat(originalFullname,
                SH_FORMAT_C_200) ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    public String format() {
        return this.investorFullName ;
    }

    public String getInvestorFullName() {
        return investorFullName;
    }
}
