package it.pkg.dangkang.client.dto.validator;

import it.pkg.baidu.unbiz.fluentvalidator.Validator;
import it.pkg.baidu.unbiz.fluentvalidator.ValidatorContext;
import it.pkg.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @date 2022/12/23 11:45
 */
public class EmailValidator extends ValidatorHandler<String> implements Validator<String> {

    @Override
    public boolean validate(ValidatorContext context, String s) {
        return super.validate(context, s);
    }
}
