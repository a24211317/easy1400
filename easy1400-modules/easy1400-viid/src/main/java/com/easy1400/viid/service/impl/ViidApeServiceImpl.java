package com.easy1400.viid.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.MapUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy1400.common.core.utils.uuid.UUID;
import com.easy1400.viid.common.util.RegisterAuthUtil;
import com.easy1400.viid.domain.ViidApe;
import com.easy1400.viid.domain.message.KeepaliveRequest;
import com.easy1400.viid.domain.message.RegisterRequest;
import com.easy1400.viid.service.ViidApeService;
import com.easy1400.viid.mapper.ViidApeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenghong
 * @description 针对表【viid_ape(采集设备表)】的数据库操作Service实现
 * @createDate 2023-08-16 12:51:56
 */
@Service

public class ViidApeServiceImpl extends ServiceImpl<ViidApeMapper, ViidApe>
        implements ViidApeService {
    private static final Logger log = LoggerFactory.getLogger(ViidApeServiceImpl.class);

    //暂时用来记录已注册的设备
    static final List<String> DeviceIDs = new ArrayList<>();

    @Override
    public Map register(RegisterRequest registerRequest, HttpServletRequest request, HttpServletResponse response) {
        // 取到下级平台ID
        String deviceID = registerRequest.getDeviceID();
        // 从数据库查询是否有此下级平台ID
        ViidApe ape = this.getById(deviceID);
        // 判断结果集是否为空
        if (ape == null) {
            log.info("无此下级平台ID");
            return null;
        }
        String authorization = request.getHeader("authorization");
        // 请求头无此字段，表示第一次注册，返回401
        if (authorization == null || "".equals(authorization)) {
            System.out.println("我是第一次发送注册请求");
            response.addHeader("WWW-Authenticate", RegisterAuthUtil.getAuthHeader());
            response.setStatus(401);
            return null;
        }
        // 获取请求头认证信息
        // 以逗号分隔切割数组
        String[] split = authorization.split(",");

        // 存放解析后的字典映射
        Map<String, String> stringStringHashMap = new HashMap<>();
        for (String s : split) {
            String[] split1 = s.split("=");
            stringStringHashMap.put(split1[0].trim(), split1[1].replace("\"", ""));
        }
        //=======================开始认证加密======================
        log.debug("平台id为====》{}", deviceID);
        log.debug("注册信息为====》{}", stringStringHashMap);

        if (RegisterAuthUtil.hasAuth(stringStringHashMap.get("response").toString(), ape, stringStringHashMap)) {
            log.debug("下级平台验证通过");
            response.setStatus(200);
            HashMap<String, Object> responseMap = new HashMap<>();
            HashMap<String, String> responseStatus = new HashMap<>();
            responseStatus.put("RequestURL", stringStringHashMap.get("uri"));
            responseStatus.put("StatusCode", "0");
            responseStatus.put("StatusString", "OK");
            responseStatus.put("Id", deviceID);
            responseStatus.put("LocalTime", String.valueOf(DateUtil.current()));
            responseMap.put("ResponseStatusObject", responseStatus);
            DeviceIDs.add(ape.getApeID());
            return responseMap;
        }
        log.debug("下级平台验证未通过");
        return null;
    }

    @Override
    public Map Keepalive(KeepaliveRequest keepaliveRequest,HttpServletResponse response) {
        if (DeviceIDs.contains(keepaliveRequest.getDeviceID())) {
            HashMap<String, Object> responseObj = new HashMap<>();
            HashMap<String, String> responseStatus = new HashMap<>();
            responseStatus.put("StatusCode", "0");
            responseStatus.put("StatusString", "OK");
            responseStatus.put("Id", keepaliveRequest.getDeviceID());
            responseStatus.put("LocalTime", String.valueOf(DateUtil.current()));
            responseObj.put("ResponseStatusObject", responseStatus);
            response.setStatus(200);
            return responseObj;
        }
        response.addHeader("WWW-Authenticate", RegisterAuthUtil.getAuthHeader());
        response.setStatus(401);
        return null;
    }
}




