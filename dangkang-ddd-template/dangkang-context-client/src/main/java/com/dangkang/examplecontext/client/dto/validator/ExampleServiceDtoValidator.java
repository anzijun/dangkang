package com.dangkang.examplecontext.client.dto.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.dangkang.examplecontext.client.dto.request.ExampleServiceRequestDTO;

/**
 * 入参校验器示例
 */
public class ExampleServiceDtoValidator extends ValidatorHandler<ExampleServiceRequestDTO> implements Validator<ExampleServiceRequestDTO> {

    @Override
    public boolean validate(ValidatorContext context, ExampleServiceRequestDTO exampleServiceRequestDTO) {
        if(exampleServiceRequestDTO.getEmail() == null){
            context.addErrorMsg("不能为空");
            return false;
        }
        return true;
    }
}
