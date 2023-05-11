package com.dangkang.examplecontext.infrastructure.converter;

import com.dangkang.examplecontext.infrastructure.repository.dataobject.DomainObjectDO;
import com.dangkang.examplecontext.client.dto.response.ExampleQueryResultDTO;
import com.dangkang.examplecontext.domain.facade.CallRequest;
import com.dangkang.examplecontext.domain.model.DomainObject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 *  对象转换，应用Mapstruct（https://github.com/mapstruct/mapstruct）
 * @date 2022/12/23 18:01
 */
@Mapper
public interface ExampleContextConverter {
    ExampleContextConverter INSTANCE = Mappers.getMapper(ExampleContextConverter.class);

    DomainObjectDO toDomainObjectDO(DomainObject domainObject);

    DomainObject toDomainObject(DomainObjectDO domainObjectDO);

    CallRequest toCallRequestDto(DomainObject domainObject);

    List<DomainObject> toDomainObjectList(List<DomainObjectDO> domainObjects);

    List<ExampleQueryResultDTO> toQueryResultDataDtoList(List<DomainObject> domainObjects);

}
