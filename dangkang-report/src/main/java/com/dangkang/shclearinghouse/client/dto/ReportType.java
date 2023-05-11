package com.dangkang.shclearinghouse.client.dto;

public enum ReportType {

    OPENED_ACCOUNT("openedAccount"),
    ACCOUNT_CHANGED("accountChanged"),
    BALANCE_CHANGED("balanceChanged");

    ReportType(String name){
        this.name=name;
    }
    private String name;

    public String getName(){
        return this.name;
    }

    public static boolean isRightReportName(String reportName){
        for(ReportType rt:ReportType.values()){
            if(rt.getName().equalsIgnoreCase(reportName)) return true;
        }
        return false;
    }
}
