package com.dangkang.examplecontext.infrastructure.converter;

import com.dangkang.examplecontext.app.service.dto.request.ExampleQueryRequestDTO;
import com.dangkang.examplecontext.app.service.dto.request.ExampleServiceRequestDTO;
import com.dangkang.examplecontext.app.service.dto.response.ExampleServiceResponseDTO;
import com.dangkang.examplecontext.client.dto.request.ExampleQueryRequest;
import com.dangkang.examplecontext.client.dto.request.ExampleServiceRequest;
import com.dangkang.examplecontext.client.dto.response.ExampleQueryResponse;
import com.dangkang.examplecontext.client.dto.response.ExampleServiceResponse;
import com.dangkang.examplecontext.infrastructure.repository.dataobject.DomainObjectDO;
import com.dangkang.examplecontext.app.service.dto.response.ExampleQueryResponseDTO;
import com.dangkang.examplecontext.domain.facade.CallRequest;
import com.dangkang.examplecontext.domain.model.DomainObject;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 *  对象转换，应用Mapstruct（https://github.com/mapstruct/mapstruct）
 * @date 2022/12/23 18:01
 */
@Mapper
public interface ExampleConverter {
    ExampleConverter INSTANCE = Mappers.getMapper(ExampleConverter.class);

    ExampleServiceResponse convert(ExampleServiceResponseDTO exampleServiceResponseDTO);
    ExampleServiceRequestDTO convert(ExampleServiceRequest exampleServiceRequest);

    ExampleQueryResponse convert(ExampleQueryResponseDTO exampleQueryResponseDTO);
    ExampleQueryRequestDTO convert(ExampleQueryRequest exampleQueryRequest);

    DomainObjectDO convert(DomainObject domainObject);

    DomainObject convert(DomainObjectDO domainObjectDO);

    CallRequest convertCallRequestDto(DomainObject domainObject);

    List<DomainObject> convert(List<DomainObjectDO> domainObjects);

    List<ExampleQueryResponseDTO> convertQueryResultDataDtoList(List<DomainObject> domainObjects);

}
