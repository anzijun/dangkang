#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.domain.repository;

import ${package}.examplecontext.domain.model.DomainObject;

import java.util.Map;

/**
 * 资源库（Repository）
 * 1.一个聚合一个Repository
 * @date 2022/12/23 10:23
 */
public interface ExampleAggregateRootRepository {

    String ERR_DOMAINOBJECT_NOT_FOUND_CODE="R001";
    String ERR_DOMAINOBJECT_NOT_FOUND_MESSAGE="未查询到领域对象";

    DomainObject findAndCheckEmpty(String phoneNumber);

    void save(DomainObject domainObject);

    void update(DomainObject domainObject);

    /**
     * 获取分页信息
     */
    Map<String,Object> findPage(int index, int size, String email);

}
