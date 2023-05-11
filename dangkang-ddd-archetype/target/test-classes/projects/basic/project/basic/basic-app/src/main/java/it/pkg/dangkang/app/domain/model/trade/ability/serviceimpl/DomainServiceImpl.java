package it.pkg.dangkang.app.domain.model.trade.ability.serviceimpl;

import it.pkg.dangkang.domain.exception.ApplicationException;
import it.pkg.dangkang.domain.model.trade.DomainObject;
import it.pkg.dangkang.domain.model.trade.ability.domainService.DomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 领域服务实现逻辑
 * @date 2022/12/23 11:29
 */
@Component
public class DomainServiceImpl implements DomainService {

    private static final Logger logger = LoggerFactory.getLogger(DomainServiceImpl.class);

    @Override
    public void doService(DomainObject domainObject) {
        //todo 封装多个领域对象协作并具有一定重用性的功能，可能会在多个applicationService之间重用。
        domainObject.toDo();
        logger.info("DomainObject.toDo领域逻辑执行成功");
        //领域服务抛出异常示例
        if("domainService@email.it.pkg".equals(domainObject.getEmail())){
            throw new ApplicationException().setErrorCode(ERR_DOMAIN_SERVICE_CODE)
                                            .setPromptMessage(ERR_DOMAIN_SERVICE_MESSAGE);
        }
        logger.info("DomainServiceImpl.doService领域服务执行成功");
    }
}
