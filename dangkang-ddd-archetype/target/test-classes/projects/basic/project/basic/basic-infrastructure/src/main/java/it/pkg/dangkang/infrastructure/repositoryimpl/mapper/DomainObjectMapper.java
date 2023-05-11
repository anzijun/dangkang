package it.pkg.dangkang.infrastructure.repositoryimpl.mapper;

import it.pkg.dangkang.infrastructure.repositoryimpl.dataobject.DomainObjectDO;

/**
 * @date 2022/12/23 10:39
 */
public interface DomainObjectMapper {
    int update(DomainObjectDO domainObjectDO);

    DomainObjectDO select(String phoneNumber);

    int save(DomainObjectDO domainObjectDO);
}
