package com.dangkang.examplecontext.infrastructure.repository;

import com.dangkang.examplecontext.infrastructure.repository.dataobject.DomainObjectDO;
import com.dangkang.examplecontext.infrastructure.repository.mapper.DomainObjectMapper;
import com.dangkang.examplecontext.app.service.dto.response.ExampleQueryResponseDTO;
import com.dangkang.examplecontext.domain.model.DomainObject;
import com.dangkang.examplecontext.domain.repository.ExampleAggregateRootRepository;
import com.dangkang.exception.DangKangAppException;
import com.dangkang.exception.DataBaseException;
import com.dangkang.exception.database.DataBaseErrorManager;
import com.dangkang.examplecontext.infrastructure.converter.ExampleConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExampleAggregateRepositoryImpl implements ExampleAggregateRootRepository {

    @Autowired
    private DomainObjectMapper domainObjectMapper;


    @Override
    public DomainObject findAndCheckEmpty(String phoneNumber) {

       DomainObjectDO domainObjectDO = domainObjectMapper.select(phoneNumber);
       if(domainObjectDO==null){
           throw new DangKangAppException().setErrorCode(ERR_DOMAINOBJECT_NOT_FOUND_CODE)
                                            .setPromptMessage(ERR_DOMAINOBJECT_NOT_FOUND_MESSAGE);
       }
       return ExampleConverter.INSTANCE.convert(domainObjectDO);
       
    }

    @Override
    public void save(DomainObject domainObject) {
    }

    @Override
    public void update(DomainObject domainObject) {

        DomainObjectDO domainObjectDO = ExampleConverter.INSTANCE.convert(domainObject);

        try {
            domainObjectMapper.update(domainObjectDO);
        } catch (Exception e) {
            throw new DataBaseException().setPromptMessage(DataBaseErrorManager.ERR_DATABASE_MESSAGE)
                                         .setCause(e);
        }
    }

    @Override
    public Map<String,Object> findPage(int index, int size, String email) {
        PageHelper.startPage(index,size);

        List<DomainObject> domainObjects = ExampleConverter.INSTANCE.convert(domainObjectMapper.findList(index,size,email));
        List<ExampleQueryResponseDTO> exampleQueryResponseDTOList = ExampleConverter.INSTANCE.convertQueryResultDataDtoList(domainObjects);

        PageInfo<ExampleQueryResponseDTO> pageInfo = new PageInfo<>(exampleQueryResponseDTOList);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("totalPages",pageInfo.getPages());
        pageMap.put("totalSize",pageInfo.getSize());
        pageMap.put("currentIndex",pageInfo.getPageNum());
        pageMap.put("pageSize",pageInfo.getPageSize());
        pageMap.put("dataList",pageInfo.getList());

        return pageMap ;
    }
}
