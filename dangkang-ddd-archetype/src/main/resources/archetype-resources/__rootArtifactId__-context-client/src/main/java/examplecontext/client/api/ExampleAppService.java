#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.client.api;

import ${package}.examplecontext.client.dto.request.ExampleServiceRequest;
import ${package}.examplecontext.client.dto.response.ExampleServiceResponse;

/**
 * 面向客户端调用，client sdk
 */
public interface ExampleAppService {
    String SERVICE_CODE ="T001";
    String SERVICE_NAME ="dangkang-ddd应用服务描述信息";

    ExampleServiceResponse execute(ExampleServiceRequest exampleServiceRequest);

}
