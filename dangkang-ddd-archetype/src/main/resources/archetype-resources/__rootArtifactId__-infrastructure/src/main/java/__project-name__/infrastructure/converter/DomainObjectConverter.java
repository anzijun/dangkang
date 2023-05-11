#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.infrastructure.converter;

import ${package}.${project-name}.domain.model.trade.DomainObject;
import ${package}.${project-name}.domain.model.trade.type.CallRequestDto;
import ${package}.${project-name}.infrastructure.repositoryimpl.dataobject.DomainObjectDO;
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
