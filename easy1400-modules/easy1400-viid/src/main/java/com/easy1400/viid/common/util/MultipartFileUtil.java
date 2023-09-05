package com.easy1400.viid.common.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @ClassName MultipartFileUtil
 * @Author CH
 * @Date 2023/9/5 10:56
 * @Version 1.0
 */
public class MultipartFileUtil {

    public static MultipartFile base64ConvertToMultipartFile(String base64String,String fileName) throws IOException {
        // 将Base64字符串解码为字节数组
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);

        // 创建一个FileItem
        FileItem fileItem = new DiskFileItem("file", "image/jpeg", false, fileName+".jpg", decodedBytes.length, null);
        fileItem.getOutputStream().write(decodedBytes);

        // 创建一个MultipartFile对象
        return new CommonsMultipartFile(fileItem);
    }

}
