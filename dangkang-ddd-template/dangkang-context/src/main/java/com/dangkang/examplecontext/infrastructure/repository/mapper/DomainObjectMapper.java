package com.dangkang.examplecontext.infrastructure.repository.mapper;

import com.dangkang.examplecontext.infrastructure.repository.dataobject.DomainObjectDO;

import java.util.List;

/**
 * @date 2022/12/23 10:39
 */
public interface DomainObjectMapper {
    int update(DomainObjectDO domainObjectDO);

    DomainObjectDO select(String phoneNumber);

    int save(DomainObjectDO domainObjectDO);

    List<DomainObjectDO> findList(int index, int size, String email);
}
