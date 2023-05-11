package it.pkg.dangkang.domain.model.trade.ability.factory;

import it.pkg.dangkang.domain.model.trade.DomainObject;

/**
 * @date 2022/12/23 10:24
 */
public interface DomainObjectFactory {

    DomainObject initDomainObject(String email,String phoneNumber);
}
