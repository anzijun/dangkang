package com.dangkang.report.domain.repository;



import com.dangkang.report.domain.type.PageResponse;
import com.dangkang.report.domain.model.Node;


import java.io.File;
import java.util.Date;
import java.util.List;


/**
 */
public interface ReportRepository {

    public File getReportFile(Date date);

    public File getCompressedFile(Date date);

    public File getDigestFile(Date date);


    public PageResponse<Node> pageFind(Date date, int index, int size) ;

    public Integer getRecordTotalCount(Date date) ;

    public File toReportFile(PageResponse<Node> page, Date date) ;


    public default int computePageCount (Integer totalCount, Integer pageSize) {
         return totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
    }

    public default PageResponse<Node> pageOf(int pageIndex, long totalRecordCount, List<Node> nodes) {
        return  new PageResponse<Node>().
                setTotalCount(totalRecordCount).
                setPageIndex(pageIndex).
                setData(nodes);
    }
}
