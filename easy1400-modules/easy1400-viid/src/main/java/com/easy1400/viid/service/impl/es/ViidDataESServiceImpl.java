package com.easy1400.viid.service.impl.es;

import com.easy1400.viid.domain.ViidFace;
import com.easy1400.viid.domain.ViidMotorVehicle;
import com.easy1400.viid.domain.ViidNonMotorVehicle;
import com.easy1400.viid.domain.ViidPerson;
import com.easy1400.viid.domain.message.*;
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
    public void saveViidFaceData(ViidFace viidFace) {
    }

    @Override
    public void saveViidMotorVehicleData(ViidMotorVehicle viidMotorVehicle) {

    }

    @Override
    public void saveViidNonMotorVehicleData(ViidNonMotorVehicle viidNonMotorVehicle) {

    }

    @Override
    public void saveViidPersonData(ViidPerson viidPerson) {

    }

    @Override
    public void SubscribeNotifications(SubscribeNotificationsRequest subscribeNotificationsRequest) {

    }

    @Override
    public void SubscribeNotificationsSend(ViidFace viidFace, ViidPerson viidPerson, ViidMotorVehicle viidMotorVehicle, ViidNonMotorVehicle viidNonMotorVehicle) {

    }
}
