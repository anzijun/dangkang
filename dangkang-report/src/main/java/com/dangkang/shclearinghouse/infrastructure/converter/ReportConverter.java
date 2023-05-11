package com.dangkang.shclearinghouse.infrastructure.converter;


import com.dangkang.report.domain.model.Node;
import com.dangkang.shclearinghouse.domain.model.openedaccounts.node.OpenedAccountNode;
import com.dangkang.shclearinghouse.infrastructure.repository.dataobject.OpenedAccountDO;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface ReportConverter {
    ReportConverter INSTANCE= Mappers.getMapper(ReportConverter.class);

    @Mapping(source="fullName" ,target="investorFullName")
    public OpenedAccountNode toNode(OpenedAccountDO openedAccountDO );

    public static List<Node> toNodeList(List<OpenedAccountDO> openedAccountDOList) {
        List<Node> nodeList = new ArrayList<>() ;
        for(OpenedAccountDO openedAccountDO:openedAccountDOList) {
            nodeList.add(ReportConverter.INSTANCE.toNode(openedAccountDO));
        }
        return nodeList ;
    }

}
