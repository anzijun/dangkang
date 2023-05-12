package com.dangkang.examplecontext.adapter.web;

import com.dangkang.application.dto.response.MultipleResponse;
import com.dangkang.application.dto.response.Response;
import com.dangkang.examplecontext.client.api.ExampleAppQueryService;
import com.dangkang.examplecontext.client.api.ExampleAppService;
import com.dangkang.examplecontext.client.dto.request.ExampleQueryRequest;
import com.dangkang.examplecontext.client.dto.request.ExampleServiceRequest;
import com.dangkang.examplecontext.client.dto.response.ExampleServiceResult;
import com.dangkang.examplecontext.client.dto.response.ExampleQueryResult;
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
    public Response<ExampleServiceResult> execute(@RequestBody ExampleServiceRequest exampleServiceRequest){

        logger.info("ExampleService请求参数 request = [{}]", exampleServiceRequest);
        Response<ExampleServiceResult> response = exampleAppService.execute(exampleServiceRequest);
        logger.info("ExampleService响应参数 response = [{}]",response);
        return response;
    }

    @PostMapping("/query")
    @ResponseBody
    public MultipleResponse queryService(ExampleQueryRequest applicationQueryRequest){
        logger.info("ExampleQueryService请求参数 request = [{}]",applicationQueryRequest);
        MultipleResponse<ExampleQueryResult> response = exampleAppQueryService.queryService(applicationQueryRequest);
        logger.info("ExampleQueryService响应参数 response = [{}]",response);
        return response;
    }

}
