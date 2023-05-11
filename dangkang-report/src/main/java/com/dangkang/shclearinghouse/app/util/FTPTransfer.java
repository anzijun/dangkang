package com.dangkang.shclearinghouse.app.util;


import com.dangkang.exception.DangKangAppException;
import com.dangkang.report.domain.exception.ReportException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;


@Component
public class FTPTransfer {
    private static final Logger LOG = LoggerFactory.getLogger(FTPTransfer.class);

    @Autowired
    private FTPConfig ftpConfig ;

    private org.apache.commons.net.ftp.FTPClient ftp ;


    public FTPTransfer(){
        ftp=new org.apache.commons.net.ftp.FTPClient();
        ftp.setControlEncoding("UTF-8");
    }

    public org.apache.commons.net.ftp.FTPClient connect(){
        return this.connect(ftpConfig.getFtpHost(),ftpConfig.getFtpPort(),ftpConfig.getFtpUserName(),ftpConfig.getFtpPassword());
    }

    public org.apache.commons.net.ftp.FTPClient connect(String host, int port, String user, String password) {
        // Connect to server.
        try {
            ftp.connect(host, port);
        } catch (IOException ex) {
            throw new DangKangAppException().setPromptMessage("找不到ftp服务器{}:{}r '" ,host,String.valueOf(port));
        }
        // Check rsponse after connection attempt.
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            disconnect();
         }

        if ("".equals(user)) {
            user = "anonymous";
        }
        // Login.
        try {
            if (!ftp.login(user, password)) {
                disconnect();
            }
        }catch (IOException e) {
                throw new DangKangAppException().setCause(e).setPromptMessage("登录服务器{}失败 " ,host );
        }

        try {
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException e) {
            throw new ReportException().setCause(e);
        }
        ftp.enterLocalPassiveMode();
        return ftp;
    }

    public boolean isConnected() {
        return ftp.isConnected();
    }

    public void disconnect()  {
        if (ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException ex) {
                LOG.warn("退出服务器发生异常",ex);
            }
        }
    }
    public void upload(File localFile){
        this.upload(localFile.getName(),localFile);
    }

    public void upload(String ftpFileName, File localFile)  {
        // File check.
        if (!localFile.exists()) {
            throw new DangKangAppException().setPromptMessage("传输文件{}不存在 '" , localFile.getAbsolutePath() );
        }
        // Upload.
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(localFile));
            if (!ftp.storeFile(ftpFileName, in)) {
                throw new DangKangAppException().setPromptMessage("不能传输文件{}到FTP服务器，检查ftp权限或和径设置是否正确 ",  localFile.getAbsolutePath() );
            }
        } catch (IOException e) {
            throw new DangKangAppException().setCause(e).setPromptMessage("传输文件{}到FTP服务器失败",  localFile.getAbsolutePath() );
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
            }
        }
    }

    public void transfer(File file){
        try{
            if(!this.isConnected()){
                this.connect();
            }
            this.upload(file);
        }finally {
            this.disconnect();
        }
    }
}
