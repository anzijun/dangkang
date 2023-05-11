package com.dangkang.shclearinghouse.client.dto;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.dangkang.report.domain.exception.ReportException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.dangkang.shclearinghouse.client.dto.ReportRequest.DATE_FORMAT;

/**
 * @date 2022/12/19 10:25
 */
public class ReportDateValidator extends ValidatorHandler<String> implements Validator<String> {
    @Override
    public boolean validate(ValidatorContext context, String reportDate) {
        try {
            Date date=new SimpleDateFormat(DATE_FORMAT).parse(reportDate);
            if(date.getTime()>new Date().getTime()){
                context.addError(ValidationError.create("报表日期不能在今天之后").setInvalidValue(reportDate).setField("reportDate"));
                return false;
            }
        } catch (ParseException e) {
            context.addError(ValidationError.create(" 报表日期格式不正确, 正确的日期格式应为:"+DATE_FORMAT).setInvalidValue(reportDate).setField("reportDate"));
           return false;
        }
      return true;
    }



}
