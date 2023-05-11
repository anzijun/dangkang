package com.dangkang.shclearinghouse.client;

import com.dangkang.application.dto.response.Response;
import com.dangkang.shclearinghouse.client.dto.ReportRequest;

public interface ReportService {




    public Response<String>doAll(ReportRequest reportRequest);
    public Response<String> generateReport(ReportRequest reportRequest);
    public Response<String> compress(ReportRequest reportRequest);
    public Response<String> digest(ReportRequest reportRequest);
    public Response<String> transfer(ReportRequest reportRequest);

}
