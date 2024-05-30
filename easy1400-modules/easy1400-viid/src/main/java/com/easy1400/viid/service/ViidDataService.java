package com.easy1400.viid.service;

import com.easy1400.viid.domain.*;
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

    void saveViidApesData(ViidApe viidApe);

    void saveViidPersonData(ViidPerson personRequest);

    void SubscribeNotifications(SubscribeNotificationsRequest subscribeNotificationsRequest);

    void SubscribeNotificationsSend(ViidFace viidFace, ViidPerson viidPerson, ViidMotorVehicle viidMotorVehicle, ViidNonMotorVehicle viidNonMotorVehicle);

}
