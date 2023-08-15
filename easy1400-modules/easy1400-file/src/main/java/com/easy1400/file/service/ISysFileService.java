package com.easy1400.file.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传接口
 * 
 * @author easy1400
 */
public interface ISysFileService
{
    /**
     * 文件上传接口
     * 
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    public String uploadFile(MultipartFile file) throws Exception;
}
