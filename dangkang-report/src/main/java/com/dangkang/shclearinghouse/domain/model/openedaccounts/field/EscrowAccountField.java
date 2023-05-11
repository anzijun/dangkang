package com.dangkang.shclearinghouse.domain.model.openedaccounts.field;


import com.dangkang.report.domain.model.Field;
import com.dangkang.shclearinghouse.domain.model.util.FieldFormat;

/**
 * @author Orkesh
 * @date 2023/2/21 13:10
 * 描述 :         二级托管账号Field对象
 */
public class EscrowAccountField implements Field {

    public static final Integer SH_FORMAT_C_18 = 18 ;

    private String escrowAccount ;

    public EscrowAccountField(String originalEscrowAccount) {
        this.escrowAccount = FieldFormat.rightFillFormat(originalEscrowAccount,
                SH_FORMAT_C_18) ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    public String format() {
        return this.escrowAccount ;
    }

    public String getEscrowAccount() {
        return escrowAccount;
    }
}
