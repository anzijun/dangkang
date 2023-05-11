package it.pkg.dangkang.client.dto.validator;

import it.pkg.baidu.unbiz.fluentvalidator.Validator;
import it.pkg.baidu.unbiz.fluentvalidator.ValidatorContext;
import it.pkg.baidu.unbiz.fluentvalidator.ValidatorHandler;
import it.pkg.dangkang.client.dto.ApplicationServiceDTO;

/**
 * 入参校验器示例
 */
public class ApplicationServiceDtoValidator extends ValidatorHandler<ApplicationServiceDTO> implements Validator<ApplicationServiceDTO> {

    @Override
    public boolean validate(ValidatorContext context, ApplicationServiceDTO applicationServiceDTO) {
        if(applicationServiceDTO.getEmail() == null){
            context.addErrorMsg("不能为空");
            return false;
        }
        return true;
    }
}
