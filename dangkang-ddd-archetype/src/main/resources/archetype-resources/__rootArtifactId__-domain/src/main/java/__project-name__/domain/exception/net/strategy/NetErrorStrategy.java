#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.exception.net.strategy;

import ${package}.${project-name}.domain.exception.net.NetError;
import ${package}.${project-name}.domain.exception.net.NetErrorContext;

/**
 * @author anzj
 * @date 2022/12/20 15:39
 */
public interface NetErrorStrategy {

    NetError parseNetError(NetErrorContext context);

    boolean accept(Throwable t);
}
