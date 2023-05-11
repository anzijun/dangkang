#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.model.trade.ability.factory;

import ${package}.${project-name}.domain.model.trade.DomainObject;

/**
 * @date 2022/12/23 10:24
 */
public interface DomainObjectFactory {

    DomainObject initDomainObject(String email,String phoneNumber);
}
