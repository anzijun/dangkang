package com.dangkang.report.domain.model;

/**

 */
public abstract class ReportNode implements Node {

    /* 承办行需要用以下方式对报表文件终的每一行数据进行换行（分割） */
    public static final String NEW_LINE = "\r\n" ;

    public String newLine() {return NEW_LINE; }

    @Override
    public String format() {
        return "";
    }
}
