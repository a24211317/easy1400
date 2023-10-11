package com.easy1400.viid.service;

import com.easy1400.viid.domain.ViidFace;
import com.easy1400.viid.domain.ViidMotorVehicle;
import com.easy1400.viid.domain.ViidNonMotorVehicle;
import com.easy1400.viid.domain.ViidPerson;
import com.easy1400.viid.domain.message.*;

/**
 * @ClassName ViidDataService
 * @Author CH
 * @Date 2023/9/5 10:36
 * @Version 1.0
 */
public interface ViidDataService {

    void saveViidFaceData(ViidFace viidFace);

    void saveViidMotorVehicleData(ViidMotorVehicle motorVehicleRequest);

    void saveViidNonMotorVehicleData(ViidNonMotorVehicle nonMotorVehicleRequest);

    void saveViidPersonData(ViidPerson personRequest);

    void SubscribeNotifications( SubscribeNotificationsRequest subscribeNotificationsRequest);

}
