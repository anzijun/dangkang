#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.app.domain.model.trade.ability.factoryimpl;

import ${package}.${project-name}.domain.model.trade.DomainObject;
import ${package}.${project-name}.domain.model.trade.ability.factory.DomainObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class DomainObjectFactoryImpl implements DomainObjectFactory {

    @Override
    public DomainObject initDomainObject(String email, String phoneNumber) {

        DomainObject domainObject = new DomainObject(email,phoneNumber);
        return domainObject;
    }
}
