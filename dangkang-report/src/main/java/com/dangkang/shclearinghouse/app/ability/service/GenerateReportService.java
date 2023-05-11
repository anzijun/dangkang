package com.dangkang.shclearinghouse.app.ability.service;


import com.dangkang.report.domain.model.Node;
import com.dangkang.report.domain.repository.ReportRepository;
import com.dangkang.report.domain.type.PageResponse;
import com.dangkang.shclearinghouse.infrastructure.config.ReportConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;


@Component
public class GenerateReportService {
    private static final Logger LOG = LoggerFactory.getLogger(GenerateReportService.class);
    @Autowired
    ReportConfig reportConfig;



    public void execute(ReportRepository reportRepository, Date date) {
        Integer totalRecords = reportRepository.getRecordTotalCount(date);
        Integer pageCount = reportRepository.computePageCount(totalRecords, reportConfig.getPageSize());
        for (int i = 0; i < pageCount; ++i) {
            int pageIndex = i + 1;
            PageResponse<Node> page = reportRepository.pageFind(date, pageIndex, reportConfig.getPageSize());
          File reportFile= reportRepository.toReportFile(page,date );
            LOG.info("第{}页数据已被写入报表文件{}", pageIndex, reportFile.getAbsolutePath());
        }
    }
}
