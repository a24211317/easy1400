package com.easy1400.viid.service;

import com.easy1400.viid.domain.message.FaceRequest;
import com.easy1400.viid.domain.message.MotorVehicleRequest;
import com.easy1400.viid.domain.message.NonMotorVehicleRequest;
import com.easy1400.viid.domain.message.PersonRequest;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @ClassName ViidDataService
 * @Author CH
 * @Date 2023/9/5 10:36
 * @Version 1.0
 */
public interface ViidDataService {

    void saveViidFaceData(FaceRequest faceRequest);

    void saveViidMotorVehicleData(MotorVehicleRequest motorVehicleRequest);

    void saveViidNonMotorVehicleData(NonMotorVehicleRequest nonMotorVehicleRequest);

    void saveViidPersonData(PersonRequest personRequest);

}
