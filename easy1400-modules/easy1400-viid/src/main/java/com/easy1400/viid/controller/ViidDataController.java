package com.easy1400.viid.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.common.core.web.domain.AjaxResult;
import com.easy1400.viid.domain.*;
import com.easy1400.viid.domain.enums.ResponsStatusEnum;
import com.easy1400.viid.domain.message.*;
import com.easy1400.viid.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ViidDataController
 * @Author CH   TODO 实现逻辑暂时没写
 * @Date 2023/8/25 09:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/VIID")
public class ViidDataController {

    @Autowired
    private ViidDataService viidDataService;
    @Autowired
    private ViidMotorVehicleService viidMotorVehicleService;
    @Autowired
    private ViidFaceService viidFaceService;
    @Autowired
    private ViidPersonService viidPersonService;
    @Autowired
    private ViidNonMotorVehicleService viidNonMotorVehicleService;
    @Autowired
    private ViidApeService viidApeService;


    @GetMapping("/MotorVehicles/{page}/{rows}")
    public AjaxResult getMotorVehicles(@PathVariable(value = "page") Integer page, @PathVariable(value = "rows") Integer rows,
                                       @RequestParam(value = "beginTime") String beginTime, @RequestParam(value = "endTime") String endTime,
                                       @RequestParam(value = "deviceId", required = false) String deviceId, @RequestParam(value = "motorVehicleID", required = false) String motorVehicleID) {
        if (StringUtils.isNotEmpty(motorVehicleID)) {
            return AjaxResult.success(viidMotorVehicleService.getById(motorVehicleID));
        }
        LambdaQueryWrapper<ViidMotorVehicle>
                queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(StringUtils.isNotEmpty(beginTime), ViidMotorVehicle::getPassTime,
                DateUtil.format(DateUtil.parse(beginTime), DatePattern.PURE_DATETIME_FORMAT), DateUtil.format(DateUtil.parse(endTime), DatePattern.PURE_DATETIME_FORMAT));
        queryWrapper.eq(StringUtils.isNotEmpty(deviceId), ViidMotorVehicle::getDeviceID, deviceId);
        queryWrapper.orderByDesc(ViidMotorVehicle::getPassTime);
        return AjaxResult.success(viidMotorVehicleService.page(new Page<>(page, rows), queryWrapper));
    }

    @GetMapping("/faces/{page}/{rows}")
    public AjaxResult getFaces(@PathVariable(value = "page") Integer page, @PathVariable(value = "rows") Integer rows,
                               @RequestParam(value = "beginTime") String beginTime, @RequestParam(value = "endTime") String endTime,
                               @RequestParam(value = "deviceId", required = false) String deviceId, @RequestParam(value = "faceID", required = false) String faceID) {
        if (StringUtils.isNotEmpty(faceID)) {
            return AjaxResult.success(viidFaceService.getById(faceID));
        }
        LambdaQueryWrapper<ViidFace>
                queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(StringUtils.isNotEmpty(beginTime), ViidFace::getFaceAppearTime,
                DateUtil.format(DateUtil.parse(beginTime), DatePattern.PURE_DATETIME_FORMAT), DateUtil.format(DateUtil.parse(endTime), DatePattern.PURE_DATETIME_FORMAT));
        queryWrapper.eq(StringUtils.isNotEmpty(deviceId), ViidFace::getDeviceID, deviceId);
        queryWrapper.orderByDesc(ViidFace::getFaceAppearTime);
        return AjaxResult.success(viidFaceService.page(new Page<>(page, rows), queryWrapper));
    }

    @GetMapping("/persons/{page}/{rows}")
    public AjaxResult getPersons(@PathVariable(value = "page") Integer page, @PathVariable(value = "rows") Integer rows,
                                 @RequestParam(value = "beginTime") String beginTime, @RequestParam(value = "endTime") String endTime,
                                 @RequestParam(value = "deviceId", required = false) String deviceId, @RequestParam(value = "personID", required = false) String personID) {
        if (StringUtils.isNotEmpty(personID)) {
            return AjaxResult.success(viidPersonService.getById(personID));
        }
        LambdaQueryWrapper<ViidPerson>
                queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(StringUtils.isNotEmpty(beginTime), ViidPerson::getPersonAppearTime,
                DateUtil.format(DateUtil.parse(beginTime), DatePattern.PURE_DATETIME_FORMAT), DateUtil.format(DateUtil.parse(endTime), DatePattern.PURE_DATETIME_FORMAT));
        queryWrapper.eq(StringUtils.isNotEmpty(deviceId), ViidPerson::getDeviceID, deviceId);
        queryWrapper.orderByDesc(ViidPerson::getPersonAppearTime);
        return AjaxResult.success(viidPersonService.page(new Page<>(page, rows), queryWrapper));
    }

