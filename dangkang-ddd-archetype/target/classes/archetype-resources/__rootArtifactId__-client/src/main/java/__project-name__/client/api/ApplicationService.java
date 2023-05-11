#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.client.api;

import ${package}.${project-name}.client.dto.ApplicationServiceDTO;
import ${package}.${project-name}.client.dto.result.ApplicationServiceResult;

/**
 * 应用服务
 */
public interface ApplicationService {
    String TRADE_CODE ="T001";
    String TRADE_DESCRIPTION ="${project-name}-ddd应用服务描述信息";

    ApplicationServiceResult execute(ApplicationServiceDTO applicationServiceDTO);

}
