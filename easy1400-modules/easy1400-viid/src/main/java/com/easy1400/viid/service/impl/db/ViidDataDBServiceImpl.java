package com.easy1400.viid.service.impl.db;

import com.easy1400.common.core.domain.R;
import com.easy1400.system.api.RemoteFileService;
import com.easy1400.system.api.domain.SysFile;
import com.easy1400.viid.common.util.MultipartFileUtil;
import com.easy1400.viid.domain.dto.SubImageListDTO;
import com.easy1400.viid.domain.message.FaceRequest;
import com.easy1400.viid.service.ViidDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @ClassName ViidDataDBServiceImpl
 * @Author CH
 * @Date 2023/9/5 10:38
 * @Version 1.0
 */
@Service
@ConditionalOnProperty(name = "device.data.saveway", havingValue = "DATABASE")
public class ViidDataDBServiceImpl implements ViidDataService {
private static final Logger log= LoggerFactory.getLogger(ViidDataDBServiceImpl.class);
    @Value("${device.data.base64StoreOrNot}")
    private boolean base64StoreOrNot;
    @Resource
    private RemoteFileService remoteFileService;

    @Override
    public void saveViidFaceData(FaceRequest faceRequest) {
        for (FaceRequest.FaceListObjectDTO.FaceObjectDTO faceObjectDTO : faceRequest.getFaceListObject().getFaceObject()) {
            //图片存入服务
            for (SubImageListDTO.SubImageInfoObjectDTO subImageInfoObjectDTO : faceObjectDTO.getSubImageList().getSubImageInfoObject()) {
                try {
                    R<SysFile> saveFileResult =
                    remoteFileService.upload(MultipartFileUtil.base64ConvertToMultipartFile(subImageInfoObjectDTO.getData(),subImageInfoObjectDTO.getImageID()));
                    if (saveFileResult.getCode()==200){
                        subImageInfoObjectDTO.setStoragePath(saveFileResult.getData().getUrl());
                        //原始base64是否入库
                        if (!base64StoreOrNot) {
                            subImageInfoObjectDTO.setData("");
                        }
                    }
                } catch (IOException e) {
                    log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
                }
            }
            //存入数据库

        }
        System.out.println();
    }
}
