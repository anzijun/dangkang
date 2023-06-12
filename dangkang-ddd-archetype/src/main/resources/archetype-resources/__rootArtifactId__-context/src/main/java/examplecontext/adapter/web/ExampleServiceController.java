#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.adapter.web;

import ${package}.application.dto.response.MultipleResponse;
import ${package}.examplecontext.client.api.ExampleAppQueryService;
import ${package}.examplecontext.client.api.ExampleAppService;
import ${package}.examplecontext.app.service.dto.request.ExampleQueryRequestDTO;
import ${package}.examplecontext.app.service.dto.request.ExampleServiceRequestDTO;
import ${package}.examplecontext.app.service.dto.response.ExampleServiceResponseDTO;
import ${package}.examplecontext.app.service.dto.response.ExampleQueryResponseDTO;
import ${package}.examplecontext.client.dto.request.ExampleQueryRequest;
import ${package}.examplecontext.client.dto.request.ExampleServiceRequest;
import ${package}.examplecontext.client.dto.response.ExampleQueryResponse;
import ${package}.examplecontext.client.dto.response.ExampleServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 适配器（adapter）
 * 负责协议和消息转换
 */
@RestController
public class ExampleServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ExampleServiceController.class);

    @Autowired
    private ExampleAppService exampleAppService;
    @Autowired
    private ExampleAppQueryService exampleAppQueryService;

    @PostMapping("/hello")
    @ResponseBody
    public ExampleServiceResponse execute(@RequestBody ExampleServiceRequest exampleServiceRequest){

        logger.info("ExampleService请求参数 request = [{}]", exampleServiceRequest);
        ExampleServiceResponse response = exampleAppService.execute(exampleServiceRequest);
        logger.info("ExampleService响应参数 response = [{}]",response);
        return response;
    }

    @PostMapping("/query")
    @ResponseBody
    public ExampleQueryResponse queryService(ExampleQueryRequest queryRequest){
        logger.info("ExampleQueryService请求参数 request = [{}]",queryRequest);
        ExampleQueryResponse response = exampleAppQueryService.queryService(queryRequest);
        logger.info("ExampleQueryService响应参数 response = [{}]",response);
        return response;
    }

}
