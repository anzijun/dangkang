#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.app.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import ${package}.examplecontext.app.ability.factory.ExampleContextFactory;
import ${package}.examplecontext.app.ability.rule.DomainBusinessRuleCheck;
import ${package}.examplecontext.app.ability.service.DomainService;
import ${package}.application.annotation.ServiceDesc;
import ${package}.examplecontext.client.api.ExampleAppService;
import ${package}.examplecontext.app.service.dto.request.ExampleServiceRequestDTO;
import ${package}.examplecontext.app.service.dto.response.ExampleServiceResponseDTO;
import ${package}.examplecontext.client.dto.request.ExampleServiceRequest;
import ${package}.examplecontext.client.dto.response.ExampleServiceResponse;
import ${package}.examplecontext.domain.model.DomainObject;
import ${package}.examplecontext.infrastructure.converter.ExampleConverter;
import ${package}.exception.annotation.ExceptionAndValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用服务
 * 1.与业务服务（业务用例）的操作流程一一对应，确切表达业务语义
 * 2.只负责业务编排，没有任何具体业务逻辑。
 * 3.使用@ExceptionAndValid和@FluentValid注解输入参数校验和异常统一处理
 * 4.避免事务脚本
 */
@Service
public class ExampleAppServiceImpl implements ExampleAppService {

    private static final Logger logger = LoggerFactory.getLogger(ExampleAppServiceImpl.class);

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainBusinessRuleCheck domainLogicalCheck;
    @Autowired
    private ExampleContextFactory domanObjectFactory;
    @Autowired
    private ExampleServiceTransaction exampleServiceTransaction;

    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "T001",ServiceName = "DDD应用服务")
    public ExampleServiceResponseDTO execute(@FluentValid(isFailFast=false) ExampleServiceRequestDTO exampleServiceRequest) {

            // 1 调用工厂初始化（ddd 工厂）
            DomainObject domainObject = domanObjectFactory.initDomainObject(exampleServiceRequest);
            // 2 业务规则（领域服务）
            domainLogicalCheck.check(domainObject);
            logger.info("DomainLogicalRule.check领域逻辑规则校验成功,客户号是[{}]", exampleServiceRequest.getEmail());

            // 3 领域服务
            domainService.doService(domainObject);
            logger.info("DomainService.doService领域服务执行成功,客户号是[{}]", exampleServiceRequest.getEmail());

            // 4 带事务的领域服务执行
            exampleServiceTransaction.transaction(domainObject);
            logger.info("ExampleServiceTransaction.transaction事务服务执行成功,客户号是[{}]", exampleServiceRequest.getEmail());

            // 5 构建成功返回
            ExampleServiceResponseDTO response = new ExampleServiceResponseDTO();
            response.buildSuccess(SERVICE_CODE, SERVICE_NAME);
            response.setData("ok");
            logger.info("exampleAppService.execute执行成功,客户号是[{}]", exampleServiceRequest.getEmail());
        return response;
    }

    @Override
    public ExampleServiceResponse execute(ExampleServiceRequest exampleServiceRequest) {
        ExampleServiceResponseDTO  responseDTO=this.execute(ExampleConverter.INSTANCE.convert(exampleServiceRequest));
        return ExampleConverter.INSTANCE.convert(responseDTO);
    }
}
