#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.client.dto.validator;

import ${package}.baidu.unbiz.fluentvalidator.Validator;
import ${package}.baidu.unbiz.fluentvalidator.ValidatorContext;
import ${package}.baidu.unbiz.fluentvalidator.ValidatorHandler;
import ${package}.${project-name}.client.dto.ApplicationServiceDTO;

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
