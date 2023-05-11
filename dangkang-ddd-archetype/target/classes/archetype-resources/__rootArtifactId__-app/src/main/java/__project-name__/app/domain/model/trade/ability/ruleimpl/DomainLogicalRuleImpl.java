#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.app.domain.model.trade.ability.ruleimpl;

import ${package}.${project-name}.domain.exception.ValidationException;
import ${package}.${project-name}.domain.model.trade.DomainObject;
import ${package}.${project-name}.domain.model.trade.ability.rule.DomainLogicalRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 业务领域规则对象:复杂业务规则的封装
 * @date 2022/12/23 13:53
 */
@Component
public class DomainLogicalRuleImpl implements DomainLogicalRule {

    private static final Logger logger = LoggerFactory.getLogger(DomainLogicalRuleImpl.class);


    /**
     *
     * 业务规则校验异常示例
     */
    @Override
    public void check(DomainObject domainObject) {

        //todo 领域校验逻辑执行
        logger.info("领域校验逻辑执行");
        //业务规则校验示例 实际业务规则应是有关多个领域对象的属性或复杂规则验证
        if("domainrule@email.${package}".equals(domainObject.getEmail())){
            throw new ValidationException().setErrorCode(ERR_DOMAINLOGICRULE_CODE)
                                            .setPromptMessage(ERR_DOMAINLOGICRULE_MESSAGE);
        }

    }

}
