package it.pkg.dangkang.adapter.web;

import it.pkg.dangkang.client.api.ApplicationService;
import it.pkg.dangkang.client.dto.ApplicationServiceDTO;
import it.pkg.dangkang.client.dto.protocol.request.ApplicationServiceRequest;
import it.pkg.dangkang.client.dto.protocol.response.ApplicationServiceResponse;
import it.pkg.dangkang.client.dto.result.ApplicationServiceResult;
import it.pkg.dangkang.infrastructure.converter.ApplicationServiceDtoConverter;
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
