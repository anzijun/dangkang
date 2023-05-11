#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.adapter.web;

import ${package}.${project-name}.client.api.ApplicationService;
import ${package}.${project-name}.client.dto.ApplicationServiceDTO;
import ${package}.${project-name}.client.dto.protocol.request.ApplicationServiceRequest;
import ${package}.${project-name}.client.dto.protocol.response.ApplicationServiceResponse;
import ${package}.${project-name}.client.dto.result.ApplicationServiceResult;
import ${package}.${project-name}.infrastructure.converter.ApplicationServiceDtoConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceController.class);

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/hello")
    @ResponseBody
    public ApplicationServiceResponse execute(@RequestBody ApplicationServiceRequest request){

        logger.info("ApplicationService请求参数 request = [{}]",request);
        ApplicationServiceDTO applicationServiceDTO = ApplicationServiceDtoConverter.INSTANCE.toApplicationServiceDTO(request);
        ApplicationServiceResult applicationServiceResult = applicationService.execute(applicationServiceDTO);
        ApplicationServiceResponse response = ApplicationServiceDtoConverter.INSTANCE.toApplicationServiceResponse(applicationServiceResult);
        logger.info("ApplicationService响应参数 response = [{}]",response);
        return response;
    }
}
