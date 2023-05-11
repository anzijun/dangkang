package it.pkg.dangkang.infrastructure.converter;

import it.pkg.dangkang.client.dto.protocol.request.ApplicationServiceRequest;
import it.pkg.dangkang.client.dto.protocol.response.ApplicationServiceResponse;
import it.pkg.dangkang.client.dto.result.ApplicationServiceResult;
import it.pkg.dangkang.client.dto.ApplicationServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @date 2022/12/23 10:26
 */
@Mapper
public interface ApplicationServiceDtoConverter {
    ApplicationServiceDtoConverter INSTANCE = Mappers.getMapper(ApplicationServiceDtoConverter.class);

    ApplicationServiceDTO toApplicationServiceDTO(ApplicationServiceRequest applicationServiceRequest);

    @Mapping(source = "resultType",target = "type")
    @Mapping(source = "resultCode",target = "code")
    @Mapping(source = "resultDescription",target = "message")
    ApplicationServiceResponse toApplicationServiceResponse(ApplicationServiceResult applicationServiceResult);
}
