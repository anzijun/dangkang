package com.dangkang.shclearinghouse.infrastructure.util;


import com.dangkang.report.domain.model.Node;
import com.dangkang.report.domain.exception.ReportException;
import com.dangkang.shclearinghouse.infrastructure.config.ReportConfig;
import com.dangkang.report.domain.type.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/21 13:52
 * 描述 :         报表文件的操作因是IO操作，故在基础设施层准备了进行IO输出（相当于数据库写）操作的数据仓
 */
@Component
public class ReportFile {

    @Autowired
    ReportConfig reportConfig ;

    public void save(PageResponse<Node> page, File reportFile) {
        List<Node> nodeList=page.getData();

        if(nodeList == null || nodeList.size() == 0) return ;
        try (
                BufferedWriter reportWriter =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream(reportFile, true), reportConfig.getCharset()
                                )
                        )
        ){
            StringBuffer buffer=new StringBuffer();
            for(Node node:nodeList){
                buffer.append(node);
            }
            reportWriter.write(buffer.toString()) ;
            reportWriter.flush() ;
        } catch (UnsupportedEncodingException e) {
            throw new ReportException().setPromptMessage("当前用的字符集是: %s", reportConfig.getCharset()).setCause(e) ;
        } catch (FileNotFoundException e) {
            throw new ReportException().setPromptMessage("当前文件为: %s", reportFile.getAbsolutePath()).setCause(e) ;
        } catch (IOException e) {
            throw new ReportException().setPromptMessage("").setCause(e) ;
        }
    }

    public String makePath(String rootPath,String subDirectory){
        File directory=new File(rootPath,subDirectory);
        if(!directory.exists() && directory.isDirectory()){
                directory.mkdirs();
        }
        return directory.getAbsolutePath();
    }
}
