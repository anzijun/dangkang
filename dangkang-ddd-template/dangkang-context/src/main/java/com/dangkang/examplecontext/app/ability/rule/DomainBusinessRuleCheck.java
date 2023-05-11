package com.dangkang.examplecontext.app.ability.rule;

import com.dangkang.examplecontext.domain.model.DomainObject;
import com.dangkang.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 领域服务（业务规则）
 * 1.业务规则通常可能在多个应用服务中重用，将业务规则封装为领域服务，以*Check命名
 * @date 2022/12/23 13:53
 */
@Component
public class DomainBusinessRuleCheck {

    private static final Logger logger = LoggerFactory.getLogger(DomainBusinessRuleCheck.class);
    private static final String ERR_DOMAINLOGICRULE_CODE="V002";
    private static final String ERR_DOMAINLOGICRULE_MESSAGE="领域规则校验出错提示";

    /**
     *
     * 业务规则校验异常示例
     */
    public void check(DomainObject domainObject) {

        //todo 领域校验逻辑执行
        //业务规则校验示例 实际业务规则应是有关多个领域对象的属性或复杂规则验证
        if("domainrule@email.com".equals(domainObject.getEmail())){
            throw new ValidationException().setErrorCode(ERR_DOMAINLOGICRULE_CODE)
                                            .setPromptMessage(ERR_DOMAINLOGICRULE_MESSAGE);
        }

    }

}
