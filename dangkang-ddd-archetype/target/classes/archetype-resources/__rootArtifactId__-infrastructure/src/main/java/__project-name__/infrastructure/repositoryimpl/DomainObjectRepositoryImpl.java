#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.infrastructure.repositoryimpl;

import ${package}.${project-name}.domain.exception.ApplicationException;
import ${package}.${project-name}.domain.exception.DataBaseException;
import ${package}.${project-name}.domain.exception.database.DataBaseErrorManager;
import ${package}.${project-name}.domain.model.trade.DomainObject;
import ${package}.${project-name}.domain.model.trade.repository.DomainObjectRepository;
import ${package}.${project-name}.infrastructure.converter.DomainObjectConverter;
import ${package}.${project-name}.infrastructure.repositoryimpl.dataobject.DomainObjectDO;
import ${package}.${project-name}.infrastructure.repositoryimpl.mapper.DomainObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomainObjectRepositoryImpl implements DomainObjectRepository {

    @Autowired
    private DomainObjectMapper domainObjectMapper;


    @Override
    public DomainObject findAndCheckEmpty(String phoneNumber) {

       DomainObjectDO domainObjectDO = domainObjectMapper.select(phoneNumber);
       if(domainObjectDO==null){
           throw new ApplicationException().setErrorCode(ERR_DOMAINOBJECT_NOT_FOUND_CODE)
                                            .setPromptMessage(ERR_DOMAINOBJECT_NOT_FOUND_MESSAGE);
       }
       return DomainObjectConverter.INSTANCE.toDomainObject(domainObjectDO);
       
    }

    @Override
    public void save(DomainObject domainObject) {
    }

    @Override
    public void update(DomainObject domainObject) {

        DomainObjectDO domainObjectDO = DomainObjectConverter.INSTANCE.toDomainObjectDO(domainObject);

        try {
            domainObjectMapper.update(domainObjectDO);
        } catch (Exception e) {
            throw new DataBaseException().setPromptMessage(DataBaseErrorManager.ERR_DATABASE_MESSAGE)
                                         .setCause(e);
        }
    }
}