    @GetMapping("/nonMotorVehicles/{page}/{rows}")
    public AjaxResult getNonMotorVehicles(@PathVariable(value = "page") Integer page, @PathVariable(value = "rows") Integer rows,
                                          @RequestParam(value = "beginTime") String beginTime, @RequestParam(value = "endTime") String endTime,
                                          @RequestParam(value = "deviceId", required = false) String deviceId, @RequestParam(value = "NonMotorVehicleID", required = false) String NonMotorVehicleID) {
        if (StringUtils.isNotEmpty(NonMotorVehicleID)) {
            return AjaxResult.success(viidNonMotorVehicleService.getById(NonMotorVehicleID));
        }
        LambdaQueryWrapper<ViidNonMotorVehicle>
                queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(StringUtils.isNotEmpty(beginTime), ViidNonMotorVehicle::getAppearTime,
                DateUtil.format(DateUtil.parse(beginTime), DatePattern.PURE_DATETIME_FORMAT), DateUtil.format(DateUtil.parse(endTime), DatePattern.PURE_DATETIME_FORMAT));
        queryWrapper.eq(StringUtils.isNotEmpty(deviceId), ViidNonMotorVehicle::getDeviceID, deviceId);
        queryWrapper.orderByDesc(ViidNonMotorVehicle::getAppearTime);
        return AjaxResult.success(viidNonMotorVehicleService.page(new Page<>(page, rows), queryWrapper));
    }

    /**
     * 机动车相关接口
     *
     * @param
     * @return
     */
    @PostMapping("/MotorVehicles")
    //大华的相机会传非utf8字符导致报错 所以先用string接
    public ResponsObject MotorVehicles(@RequestBody String motorVehicleRequest) {
        for (ViidMotorVehicle motorVehicle : JSON.toJavaObject(JSON.parseObject(motorVehicleRequest), MotorVehicleRequest.class).getMotorVehicleListObject().getMotorVehicleObject()) {
            viidDataService.saveViidMotorVehicleData(motorVehicle);

        }
        return new ResponsObject(ResponsStatusEnum.OK);

    }

    /**
     * 非机动车相关接口
     *
     * @param
     * @return
     */
    @PostMapping("/NonMotorVehicles")
    public ResponsObject NonMotorVehicles(@RequestBody NonMotorVehicleRequest nonMotorVehicleRequest) {
        for (ViidNonMotorVehicle nonMotorVehicle : nonMotorVehicleRequest.getNonMotorVehicleListObject().getNonMotorVehicleObject()) {
            viidDataService.saveViidNonMotorVehicleData(nonMotorVehicle);
        }
        return new ResponsObject(ResponsStatusEnum.OK);
    }

    /**
     * 人脸相关接口
     *
     * @param
     * @return
     */
    @PostMapping(value = "/Faces", produces = "application/json")
    public ResponsObject Faces(@RequestBody FaceRequest faceRequest) {
        for (ViidFace viidFace : faceRequest.getFaceListObject().getFaceObject()) {
            viidDataService.saveViidFaceData(viidFace);
        }
        return new ResponsObject(ResponsStatusEnum.OK);
    }

    /**
     * 人员相关接口
     *
     * @param
     * @return
     */
    @PostMapping("/Persons")
    public ResponsObject Persons(@RequestBody PersonRequest personRequest) {
        for (ViidPerson viidPerson : personRequest.getPersonListObject().getPersonObject()) {
            viidDataService.saveViidPersonData(viidPerson);
        }
        return new ResponsObject(ResponsStatusEnum.OK);
    }


    /**
     * 查询采集设备
     *
     * @param ApeID 设备ID
     * @param Name
     * @return
     */
    @GetMapping("/APEs")
    public Object APEs(@RequestParam(value = "ApeID", required = false) String ApeID, @RequestParam(value = "Name", required = false) String Name,
                       @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        QueryWrapper<ViidApe> apeQueryWrapper = new QueryWrapper();
        apeQueryWrapper.eq(StringUtils.isNotEmpty(ApeID), "ApeID", ApeID);
        apeQueryWrapper.eq(StringUtils.isNotEmpty(Name), "Name", Name);
        //分页参数用于平台自查，无分页则代表下级平台调用 返回全量
        if (page != null && rows != null) {
            return viidApeService.page(new Page<>(page, rows), apeQueryWrapper);
        }
        ApeRequest ApeRequest = new ApeRequest();

        ApeRequest.setAPEListObject(new ApeRequest.APEListObjectDTO(viidApeService.list(apeQueryWrapper)));
        return ApeRequest;
    }


    /**
     * /VIID/Subscribes
     * 批量订阅接口
     *
     * @param body 消息体结构参考C.19，字段定义参考A.19 。
     * @return 结构参考C.25，字段定义参考A.26。
     */
    @PostMapping("/Subscribes")
    public ResponsObject Subscribes(@RequestBody JSONObject body) {

        return new ResponsObject(ResponsStatusEnum.OK);
    }


    /**
     * 通知相关接口
     *
     * @param subscribeNotificationsRequest 消息体结构参考C.19，字段定义参考A.19 。
     * @return 结构参考C.25，字段定义参考A.26。
     */
    @PostMapping("/SubscribeNotifications")
    public ResponsObject SubscribeNotifications(@RequestBody SubscribeNotificationsRequest subscribeNotificationsRequest) {

      viidDataService.SubscribeNotifications(subscribeNotificationsRequest);
        return new ResponsObject(ResponsStatusEnum.OK);
    }


}
