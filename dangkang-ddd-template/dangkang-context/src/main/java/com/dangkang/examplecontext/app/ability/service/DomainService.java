package com.dangkang.examplecontext.app.ability.service;

import com.dangkang.examplecontext.domain.facade.ExternalAccessFacade;
import com.dangkang.examplecontext.domain.model.DomainObject;
import com.dangkang.examplecontext.domain.repository.ExampleAggregateRootRepository;
import com.dangkang.examplecontext.infrastructure.converter.ExampleConverter;
import com.dangkang.exception.DangKangAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 领域服务
 * 1.协调聚合之间以及聚合与第三方访问（ACL）
 * 2. 在多个应用服务中具有重用
 * @date 2022/12/23 11:29
 */
@Component
public class DomainService {

    private static final String ERR_DOMAIN_SERVICE_CODE="S001";
    private static final String ERR_DOMAIN_SERVICE_MESSAGE="领域服务出错提示";
    private static final Logger logger = LoggerFactory.getLogger(DomainService.class);

    @Autowired
    private ExampleAggregateRootRepository domainObjectRepository;

    @Autowired
    private ExternalAccessFacade externalAccessFacade;

    public void doService(DomainObject domainObject) {

        domainObject.toDo();
        //领域服务抛出异常示例
        if("domainService@email.com".equals(domainObject.getEmail())){
            throw new DangKangAppException().setErrorCode(ERR_DOMAIN_SERVICE_CODE)
                                            .setPromptMessage(ERR_DOMAIN_SERVICE_MESSAGE);
        }
        // 3.3 调用第三方接口
        externalAccessFacade.call(ExampleConverter.INSTANCE.convertCallRequestDto(domainObject));
        logger.info("externalAccessFacade.call执行成功,客户号是[{}]",domainObject.getEmail());
    }

    public DomainObject findAndCheckEmpty(String phoneNumber) {
        return domainObjectRepository.findAndCheckEmpty(phoneNumber);
    }
}
