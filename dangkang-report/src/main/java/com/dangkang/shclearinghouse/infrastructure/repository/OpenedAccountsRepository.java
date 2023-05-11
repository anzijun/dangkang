package com.dangkang.shclearinghouse.infrastructure.repository;


import com.dangkang.report.domain.model.Node;
import com.dangkang.report.domain.repository.ReportRepository;
import com.dangkang.shclearinghouse.infrastructure.config.ReportConfig;
import com.dangkang.shclearinghouse.infrastructure.converter.ReportConverter;
import com.dangkang.shclearinghouse.infrastructure.repository.dataobject.OpenedAccountDO;
import com.dangkang.shclearinghouse.infrastructure.repository.mapper.OpenedAccountMapper;
import com.dangkang.shclearinghouse.infrastructure.util.ReportFile;
import com.dangkang.report.domain.type.PageResponse;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/21 13:50
 * 描述 :         开户数据报表数据仓（实现）
 */
@Component
public class OpenedAccountsRepository implements ReportRepository {

    public static final String REPORT_FILE_NAME = "BankAccountOpen.txt" ; //清算所开户数据文件具体文件名 + 扩展名
    public static final String COMPRESSED_FILE_NAME = "BankAccountOpen.zip" ;

    public static final String MD5_FILE_FILE_NAME = "BankAccountOpen.md5" ;
    public static final String DB_DATE_FORMAT = "yyyy-MM-dd" ;
    public static final String SYSTEM_DATE_FORMAT = "yyyyMMdd" ;

    @Autowired
    ReportFile reportFile ;
    @Autowired
    ReportConfig reportConfig ;

    @Autowired
    OpenedAccountMapper openedAccountMapper ;

    public File getReportFile(Date date) {
        String path = reportFile.makePath(reportConfig.getRootPath(),getFilePathByDate(date));
        return new File(path, REPORT_FILE_NAME);
    }

    public File getCompressedFile(Date date) {
        String path = reportFile.makePath(reportConfig.getRootPath(),getFilePathByDate(date));
        return new File(path,COMPRESSED_FILE_NAME);
    }

    public File getDigestFile(Date date) {
        String path = reportFile.makePath(reportConfig.getRootPath(),getFilePathByDate(date));
        return new File(path ,MD5_FILE_FILE_NAME);
    }

    private String getFilePathByDate(Date date){
        return new SimpleDateFormat(reportConfig.getDateFormat()).format(date);
    }

    @Override
    public PageResponse<Node> pageFind(Date date, int index, int size) {
        PageHelper.startPage(index, size) ;
        List<OpenedAccountDO> openedAccountDOIbatis = openedAccountMapper.pageFind(new SimpleDateFormat(DB_DATE_FORMAT).format(date)) ;
        PageResponse<Node> page = this.pageOf(index, openedAccountDOIbatis.size(), ReportConverter.toNodeList(openedAccountDOIbatis)) ;
        return page ;
    }

    @Override
    public Integer getRecordTotalCount(Date date) {
        return openedAccountMapper.getRecordTotalCount(new SimpleDateFormat(DB_DATE_FORMAT).format(date)) ;
    }

    @Override
    public File toReportFile(PageResponse<Node> page, Date date) {
        File file=this.getReportFile(date);
        reportFile.save(page, file) ;
        return file;
    }

    public int batchSaveToDB(List<OpenedAccountDO> nodes) {
        return openedAccountMapper.insertCollectList(nodes) ;
    }
}
