package com.easy1400.viid.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.easy1400.viid.domain.enums.ResponsStatusEnum;
import com.easy1400.viid.domain.message.FaceRequest;
import com.easy1400.viid.domain.message.MotorVehicleRequest;
import com.easy1400.viid.domain.message.ResponsObject;
import com.easy1400.viid.service.ViidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    /**
     * 机动车相关接口
     *
     * @param
     * @return
     */
    @RequestMapping("/MotorVehicles")
    public ResponsObject MotorVehicles(@RequestBody String motorVehicleRequest) {
        viidDataService.saveViidMotorVehicleData(JSON.toJavaObject(JSON.parseObject(motorVehicleRequest),MotorVehicleRequest.class));
        return new ResponsObject(ResponsStatusEnum.OK);

    }

    /**
     * 非机动车相关接口
     *
     * @param body
     * @return
     */
    @RequestMapping("/NonMotorVehicles")
    public ResponsObject NonMotorVehicles(HttpServletRequest request, @RequestBody String body) {
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
     * @param body
     * @return
     */
    @RequestMapping("/Persons")
    public ResponsObject Persons(@RequestBody String body) {
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
     * /VIID/Subscribes
     */

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
