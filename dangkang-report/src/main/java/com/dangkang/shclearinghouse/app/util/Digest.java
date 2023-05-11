package com.dangkang.shclearinghouse.app.util;


import com.dangkang.exception.DangKangAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;

@Component
public class Digest {
    private static final Logger LOG = LoggerFactory.getLogger(Digest.class);

    public String execute(File sourceFile,File md5File) {
        String md5Str ="";
        try (FileInputStream fis = new FileInputStream(sourceFile); FileWriter md5Writer=new FileWriter(md5File)){
            MessageDigest md = MessageDigest.getInstance("MD5");
            int len = 0;
            byte[] buffer = new byte[8192];
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            byte[] b = md.digest();
            md5Str = new BigInteger(1, b).toString(16);
            md5Writer.write(md5Str);
            LOG.info("报表文件{}成功生成MD5：{}",sourceFile.getAbsolutePath(),md5Str);
        } catch (Exception e) {
            throw new DangKangAppException().setCause(e).setPromptMessage("报表文件{}成功生成MD5失败",sourceFile.getAbsolutePath());
        }
        return md5Str;
    }
}
