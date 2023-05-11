package com.dangkang.shclearinghouse.client.dto;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @date 2022/12/19 10:25
 */
public class ReportNameValidator extends ValidatorHandler<String> implements Validator<String> {
    @Override
    public boolean validate(ValidatorContext context, String reportName) {
        boolean isValid=ReportType.isRightReportName(reportName);
        if(!isValid){
            context.addError(ValidationError.create("报表不存在").setInvalidValue(reportName).setField("reportName"));
        }
        return isValid;
    }



}
