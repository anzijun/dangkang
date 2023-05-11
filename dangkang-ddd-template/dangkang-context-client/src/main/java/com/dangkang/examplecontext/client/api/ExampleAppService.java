package com.dangkang.examplecontext.client.api;

import com.dangkang.application.dto.response.Response;
import com.dangkang.examplecontext.client.dto.request.ExampleServiceRequestDTO;
import com.dangkang.examplecontext.client.dto.response.ExampleServiceResultDTO;

/**
 * 面向客户端调用，client sdk
 */
public interface ExampleAppService {
    String SERVICE_CODE ="T001";
    String SERVICE_NAME ="dangkang-ddd应用服务描述信息";

    Response<ExampleServiceResultDTO> execute(ExampleServiceRequestDTO exampleServiceRequestDTO);

}
