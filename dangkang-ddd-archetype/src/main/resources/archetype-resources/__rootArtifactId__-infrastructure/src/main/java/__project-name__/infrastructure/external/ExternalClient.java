#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.infrastructure.external;

import ${package}.${project-name}.infrastructure.${package}mon.Constant;
import org.springframework.web.util.pattern.PathPattern;

import java.net.ConnectException;
import java.rmi.RemoteException;

/**
 * @date 2022/12/20 17:38
 */
public class ExternalClient extends NetClient {

    public ExternalClient(String url, Integer readTimeout, Integer connectTimeout) {
        super(url, readTimeout, connectTimeout);
    }

    public ExternalResponse toCall(ExternalRequest request)throws RemoteException{

        if(url == null || !url.contains(IP)){
            throw new RemoteException("远程连接被拒绝",new ConnectException("Connection refused"));
        }

        return new ExternalResponse().setCode(SUCCEED);
    }


}
