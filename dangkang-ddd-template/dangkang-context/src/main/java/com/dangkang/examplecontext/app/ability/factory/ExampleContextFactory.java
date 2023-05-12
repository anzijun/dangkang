package com.dangkang.examplecontext.app.ability.factory;

import com.dangkang.examplecontext.app.service.dto.request.ExampleServiceRequestDTO;
import com.dangkang.examplecontext.domain.model.DomainObject;
import org.springframework.stereotype.Component;
/*
* DDD工厂：
* 1.为一个限界上下文定义一个工厂类，如果工厂方法过多，再考虑将工厂方法分类分成多个工厂类。
* 2. 从应用服务参数创建对象时用init*方法，表示新对象生成，用build*方法表示再次赋值。
 */
@Component
public class ExampleContextFactory {

    public DomainObject initDomainObject(String email, String phoneNumber) {

        DomainObject domainObject = new DomainObject(email,phoneNumber);
        return domainObject;
    }

    public DomainObject initDomainObject(ExampleServiceRequestDTO exampleServiceRequest) {
        DomainObject domainObject = new DomainObject();
        domainObject.setEmail(exampleServiceRequest.getEmail()).
                                 setPhoneNumber(exampleServiceRequest.getPhoneNumber());
        return domainObject;
    }
}
