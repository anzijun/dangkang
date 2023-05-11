package it.pkg.dangkang.infrastructure.converter;

import it.pkg.dangkang.domain.model.trade.DomainObject;
import it.pkg.dangkang.domain.model.trade.type.CallRequestDto;
import it.pkg.dangkang.infrastructure.repositoryimpl.dataobject.DomainObjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @date 2022/12/23 18:01
 */
@Mapper
public interface DomainObjectConverter {
    DomainObjectConverter INSTANCE = Mappers.getMapper(DomainObjectConverter.class);

    DomainObjectDO toDomainObjectDO(DomainObject domainObject);

    DomainObject toDomainObject(DomainObjectDO domainObjectDO);

    CallRequestDto toCallRequestDto(DomainObject domainObject);
}
