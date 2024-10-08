package com.easy1400.viid.service.impl.db;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy1400.viid.common.util.RegisterAuthUtil;
import com.easy1400.viid.domain.ViidApe;
import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.domain.message.KeepaliveRequest;
import com.easy1400.viid.domain.message.RegisterRequest;
import com.easy1400.viid.mapper.ViidApeMapper;
import com.easy1400.viid.mapper.ViidCascadePlatformMapper;
import com.easy1400.viid.service.ViidApeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenghong
 * @description 针对表【viid_ape(采集设备表)】的数据库操作Service实现
 * @createDate 2023-08-16 12:51:56
 */
@Service

public class ViidApeServiceImpl extends ServiceImpl<ViidApeMapper, ViidApe>
        implements ViidApeService {
    private static final Logger log = LoggerFactory.getLogger(ViidApeServiceImpl.class);
    @Resource
    private ViidCascadePlatformMapper viidCascadePlatformMapper;

    //暂时用来记录已注册的设备
    static final List<String> DeviceIDs = new ArrayList<>();

    @Override
    public Map register(RegisterRequest registerRequest, HttpServletRequest request, HttpServletResponse response) {
        // 取到下级平台ID
        String deviceID = registerRequest.getDeviceID();
        ViidApe ape = this.getById(deviceID);
        ViidCascadePlatform viidCascadePlatform=null;
        String password = null;
        // 从采集设备库查询是否有此下级平台ID
        if (ape == null) {
            //从下级平台里查询
            LambdaQueryWrapper<ViidCascadePlatform> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ViidCascadePlatform::getSystemID, deviceID);
            queryWrapper.eq(ViidCascadePlatform::getType, 0);
             viidCascadePlatform = viidCascadePlatformMapper.selectOne(queryWrapper);
            if (viidCascadePlatform == null) {
                log.info("无此下级平台ID");
                response.setStatus(404);
                return null;
            }
            password = viidCascadePlatform.getPassword();
        }else {
            password=ape.getPassword();
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
        // 存放解析后的字典映射
        Map<String, String> stringStringHashMap =parseDigestParams(authorization);
        //=======================开始认证加密======================
        log.debug("平台id为====》{}", deviceID);
        log.debug("注册信息为====》{}", stringStringHashMap);

        if (RegisterAuthUtil.hasAuth(password, stringStringHashMap)) {
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
            if (ape == null) {
                DeviceIDs.add(viidCascadePlatform.getSystemID());

            }else {
                DeviceIDs.add(ape.getApeID());

            }
            return responseMap;
        }
        log.debug("下级平台验证未通过");
        response.setStatus(400);
        return null;
    }

    @Override
    public Map Keepalive(KeepaliveRequest keepaliveRequest, HttpServletResponse response) {
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
    public static Map<String, String> parseDigestParams(String authHeader) {
        Map<String, String> params = new HashMap<>();
        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)=(\"[^\"]+\"|[^,]+)");
        Matcher matcher = pattern.matcher(authHeader);
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            if (value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            }
            params.put(key, value);
        }
        return params;
    }
}




