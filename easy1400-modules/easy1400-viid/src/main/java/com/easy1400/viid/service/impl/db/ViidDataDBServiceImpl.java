package com.easy1400.viid.service.impl.db;

import cn.hutool.core.date.DateUtil;
import com.easy1400.common.core.domain.R;
import com.easy1400.system.api.RemoteFileService;
import com.easy1400.system.api.domain.SysFile;
import com.easy1400.viid.common.util.MultipartFileUtil;
import com.easy1400.viid.domain.ViidFace;
import com.easy1400.viid.domain.ViidMotorVehicle;
import com.easy1400.viid.domain.ViidNonMotorVehicle;
import com.easy1400.viid.domain.ViidPerson;
import com.easy1400.viid.domain.dto.SubImageListDTO;
import com.easy1400.viid.domain.message.FaceRequest;
import com.easy1400.viid.domain.message.MotorVehicleRequest;
import com.easy1400.viid.domain.message.NonMotorVehicleRequest;
import com.easy1400.viid.domain.message.PersonRequest;
import com.easy1400.viid.mapper.ViidFaceMapper;
import com.easy1400.viid.mapper.ViidMotorVehicleMapper;
import com.easy1400.viid.mapper.ViidNonMotorVehicleMapper;
import com.easy1400.viid.mapper.ViidPersonMapper;
import com.easy1400.viid.service.ViidDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
    public void saveViidFaceData(FaceRequest faceRequest) {
        for (ViidFace faceObjectDTO : faceRequest.getFaceListObject().getFaceObject()) {
            //图片存入服务
            try {
                this.saveSubImage(faceObjectDTO.getSubImageList().getSubImageInfoObject());
            } catch (IOException e) {
                log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
            }
            //存入数据库
            viidFaceMapper.insert(faceObjectDTO);
        }
    }

    @Async
    @Override
    public void saveViidMotorVehicleData(MotorVehicleRequest motorVehicleRequest) {
        for (ViidMotorVehicle motorVehicle : motorVehicleRequest.getMotorVehicleListObject().getMotorVehicleObject()) {
            //图片存入服务
            try {
                this.saveSubImage(motorVehicle.getSubImageList().getSubImageInfoObject());
            } catch (IOException e) {
                log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
            }
            //存入数据库
            viidMotorVehicleMapper.insert(motorVehicle);
        }
    }
    @Async
    @Override
    public void saveViidNonMotorVehicleData(NonMotorVehicleRequest nonMotorVehicleRequest) {
        for (ViidNonMotorVehicle nonMotorVehicle : nonMotorVehicleRequest.getNonMotorVehicleListObject().getNonMotorVehicleObject()) {
            //图片存入服务
            try {
                this.saveSubImage(nonMotorVehicle.getSubImageList().getSubImageInfoObject());
            } catch (IOException e) {
                log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
            }
            //存入数据库
            viidNonMotorVehicleMapper.insert(nonMotorVehicle);
        }
    }
    @Async
    @Override
    public void saveViidPersonData(PersonRequest personRequest) {
        for (ViidPerson person : personRequest.getPersonListObject().getPersonObject()) {
            //图片存入服务
            try {
                this.saveSubImage(person.getSubImageList().getSubImageInfoObject());
            } catch (IOException e) {
                log.error(String.format("[ %s ]图片存入失败: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
            }
            //存入数据库
            viidPersonMapper.insert(person);
        }
    }

    private void saveSubImage(List<SubImageListDTO.SubImageInfoObjectDTO> subImageList) throws IOException {
        for (SubImageListDTO.SubImageInfoObjectDTO subImageInfoObjectDTO : subImageList) {
            R<SysFile> saveFileResult =
                    remoteFileService.upload(MultipartFileUtil.base64ConvertToMultipartFile(subImageInfoObjectDTO.getData(), subImageInfoObjectDTO.getImageID()));
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
