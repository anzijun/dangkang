package it.pkg.dangkang.client.dto.validator;


import it.pkg.baidu.unbiz.fluentvalidator.ValidationError;
import it.pkg.baidu.unbiz.fluentvalidator.Validator;
import it.pkg.baidu.unbiz.fluentvalidator.ValidatorContext;
import it.pkg.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @date 2022/12/19 10:25
 */
public class PhoneNumberValidator extends ValidatorHandler<String> implements Validator<String> {

    @Override
    public boolean validate(ValidatorContext context, String s) {
        if("0".equals(s.substring(0,1)) || s.length() != 11){
            context.addError(ValidationError.create("手机号码不符合规则")
                    .setField("phoneNumber")
                    .setInvalidValue(s));
            return false;
        }
        return true;
    }
}
