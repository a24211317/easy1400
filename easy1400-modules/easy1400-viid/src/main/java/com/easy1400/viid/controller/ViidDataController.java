package com.easy1400.viid.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.common.core.web.domain.AjaxResult;
import com.easy1400.viid.domain.ViidMotorVehicle;
import com.easy1400.viid.domain.enums.ResponsStatusEnum;
import com.easy1400.viid.domain.message.*;
import com.easy1400.viid.service.ViidDataService;
import com.easy1400.viid.service.ViidMotorVehicleService;
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
                DateUtil.format(DateUtil.parse(beginTime), DatePattern.PURE_DATETIME_FORMAT), DateUtil.format(DateUtil.parse(endTime),DatePattern.PURE_DATETIME_FORMAT));
        queryWrapper.eq(StringUtils.isNotEmpty(deviceId), ViidMotorVehicle::getDeviceID, deviceId);
        return AjaxResult.success(viidMotorVehicleService.page(new Page<>(page, rows), queryWrapper));
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
        viidDataService.saveViidMotorVehicleData(JSON.toJavaObject(JSON.parseObject(motorVehicleRequest), MotorVehicleRequest.class));
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
        viidDataService.saveViidNonMotorVehicleData(nonMotorVehicleRequest);
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
        viidDataService.saveViidFaceData(faceRequest);
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
        viidDataService.saveViidPersonData(personRequest);
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
    public JSONObject APEs(@RequestParam(value = "ApeID", required = false) String ApeID, @RequestParam(value = "Name", required = false) String Name) {
        return null;
    }


    /**
     * /VIID/Subscribes
     */

    /**
     * 批量订阅接口
     *
     * @param body 消息体结构参考C.19，字段定义参考A.19 。
     * @return 结构参考C.25，字段定义参考A.26。
     */
    @PostMapping("/Subscribes")
    public JSONObject Subscribes(@RequestBody JSONObject body) {
        return null;
    }


    /**
     * 通知相关接口
     *
     * @param body 消息体结构参考C.19，字段定义参考A.19 。
     * @return 结构参考C.25，字段定义参考A.26。
     */
    @PostMapping("/SubscribeNotifications")
    public JSONObject SubscribeNotifications(@RequestBody JSONObject body) {

        return null;
    }


}
