package com.dangkang.shclearinghouse.domain.model.openedaccounts.field;



import com.dangkang.report.domain.model.Field;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/21 13:32
 * 描述 :         日期Field对象
 */
public class DateField implements Field {

    public static final String SH_FORMAT_DATE = "yyyyMMdd" ;

    private String openedDate ;

    public DateField(Date originalOpenedDate) {
        this.openedDate = new SimpleDateFormat(SH_FORMAT_DATE).format(originalOpenedDate);
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    public String format() {
        return this.openedDate ;
    }

    public String getOpenedDate() {
        return openedDate;
    }
}
