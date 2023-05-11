package com.dangkang.shclearinghouse.app.service;


import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.dangkang.application.annotation.ServiceDesc;
import com.dangkang.application.dto.response.Response;
import com.dangkang.exception.annotation.ExceptionAndValid;
import com.dangkang.report.domain.repository.ReportRepository;
import com.dangkang.report.util.Digest;
import com.dangkang.report.util.FTPTransfer;
import com.dangkang.report.util.ZIPCompress;
import com.dangkang.shclearinghouse.app.ability.service.GenerateReportService;
import com.dangkang.shclearinghouse.client.ReportService;
import com.dangkang.shclearinghouse.client.dto.ReportRequest;
import com.dangkang.shclearinghouse.client.dto.ReportType;
import com.dangkang.shclearinghouse.infrastructure.repository.OpenedAccountsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
public class ReportAppService implements ReportService {

    private static final Logger log= LoggerFactory.getLogger(ReportAppService.class);

    private final Map<String, ReportRepository> reportRepositoryMap=new HashMap<>();
    {
        reportRepositoryMap.put(ReportType.OPENED_ACCOUNT.getName(), this.openedAccountsRepository);
    }

    @Autowired
    OpenedAccountsRepository openedAccountsRepository;
    @Autowired
    GenerateReportService generateReportService;
    @Autowired
    ZIPCompress zipCompress;
    @Autowired
    Digest digest;

    @Autowired
    FTPTransfer ftpTransfer;

    @Override
    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "0005",ServiceName = "执行单个报表")
    public Response<String> doAll( @FluentValid ReportRequest reportRequest) {
        ReportRepository reportRepository=reportRepositoryMap.get(reportRequest.getReportName());
        generateReportService.execute(reportRepository,reportRequest.toReportDate());
        log.info("生成报表成功【{}】",reportRequest.getReportName());
        zipCompress.execute(reportRepository.getReportFile(reportRequest.toReportDate()),reportRepository.getCompressedFile(reportRequest.toReportDate()));
        log.info("压缩报表文件成功【{}】",reportRepository.getCompressedFile(reportRequest.toReportDate()).getName());
        digest.execute(reportRepository.getReportFile(reportRequest.toReportDate()),reportRepository.getDigestFile(reportRequest.toReportDate()));
        log.info("报表生成摘要文件成功【{}】",reportRepository.getDigestFile(reportRequest.toReportDate()).getName());
        ftpTransfer.transfer(reportRepository.getCompressedFile(reportRequest.toReportDate()));
        log.info("报表文件传输成功【{}】",reportRepository.getCompressedFile(reportRequest.toReportDate()).getName());
        Response<String> response=new Response();
        response.setData(reportRepository.getReportFile(reportRequest.toReportDate()).getName());
        response.buildSuccess(this.getMethod("doAll"));
        return response;
    }


    @Override
    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "0001",ServiceName = "生成报表")
    public Response<String> generateReport(@FluentValid ReportRequest reportRequest) {
           ReportRepository reportRepository=reportRepositoryMap.get(reportRequest.getReportName());
            generateReportService.execute(reportRepository,reportRequest.toReportDate());
            Response<String> response=new Response();
            response.setData(reportRepository.getReportFile(reportRequest.toReportDate()).getName());
            response.buildSuccess(this.getMethod("generateReport"));
            return response;
    }

    private Optional<Method> getMethod(String methodName){
        try {
            return Optional.of(ReportAppService.class.getMethod(methodName,ReportRequest.class));
        } catch (NoSuchMethodException e) {
            //throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "0002",ServiceName = "压缩报表")
    public Response<String> compress(@FluentValid ReportRequest reportRequest) {
        ReportRepository reportRepository=reportRepositoryMap.get(reportRequest.getReportName());
        zipCompress.execute(reportRepository.getReportFile(reportRequest.toReportDate()),reportRepository.getCompressedFile(reportRequest.toReportDate()));
        Response<String> response=new Response();
        response.setData(reportRepository.getCompressedFile(reportRequest.toReportDate()).getName());
        response.buildSuccess(this.getMethod("compress"));
        return response;
    }

    @Override
    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "0003",ServiceName = "生成摘要")
    public Response<String> digest(@FluentValid ReportRequest reportRequest) {
        ReportRepository reportRepository=reportRepositoryMap.get(reportRequest.getReportName());
        digest.execute(reportRepository.getReportFile(reportRequest.toReportDate()),reportRepository.getDigestFile(reportRequest.toReportDate()));
        Response<String> response=new Response();
        response.setData(reportRepository.getDigestFile(reportRequest.toReportDate()).getName());
        response.buildSuccess(this.getMethod("digest"));
        return response;
    }

    @Override
    @ExceptionAndValid
    @ServiceDesc(ServiceCode = "0004",ServiceName = "传输报表")
    public Response<String> transfer(@FluentValid  ReportRequest reportRequest) {
        ReportRepository reportRepository=reportRepositoryMap.get(reportRequest.getReportName());
        ftpTransfer.transfer(reportRepository.getCompressedFile(reportRequest.toReportDate()));
        Response<String> response=new Response();
        response.setData(reportRepository.getCompressedFile(reportRequest.toReportDate()).getName());
        response.buildSuccess(this.getMethod("transfer"));
        return response;
    }

}
