#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.exception.net.strategy;

import ${package}.${project-name}.domain.exception.net.NetError;
import ${package}.${project-name}.domain.exception.net.NetErrorContext;
import ${package}.${project-name}.domain.exception.net.NetErrorManager;

import java.net.ConnectException;

/**
 * @date 2022/12/20 15:42
 */
public class ConnectErrorStrategy implements NetErrorStrategy {

    @Override
    public NetError parseNetError(NetErrorContext context) {
        NetError error = null;
        String message = context.getThrowable().getMessage();

        if(message.contains(NetErrorManager.CONNECTION_REFUSED)){
            error = NetErrorManager.ERR_CONNECTION_REFUSED.buildError(context.getLocalhost(),context.getRemoteIp());
        }else if(message.contains(NetErrorManager.CONNECTION_TIMEOUT)){
            error = NetErrorManager.ERR_CONNECTION_TIMEOUT.buildError(context.getLocalhost(),context.getRemoteIp(),String.valueOf(context.getConnectTimeout()));
        }
        return error;
    }
    @Override
    public boolean accept(Throwable t) {
        if(t instanceof ConnectException){
            return true;
        }
        return false;
    }
}
