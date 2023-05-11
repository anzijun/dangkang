#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.exception.net.strategy;

import ${package}.${project-name}.domain.exception.net.NetError;
import ${package}.${project-name}.domain.exception.net.NetErrorContext;
import ${package}.${project-name}.domain.exception.net.NetErrorManager;

import java.net.BindException;

/**
 * @date 2022/12/20 15:41
 */
public class BindErrorStrategy implements NetErrorStrategy {
    @Override
    public NetError parseNetError(NetErrorContext context) {
        return NetErrorManager.ERR_PORT_ALREADY_BIND.buildError(context.getLocalhost());
    }

    @Override
    public boolean accept(Throwable t) {
        if(t instanceof BindException){
            return true;
        }
        return false;
    }
}
