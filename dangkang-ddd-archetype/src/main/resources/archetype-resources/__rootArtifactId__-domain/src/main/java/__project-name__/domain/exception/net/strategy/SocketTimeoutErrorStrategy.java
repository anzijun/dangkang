#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.exception.net.strategy;

import ${package}.${project-name}.domain.exception.net.NetError;
import ${package}.${project-name}.domain.exception.net.NetErrorContext;
import ${package}.${project-name}.domain.exception.net.NetErrorManager;

import java.net.SocketTimeoutException;

/**
 * @date 2022/12/20 15:42
 */
public class SocketTimeoutErrorStrategy implements NetErrorStrategy {
    @Override
    public NetError parseNetError(NetErrorContext context) {
        NetError error = null;
        String message = context.getThrowable().getMessage();

        if(message.contains(NetErrorManager.SOCKET_READ_TIMEOUT)){
            error = NetErrorManager.ERR_SOCKET_READ_TIMEOUT.buildError(context.getLocalhost(),context.getRemoteIp(),String.valueOf(context.getReadTimeout()));
        }else  if(message.contains(NetErrorManager.SOCKET_CONNECTION_TIMEOUT)){
            error = NetErrorManager.ERR_CONNECTION_TIMEOUT.buildError(context.getLocalhost(),context.getRemoteIp(),String.valueOf(context.getConnectTimeout()));
        }
        return error;
    }

    @Override
    public boolean accept(Throwable t) {
        if(t instanceof SocketTimeoutException){
            return true;
        }
        return false;
    }
}
