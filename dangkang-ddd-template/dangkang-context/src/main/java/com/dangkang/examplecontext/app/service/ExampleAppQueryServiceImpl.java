package com.dangkang.examplecontext.app.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.dangkang.application.annotation.ServiceDesc;
import com.dangkang.application.dto.response.MultipleResponse;
import com.dangkang.examplecontext.client.api.ExampleAppQueryService;
import com.dangkang.examplecontext.client.dto.request.ExampleQueryRequestDTO;
import com.dangkang.examplecontext.client.dto.response.ExampleQueryResultDTO;
import com.dangkang.examplecontext.domain.repository.ExampleAggregateRootRepository;
import com.dangkang.exception.annotation.ExceptionAndValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 查询应用服务
 * 1.应用服务以*AppServiceImpl命名
 * 2.查询的输入和输出定义在client中。
 * @date 2023/1/11 10:51
 */
@Service
public class ExampleAppQueryServiceImpl implements ExampleAppQueryService {
    private static final Logger logger = LoggerFactory.getLogger(ExampleAppQueryServiceImpl.class);

    @Autowired
    private ExampleAggregateRootRepository domainObjectRepository;

    @Override
    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "T002",ServiceName = "当康应用查询服务")
    public MultipleResponse<ExampleQueryResultDTO> queryService(@FluentValid(isFailFast = false) ExampleQueryRequestDTO exampleQueryRequestDTO) {

        MultipleResponse<ExampleQueryResultDTO> response = new MultipleResponse<>();
        int index = exampleQueryRequestDTO.getIndex();
        int size = exampleQueryRequestDTO.getSize();
        String email = exampleQueryRequestDTO.getEmail();
         Map<String,Object> pages = domainObjectRepository.findPage(index,size,email);
        response.buildPage( pages);
        response.buildSuccess(SERVICE_CODE, SERVICE_NAME);
        return response;

    }

}
