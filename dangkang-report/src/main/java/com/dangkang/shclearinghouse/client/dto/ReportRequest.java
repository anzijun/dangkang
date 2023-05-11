package com.dangkang.shclearinghouse.client.dto;


import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;
import com.dangkang.application.dto.request.AbstractRequest;
import com.dangkang.report.domain.exception.ReportException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportRequest extends AbstractRequest {

    public static final String DATE_FORMAT="yyyymmdd";

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

     @FluentValidate({ReportNameValidator.class})
    private String reportName;
    @FluentValidate({ReportDateValidator.class})
    private String reportDate;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Date toReportDate(){
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(this.reportDate);
        } catch (ParseException e) {
            throw new ReportException().setPromptMessage("日期格式不正确:{%s}, 正确的日期格式应为:{%s}",this.reportDate, DATE_FORMAT);
        }
    }
}
