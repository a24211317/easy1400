package com.easy1400.viid.service.impl.es;

import com.easy1400.viid.domain.message.FaceRequest;
import com.easy1400.viid.domain.message.MotorVehicleRequest;
import com.easy1400.viid.domain.message.NonMotorVehicleRequest;
import com.easy1400.viid.domain.message.PersonRequest;
import com.easy1400.viid.service.ViidDataService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @ClassName ViidDataESServiceImpl  TODO暂时不写ES数据存储逻辑
 * @Author CH
 * @Date 2023/9/5 10:38
 * @Version 1.0
 */
@Service
@ConditionalOnProperty(name = "device.data.saveway", havingValue = "ES")
public class ViidDataESServiceImpl implements ViidDataService {
    @Override
    public void saveViidFaceData(FaceRequest faceRequest) {
    }

    @Override
    public void saveViidMotorVehicleData(MotorVehicleRequest motorVehicleRequest) {

    }

    @Override
    public void saveViidNonMotorVehicleData(NonMotorVehicleRequest nonMotorVehicleRequest) {

    }

    @Override
    public void saveViidPersonData(PersonRequest personRequest) {

    }
}
