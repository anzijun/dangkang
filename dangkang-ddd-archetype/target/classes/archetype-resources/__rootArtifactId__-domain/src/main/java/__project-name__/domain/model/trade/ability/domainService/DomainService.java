#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.model.trade.ability.domainService;

import ${package}.${project-name}.domain.model.trade.DomainObject;

/**
 * 领域服务定义：1、负责applicationService中某一个主逻辑步骤的具体实现
 */
public interface DomainService {

    String ERR_DOMAIN_SERVICE_CODE="S001";
    String ERR_DOMAIN_SERVICE_MESSAGE="领域服务出错提示";

    void doService(DomainObject domainObject);

}
