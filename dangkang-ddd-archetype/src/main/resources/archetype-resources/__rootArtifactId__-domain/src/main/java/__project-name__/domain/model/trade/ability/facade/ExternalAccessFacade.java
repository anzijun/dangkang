#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.model.trade.ability.facade;

import ${package}.${project-name}.domain.model.trade.type.CallRequestDto;
import ${package}.${project-name}.domain.model.trade.type.CallResult;
import ${package}.${project-name}.domain.model.trade.type.QueryRequestDto;
import ${package}.${project-name}.domain.model.trade.type.QueryResult;

/**
 * @date 2022/12/23 10:23
 */
public interface ExternalAccessFacade {

    String ERR_CALL_RETURN_UNKNOWN_CODE = "R001";
    String ERR_CALL_RETURN_UNKNOWN_MESSAGE = "call方法执行结果未知";

    CallResult call(CallRequestDto callRequestDto);

    QueryResult query(QueryRequestDto queryRequestDto);
}
