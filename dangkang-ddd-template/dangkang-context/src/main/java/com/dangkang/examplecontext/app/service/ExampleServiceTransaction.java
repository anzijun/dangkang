package com.dangkang.examplecontext.app.service;

import com.dangkang.examplecontext.domain.model.DomainObject;
import com.dangkang.examplecontext.domain.repository.ExampleAggregateRootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 领域服务（事务）
 * 将应用服务中带事务的处理逻辑封装为一个领域服务，使事务边界尽可能小
 * @date 2022/12/19 14:14
 */
@Component
public class ExampleServiceTransaction {

    @Autowired
    private ExampleAggregateRootRepository domainObjectRepository;

    /**
     * @param domainObject
     */
    @Transactional
    public void transaction(DomainObject domainObject){
        //todo 有事务的业务逻辑
        //1.1 带事务的存储服务
        domainObjectRepository.update(domainObject);

    }

}
