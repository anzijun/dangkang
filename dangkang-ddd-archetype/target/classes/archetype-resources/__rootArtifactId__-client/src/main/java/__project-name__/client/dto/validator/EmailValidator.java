#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.client.dto.validator;

import ${package}.baidu.unbiz.fluentvalidator.Validator;
import ${package}.baidu.unbiz.fluentvalidator.ValidatorContext;
import ${package}.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @date 2022/12/23 11:45
 */
public class EmailValidator extends ValidatorHandler<String> implements Validator<String> {

    @Override
    public boolean validate(ValidatorContext context, String s) {
        return super.validate(context, s);
    }
}
