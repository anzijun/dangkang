package com.dangkang.examplecontext.app.service.dto.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.dangkang.examplecontext.client.dto.request.ExampleServiceRequest;

/**
 * 入参校验器示例
 */
public class ExampleServiceDtoValidator extends ValidatorHandler<ExampleServiceRequest> implements Validator<ExampleServiceRequest> {

    @Override
    public boolean validate(ValidatorContext context, ExampleServiceRequest exampleServiceRequest) {
        if(exampleServiceRequest.getEmail() == null){
            context.addErrorMsg("不能为空");
            return false;
        }
        return true;
    }
}
