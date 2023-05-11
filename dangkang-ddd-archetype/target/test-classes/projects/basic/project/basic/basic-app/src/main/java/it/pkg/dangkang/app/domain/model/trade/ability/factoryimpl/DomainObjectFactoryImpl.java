package it.pkg.dangkang.app.domain.model.trade.ability.factoryimpl;

import it.pkg.dangkang.domain.model.trade.DomainObject;
import it.pkg.dangkang.domain.model.trade.ability.factory.DomainObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class DomainObjectFactoryImpl implements DomainObjectFactory {

    @Override
    public DomainObject initDomainObject(String email, String phoneNumber) {

        DomainObject domainObject = new DomainObject(email,phoneNumber);
        return domainObject;
    }
}
