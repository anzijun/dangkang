#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.infrastructure.repositoryimpl.mapper;

import ${package}.${project-name}.infrastructure.repositoryimpl.dataobject.DomainObjectDO;
import org.springframework.stereotype.Component;

/**
 * 暂无dataSource，自定义mapper实现
 * @date 2022/12/23 18:13
 */
@Component
public class DomainObjectMapperImpl implements DomainObjectMapper{
    @Override
    public int update(DomainObjectDO domainObjectDO) {
        return 1;
    }

    @Override
    public DomainObjectDO select(String phoneNumber) {
        return new DomainObjectDO("DomainObjectMapper@email.${package}","176*****");
    }

    @Override
    public int save(DomainObjectDO domainObjectDO) {
        return 0;
    }
}
