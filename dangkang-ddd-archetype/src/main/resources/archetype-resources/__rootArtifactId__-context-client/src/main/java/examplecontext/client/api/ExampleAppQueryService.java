#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.client.api;

import ${package}.application.dto.response.MultipleResponse;
import ${package}.examplecontext.client.dto.request.ExampleQueryRequest;
import ${package}.examplecontext.client.dto.response.ExampleQueryResponse;

/**
 * @date 2023/1/10 18:02
 */
public interface ExampleAppQueryService {

    String SERVICE_CODE ="T002";
    String SERVICE_NAME ="dangkang-ddd应用查询";

    ExampleQueryResponse queryService(ExampleQueryRequest exampleQueryRequest);
}
