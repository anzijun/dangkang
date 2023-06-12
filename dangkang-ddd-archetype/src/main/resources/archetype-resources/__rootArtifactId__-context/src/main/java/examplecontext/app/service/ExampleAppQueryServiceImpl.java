#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.app.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import ${package}.application.annotation.ServiceDesc;
import ${package}.application.dto.response.MultipleResponse;
import ${package}.examplecontext.client.api.ExampleAppQueryService;
import ${package}.examplecontext.app.service.dto.request.ExampleQueryRequestDTO;
import ${package}.examplecontext.app.service.dto.response.ExampleQueryResponseDTO;
import ${package}.examplecontext.client.dto.request.ExampleQueryRequest;
import ${package}.examplecontext.client.dto.response.ExampleQueryResponse;
import ${package}.examplecontext.domain.repository.ExampleAggregateRootRepository;
import ${package}.examplecontext.infrastructure.converter.ExampleConverter;
import ${package}.exception.annotation.ExceptionAndValid;
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


    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "T002",ServiceName = "当康应用查询服务")
    public ExampleQueryResponseDTO queryService(@FluentValid(isFailFast = false) ExampleQueryRequestDTO exampleQueryRequestDTO) {

        ExampleQueryResponseDTO response = new ExampleQueryResponseDTO();
        int index = exampleQueryRequestDTO.getIndex();
        int size = exampleQueryRequestDTO.getSize();
        String email = exampleQueryRequestDTO.getEmail();
        response.setEmail(email);
        response.buildSuccess(SERVICE_CODE, SERVICE_NAME);
        return response;

    }

    @Override
    public ExampleQueryResponse queryService(ExampleQueryRequest exampleQueryRequest) {
        ExampleQueryRequestDTO requestDTO= ExampleConverter.INSTANCE.convert(exampleQueryRequest);
        ExampleQueryResponseDTO response=this.queryService((requestDTO));
        return ExampleConverter.INSTANCE.convert(response);
    }
}
