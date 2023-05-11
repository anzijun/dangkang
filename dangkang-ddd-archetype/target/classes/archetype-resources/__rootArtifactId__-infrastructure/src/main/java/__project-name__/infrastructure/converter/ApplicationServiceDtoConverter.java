#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.infrastructure.converter;

import ${package}.${project-name}.client.dto.protocol.request.ApplicationServiceRequest;
import ${package}.${project-name}.client.dto.protocol.response.ApplicationServiceResponse;
import ${package}.${project-name}.client.dto.result.ApplicationServiceResult;
import ${package}.${project-name}.client.dto.ApplicationServiceDTO;
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
