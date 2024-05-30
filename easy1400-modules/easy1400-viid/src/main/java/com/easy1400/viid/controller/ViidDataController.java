package com.easy1400.viid.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.common.core.web.domain.AjaxResult;
import com.easy1400.common.redis.service.RedisService;
import com.easy1400.viid.common.constant.RedisConstants;
import com.easy1400.viid.domain.*;
import com.easy1400.viid.domain.enums.ResponsStatusEnum;
import com.easy1400.viid.domain.message.*;
import com.easy1400.viid.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    private ViidSubscribeService viidSubscribeService;
    @Autowired
    private RedisService redisService;

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
            viidDataService.SubscribeNotificationsSend(null, null, motorVehicle, null);
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
            viidDataService.SubscribeNotificationsSend(null, null, null, nonMotorVehicle);

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
            viidDataService.SubscribeNotificationsSend(viidFace, null, null, null);

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
            viidDataService.SubscribeNotificationsSend(null, viidPerson, null, null);

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
     * @param subscribeRequest 消息体结构参考C.19，字段定义参考A.19 。
     * @return 结构参考C.25，字段定义参考A.26。
     */
    @PostMapping("/Subscribes")
    public ResponsObject Subscribes(@RequestBody SubscribeRequest subscribeRequest, HttpServletRequest request) {
        String deviceId = request.getHeader("User-Identify");
        SubscribeRequest.SubscribeListObjectDTO.SubscribeObjectDTO subscribeObjectDTO = subscribeRequest.getSubscribeListObject().getSubscribeObject().get(0);
        ViidSubscribe viidSubscribe = new ViidSubscribe();
        viidSubscribe.setSubscribeID(subscribeObjectDTO.getSubscribeID());
        viidSubscribe.setTitle(subscribeObjectDTO.getTitle());
        viidSubscribe.setSubscribeDetail(subscribeObjectDTO.getSubscribeDetail());
        viidSubscribe.setResourceURI(subscribeObjectDTO.getResourceURI());
        viidSubscribe.setApplicantName(subscribeObjectDTO.getApplicantName());
        viidSubscribe.setApplicantOrg(subscribeObjectDTO.getApplicantOrg());
        viidSubscribe.setBeginTime(subscribeObjectDTO.getBeginTime());
        viidSubscribe.setEndTime(subscribeObjectDTO.getEndTime());
        viidSubscribe.setReceiveAddr(subscribeObjectDTO.getReceiveAddr());
        viidSubscribe.setReportInterval(subscribeObjectDTO.getReportInterval());
        viidSubscribe.setReason(subscribeObjectDTO.getReason());
        viidSubscribe.setOperateType(Integer.parseInt(subscribeObjectDTO.getOperateType()));
        viidSubscribe.setSubscribeStatus(0);
        viidSubscribe.setSubscribeCancOrg(subscribeObjectDTO.getSubscribeCancelOrg());
        viidSubscribe.setSubscribeCancelPerson(subscribeObjectDTO.getSubscribeCancelPerson());
        viidSubscribe.setCancelTime(subscribeObjectDTO.getCancelTime() != null ? DateUtil.parse(subscribeObjectDTO.getCancelTime()) : null);
        viidSubscribe.setCancelReason(subscribeObjectDTO.getCancelReason());
        viidSubscribe.setSubscribeType("1");
        viidSubscribe.setResourceClass(subscribeObjectDTO.getResourceClass());
        viidSubscribe.setApprovalStatus("0");
        viidSubscribe.setResultImageDeclare(subscribeObjectDTO.getResultImageDeclare());
        viidSubscribe.setResultFeatureDeclare(subscribeObjectDTO.getResultFeatureDeclare());
        viidSubscribe.setTabID(subscribeObjectDTO.getTabID());
        viidSubscribe.setSubscriberSendOrgID(deviceId);
        viidSubscribe.setSubscriberRecoverOrgID(subscribeObjectDTO.getResourceURI());
        viidSubscribeService.save(viidSubscribe);
        for (String s : subscribeObjectDTO.getSubscribeDetail().split(",")) {
            switch (s) {
                case "11":
                    redisService.setCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_PERSON, subscribeObjectDTO.getSubscribeID(), viidSubscribe);
                    break;
                case "12":
                    redisService.setCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_FACE, subscribeObjectDTO.getSubscribeID(), viidSubscribe);
                    break;
                case "13":
                    redisService.setCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_MOTORVEHICLE, subscribeObjectDTO.getSubscribeID(), viidSubscribe);
                    break;
                case "14":
                    redisService.setCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_NONMOTORVEHICLE, subscribeObjectDTO.getSubscribeID(), viidSubscribe);
                    break;
            }
        }
        //TODO 将订阅加入队列供后续数据推送
        return new ResponsObject(ResponsStatusEnum.OK, subscribeObjectDTO.getSubscribeID(), "/VIID/Subscribes");
    }

    @PutMapping("/Subscribes")
    public ResponsObject UpdateSubscribes(@RequestBody SubscribeRequest subscribeRequest, HttpServletRequest request) {
        String deviceId = request.getHeader("User-Identify");
        SubscribeRequest.SubscribeListObjectDTO.SubscribeObjectDTO subscribeObjectDTO = subscribeRequest.getSubscribeListObject().getSubscribeObject().get(0);
        ViidSubscribe viidSubscribe = new ViidSubscribe();
        viidSubscribe.setSubscribeID(subscribeObjectDTO.getSubscribeID());
        viidSubscribe.setTitle(subscribeObjectDTO.getTitle());
        viidSubscribe.setSubscribeDetail(subscribeObjectDTO.getSubscribeDetail());
        viidSubscribe.setResourceURI(subscribeObjectDTO.getResourceURI());
        viidSubscribe.setApplicantName(subscribeObjectDTO.getApplicantName());
        viidSubscribe.setApplicantOrg(subscribeObjectDTO.getApplicantOrg());
        viidSubscribe.setBeginTime(subscribeObjectDTO.getBeginTime());
        viidSubscribe.setEndTime(subscribeObjectDTO.getEndTime());
        viidSubscribe.setReceiveAddr(subscribeObjectDTO.getReceiveAddr());
        viidSubscribe.setReportInterval(subscribeObjectDTO.getReportInterval());
        viidSubscribe.setReason(subscribeObjectDTO.getReason());
        viidSubscribe.setOperateType(Integer.parseInt(subscribeObjectDTO.getOperateType()));
        viidSubscribe.setSubscribeStatus(Integer.parseInt(subscribeObjectDTO.getSubscribeStatus()));
        viidSubscribe.setSubscribeCancOrg(subscribeObjectDTO.getSubscribeCancelOrg());
        viidSubscribe.setSubscribeCancelPerson(subscribeObjectDTO.getSubscribeCancelPerson());
        viidSubscribe.setCancelTime(subscribeObjectDTO.getCancelTime() != null ? DateUtil.parse(subscribeObjectDTO.getCancelTime()) : null);
        viidSubscribe.setCancelReason(subscribeObjectDTO.getCancelReason());
        viidSubscribe.setSubscribeType("1");
        viidSubscribe.setResourceClass(subscribeObjectDTO.getResourceClass());
        viidSubscribe.setApprovalStatus("0");
        viidSubscribe.setResultImageDeclare(subscribeObjectDTO.getResultImageDeclare());
        viidSubscribe.setResultFeatureDeclare(subscribeObjectDTO.getResultFeatureDeclare());
        viidSubscribe.setTabID(subscribeObjectDTO.getTabID());
        viidSubscribe.setSubscriberSendOrgID(deviceId);
        viidSubscribe.setSubscriberRecoverOrgID(subscribeObjectDTO.getResourceURI());
        viidSubscribeService.updateById(viidSubscribe);
        redisService.deleteCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_PERSON, subscribeObjectDTO.getSubscribeID());
        redisService.deleteCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_FACE, subscribeObjectDTO.getSubscribeID());
        redisService.deleteCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_MOTORVEHICLE, subscribeObjectDTO.getSubscribeID());
        redisService.deleteCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_NONMOTORVEHICLE, subscribeObjectDTO.getSubscribeID());
        for (String s : subscribeObjectDTO.getSubscribeDetail().split(",")) {
            switch (s) {
                case "11":
                    redisService.setCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_PERSON, subscribeObjectDTO.getSubscribeID(), viidSubscribe);
                    break;
                case "12":
                    redisService.setCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_FACE, subscribeObjectDTO.getSubscribeID(), viidSubscribe);
                    break;
                case "13":
                    redisService.setCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_MOTORVEHICLE, subscribeObjectDTO.getSubscribeID(), viidSubscribe);
                    break;
                case "14":
                    redisService.setCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_NONMOTORVEHICLE, subscribeObjectDTO.getSubscribeID(), viidSubscribe);
                    break;
            }
        }
        return new ResponsObject(ResponsStatusEnum.OK, subscribeObjectDTO.getSubscribeID(), "/VIID/Subscribes");
    }

    @DeleteMapping("/Subscribes")
    public ResponsObject DelSubscribes(@RequestBody SubscribeRequest subscribeRequest, HttpServletRequest request) {
        String deviceId = request.getHeader("User-Identify");
        SubscribeRequest.SubscribeListObjectDTO.SubscribeObjectDTO subscribeObjectDTO = subscribeRequest.getSubscribeListObject().getSubscribeObject().get(0);
        ViidSubscribe viidSubscribe = new ViidSubscribe();
        viidSubscribe.setSubscribeID(subscribeObjectDTO.getSubscribeID());
        viidSubscribe.setTitle(subscribeObjectDTO.getTitle());
        viidSubscribe.setSubscribeDetail(subscribeObjectDTO.getSubscribeDetail());
        viidSubscribe.setResourceURI(subscribeObjectDTO.getResourceURI());
        viidSubscribe.setApplicantName(subscribeObjectDTO.getApplicantName());
        viidSubscribe.setApplicantOrg(subscribeObjectDTO.getApplicantOrg());
        viidSubscribe.setBeginTime(subscribeObjectDTO.getBeginTime());
        viidSubscribe.setEndTime(subscribeObjectDTO.getEndTime());
        viidSubscribe.setReceiveAddr(subscribeObjectDTO.getReceiveAddr());
        viidSubscribe.setReportInterval(subscribeObjectDTO.getReportInterval());
        viidSubscribe.setReason(subscribeObjectDTO.getReason());
        viidSubscribe.setOperateType(Integer.parseInt(subscribeObjectDTO.getOperateType()));
        viidSubscribe.setSubscribeStatus(Integer.parseInt(subscribeObjectDTO.getSubscribeStatus()));
        viidSubscribe.setSubscribeCancOrg(subscribeObjectDTO.getSubscribeCancelOrg());
        viidSubscribe.setSubscribeCancelPerson(subscribeObjectDTO.getSubscribeCancelPerson());
        viidSubscribe.setCancelTime(subscribeObjectDTO.getCancelTime() != null ? DateUtil.parse(subscribeObjectDTO.getCancelTime()) : null);
        viidSubscribe.setCancelReason(subscribeObjectDTO.getCancelReason());
        viidSubscribe.setSubscribeType("1");
        viidSubscribe.setResourceClass(subscribeObjectDTO.getResourceClass());
        viidSubscribe.setApprovalStatus("0");
        viidSubscribe.setResultImageDeclare(subscribeObjectDTO.getResultImageDeclare());
        viidSubscribe.setResultFeatureDeclare(subscribeObjectDTO.getResultFeatureDeclare());
        viidSubscribe.setTabID(subscribeObjectDTO.getTabID());
        viidSubscribe.setSubscriberSendOrgID(deviceId);
        viidSubscribe.setSubscriberRecoverOrgID(subscribeObjectDTO.getResourceURI());
        viidSubscribeService.removeById(viidSubscribe);
        redisService.deleteCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_PERSON, subscribeObjectDTO.getSubscribeID());
        redisService.deleteCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_FACE, subscribeObjectDTO.getSubscribeID());
        redisService.deleteCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_MOTORVEHICLE, subscribeObjectDTO.getSubscribeID());
        redisService.deleteCacheMapValue(RedisConstants.SUBSCRIBE_PARENT_NONMOTORVEHICLE, subscribeObjectDTO.getSubscribeID());
        return new ResponsObject(ResponsStatusEnum.OK, subscribeObjectDTO.getSubscribeID(), "/VIID/Subscribes");
    }


    /**
     * 通知相关接口
     *
     * @param subscribeNotificationsRequest 消息体结构参考C.19，字段定义参考A.19 。
     * @return 结构参考C.25，字段定义参考A.26。
     */
    @PostMapping("/SubscribeNotifications")
    public ResponsObject SubscribeNotifications(@RequestBody String subscribeNotificationsRequest) {
        viidDataService.SubscribeNotifications(JSON.toJavaObject(
                JSON.parseObject(subscribeNotificationsRequest), SubscribeNotificationsRequest.class));
        return new ResponsObject(ResponsStatusEnum.OK);
    }


}
