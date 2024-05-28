package com.easy1400.viid.service.impl.db;

import com.easy1400.common.core.domain.R;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.system.api.RemoteFileService;
import com.easy1400.system.api.domain.SysFile;
import com.easy1400.viid.common.util.MultipartFileUtil;
import com.easy1400.viid.domain.ViidFace;
import com.easy1400.viid.domain.ViidMotorVehicle;
import com.easy1400.viid.domain.ViidNonMotorVehicle;
import com.easy1400.viid.domain.ViidPerson;
import com.easy1400.viid.domain.dto.SubImageListDTO;
import com.easy1400.viid.domain.message.SubscribeNotificationsRequest;
import com.easy1400.viid.mapper.ViidFaceMapper;
import com.easy1400.viid.mapper.ViidMotorVehicleMapper;
import com.easy1400.viid.mapper.ViidNonMotorVehicleMapper;
import com.easy1400.viid.mapper.ViidPersonMapper;
import com.easy1400.viid.service.ViidDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ViidDataDBServiceImpl
 * @Author CH
 * @Date 2023/9/5 10:38
 * @Version 1.0
 */
@Service
@ConditionalOnProperty(name = "device.data.saveway", havingValue = "DATABASE")
public class ViidDataDBServiceImpl implements ViidDataService {
    private static final Logger log = LoggerFactory.getLogger(ViidDataDBServiceImpl.class);
    @Value("${device.data.base64StoreOrNot}")
    private boolean base64StoreOrNot;
    @Resource
    private RemoteFileService remoteFileService;
    @Resource
    private ViidFaceMapper viidFaceMapper;
    @Resource
    private ViidMotorVehicleMapper viidMotorVehicleMapper;
    @Resource
    private ViidNonMotorVehicleMapper viidNonMotorVehicleMapper;
    @Resource
    private ViidPersonMapper viidPersonMapper;

    @Async
    @Override
    public void saveViidFaceData(ViidFace viidFace) {
        //图片存入服务
        try {
            this.saveSubImage(viidFace.getSubImageList().getSubImageInfoObject());
        } catch (IOException e) {
            log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
        }
        if (StringUtils.isEmpty(viidFace.getFaceAppearTime())) {
            viidFace.setFaceAppearTime(viidFace.getSubImageList().getSubImageInfoObject().get(0).getShotTime());
        }
        //存入数据库
        viidFaceMapper.insert(viidFace);

    }

    @Async
    @Override
    public void saveViidMotorVehicleData(ViidMotorVehicle viidMotorVehicle) {
        //图片存入服务
        try {
            this.saveSubImage(viidMotorVehicle.getSubImageList().getSubImageInfoObject());
        } catch (IOException e) {
            log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
        }
        if (StringUtils.isEmpty(viidMotorVehicle.getAppearTime())) {
            viidMotorVehicle.setAppearTime(viidMotorVehicle.getSubImageList().getSubImageInfoObject().get(0).getShotTime());
        }
        //存入数据库
        viidMotorVehicleMapper.insert(viidMotorVehicle);
    }

    @Async
    @Override
    public void saveViidNonMotorVehicleData(ViidNonMotorVehicle viidNonMotorVehicle) {
        //图片存入服务
        try {
            this.saveSubImage(viidNonMotorVehicle.getSubImageList().getSubImageInfoObject());
        } catch (IOException e) {
            log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
        }
        if (StringUtils.isEmpty(viidNonMotorVehicle.getAppearTime())) {
            viidNonMotorVehicle.setAppearTime(viidNonMotorVehicle.getSubImageList().getSubImageInfoObject().get(0).getShotTime());
        }
        //存入数据库
        viidNonMotorVehicleMapper.insert(viidNonMotorVehicle);

    }

    @Async
    @Override
    public void saveViidPersonData(ViidPerson viidPerson) {
        //图片存入服务
        try {
            this.saveSubImage(viidPerson.getSubImageList().getSubImageInfoObject());
        } catch (IOException e) {
            log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
        }
        if (StringUtils.isEmpty(viidPerson.getPersonAppearTime())) {
            viidPerson.setPersonAppearTime(viidPerson.getSubImageList().getSubImageInfoObject().get(0).getShotTime());
        }
        //存入数据库
        viidPersonMapper.insert(viidPerson);
    }

    @Override
    public void SubscribeNotifications(SubscribeNotificationsRequest subscribeNotificationsRequest) {
        for (SubscribeNotificationsRequest.SubscribeNotificationListObjectDTO.SubscribeNotificationObjectDTO subscribeNotificationObjectDTO : subscribeNotificationsRequest.getSubscribeNotificationListObject().getSubscribeNotificationObject()) {
            if (subscribeNotificationObjectDTO.getFaceObjectList() != null) {
                for (ViidFace viidFace : subscribeNotificationObjectDTO.getFaceObjectList().getFaceObject()) {
                    this.saveViidFaceData(viidFace);
                }
            }
            if (subscribeNotificationObjectDTO.getPersonObjectList() != null) {
                for (ViidPerson viidPerson : subscribeNotificationObjectDTO.getPersonObjectList().getPersonObject()) {
                    this.saveViidPersonData(viidPerson);
                }
            }
            if (subscribeNotificationObjectDTO.getMotorVehicleObjectList() != null) {
                for (ViidMotorVehicle motorVehicle : subscribeNotificationObjectDTO.getMotorVehicleObjectList().getMotorVehicleObject()) {
                    this.saveViidMotorVehicleData(motorVehicle);
                }
            }
            if (subscribeNotificationObjectDTO.getNonMotorVehicleObjectList() != null) {
                for (ViidNonMotorVehicle nonMotorVehicle : subscribeNotificationObjectDTO.getNonMotorVehicleObjectList().getNonMotorVehicleObject()) {
                    this.saveViidNonMotorVehicleData(nonMotorVehicle);
                }
            }
        }
    }

    @Async
    protected void saveSubImage(List<SubImageListDTO.SubImageInfoObjectDTO> subImageList) throws IOException {
        for (SubImageListDTO.SubImageInfoObjectDTO subImageInfoObjectDTO : subImageList) {
            if (StringUtils.isNotEmpty(subImageInfoObjectDTO.getData())) {
                R<SysFile> saveFileResult = remoteFileService.upload(MultipartFileUtil.base64ConvertToMultipartFile(subImageInfoObjectDTO.getData(), subImageInfoObjectDTO.getImageID()));
                if (saveFileResult.getCode() == 200) {
                    subImageInfoObjectDTO.setStoragePath(saveFileResult.getData().getUrl());
                }
                //原始base64是否入库
                if (!base64StoreOrNot) {
                    subImageInfoObjectDTO.setData("");
                }
            }
        }
    }

}
