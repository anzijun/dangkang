package com.dangkang.shclearinghouse.app.util;


import com.dangkang.exception.DangKangAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
public class ZIPCompress {

    private static final Logger LOG = LoggerFactory.getLogger(ZIPCompress.class);

    public void execute(File sourceFile, File zippedFile) {
        try (FileOutputStream fos = new FileOutputStream(zippedFile);ZipOutputStream zos = new ZipOutputStream(fos)){
            zos.putNextEntry(new ZipEntry(sourceFile.getName()));
            byte []  buf=new byte[2048];
            FileInputStream ios=new FileInputStream(sourceFile);
            int len=-1;
            while((len= ios.read(buf))!=-1){
                zos.write(buf, 0, len);
            }
            zos.closeEntry();
            LOG.info("报表文件{}压缩成zip文件{}",sourceFile.getAbsolutePath(),zippedFile.getAbsolutePath());
        } catch (FileNotFoundException ex) {
            throw new DangKangAppException().setPromptMessage("需压缩的文件 {} 不存在",sourceFile.getAbsolutePath());
        } catch (IOException ex) {
            throw new DangKangAppException().setCause(ex).setPromptMessage("压缩的文件 {} 失败",sourceFile.getAbsolutePath());
        }
    }
}
