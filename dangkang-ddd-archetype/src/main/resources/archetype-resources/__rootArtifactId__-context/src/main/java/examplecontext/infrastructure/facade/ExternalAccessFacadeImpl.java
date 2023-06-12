#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.infrastructure.facade;

import ${package}.examplecontext.domain.facade.CallRequest;
import ${package}.examplecontext.domain.facade.CallResult;
import ${package}.examplecontext.domain.facade.ExternalAccessFacade;
import ${package}.examplecontext.domain.facade.QueryResult;
import ${package}.exception.DangKangAppException;
import ${package}.exception.net.NetErrorContext;
import ${package}.exception.net.NetErrorManager;
import ${package}.examplecontext.infrastructure.config.ExternalConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 防腐层实现，可以用Adapter设计模式
 * @date 2022/12/19 14:47
 */
@Component
public class ExternalAccessFacadeImpl implements ExternalAccessFacade {

    private static final String EXTERNAL_SYSTEM_SUCCESS = "0000";//外部返回的成功码
    private static final Logger logger = LoggerFactory.getLogger(ExternalAccessFacadeImpl.class);

    @Autowired
    private ExternalConfig externalConfig;

    @Override
    public CallResult call(CallRequest callRequestDto) {
        CallResult result = new CallResult();
        String url = String.format(externalConfig.getUrl(),externalConfig.getCallServiceName());
        ExternalClient externalClient = new ExternalClient(url,externalConfig.getConnectionTimeoutForCallService() ,externalConfig.getReadTimeoutForCallService());
        try {
            //todo 根据上下文创建第三方接口toCall方法请求的数据报文
            ExternalRequest request = new ExternalRequest();
            request.setEmail(callRequestDto.getEmail());
            request.setPhoneNumber(callRequestDto.getPhoneNumber());
            logger.info("第三方toCall方法调用：request = [{}]",request);
            ExternalResponse externalResponse = externalClient.toCall(request);
            logger.info("第三方toCall方法调用结果：response = [{}]",externalResponse);
            if(EXTERNAL_SYSTEM_SUCCESS.equals(externalResponse.getCode())){
                result.setResultCode(CallResult.SUCCESS_CODE);
            }else{
                result.setResultCode(CallResult.FAILURE_CODE);
            }

        } catch (Exception e) {
            logger.error("第三方接口external.toCall调用失败",e);
            //读超时异常时，发起toCall方法执行结果的查询服务query
            if(NetErrorManager.isReadTimeout(e)){
                ${package}.examplecontext.domain.facade.QueryRequest queryRequestDto = getQueryRequestDto();//查询请求所需要的数据
                QueryResult queryResult = queryResult = query(queryRequestDto);
                return convert(queryResult);//如果查询toCall执行结果能成功返回，以此次查询结果为准
            }
            throw new DangKangAppException().setErrorCode(NetErrorManager.ERR_NETWORK_CODE)
                                            .setPromptMessage(ERR_CALL_RETURN_UNKNOWN_MESSAGE)
                                            .setDetailMessage(NetErrorManager.parse(new NetErrorContext()
                                                                                        .setThrowable(e)
                                                                                        .setRemoteIp(url)
                                                                                        .setConnectTimeout(externalConfig.getConnectionTimeoutForCallService())
                                                                                        .setReadTimeout(externalConfig.getReadTimeoutForCallService())))
                                            .setCause(e);
        }
        return result;
    }

    public QueryResult query(${package}.examplecontext.domain.facade.QueryRequest queryRequestDto){
        QueryResult result = new QueryResult();
        String url = String.format(externalConfig.getUrl(),externalConfig.getQueryServiceName()) ;
        QueryClient client = new QueryClient(url,externalConfig.getConnectionTimeoutForQueryService(),externalConfig.getReadTimeoutForQueryService());
        try {
            QueryRequest request = new QueryRequest();
            logger.info("第三方toQuery方法调用：request = [{}]",request);
            QueryResponse response = client.toQuery(request);
            logger.info("第三方toQuery方法调用：response = [{}]",response);
            if(EXTERNAL_SYSTEM_SUCCESS.equals(response.getCode())){
                result.setResultCode(QueryResult.SUCCESS_CODE);
                result.setResultData(response.getData());
            }else{
                result.setResultCode(QueryResult.FAILURE_CODE);
            }
        } catch (Exception e) {
            logger.error("第三方toCall方法读取超时，发起toCall方法状态查询的toQuery方法，toQuery执行再次发生异常，" +
                         "此时toCall方法执行结果未知，这会导致当前系统与第三方系统数据可能不一致，" +
                         "此处一般应完整记录当前场景信息并立即告警通知异常处理平台或人工处理");
            throw new DangKangAppException().setErrorCode(ERR_CALL_RETURN_UNKNOWN_CODE)
                                            .setPromptMessage(ERR_CALL_RETURN_UNKNOWN_MESSAGE)
                                            .setCause(e);
        }
        return result;
    }

    private ${package}.examplecontext.domain.facade.QueryRequest getQueryRequestDto(){
        //todo 由上下文生成查询call执行结果的请求数据
        return new ${package}.examplecontext.domain.facade.QueryRequest();
    }

    private CallResult convert(QueryResult queryResult){
        //todo 查询结果转换为call执行的结果
        return new CallResult();
    }
}
