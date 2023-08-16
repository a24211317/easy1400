package com.easy1400.viid.controller;

import com.alibaba.fastjson.JSONObject;
import com.easy1400.viid.domain.message.RegisterRequest;
import com.easy1400.viid.service.ViidApeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName ViidSystemController
 * @Author CH
 * @Date 2023/8/16 13:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/VIID/System")
public class ViidSystemController {

    @Autowired
    private ViidApeService viidApeService;
    /**
     * 注册方法
     * 下级平台的数据进行注册方法
     * @return
     */
    @PostMapping(value = "/Register")
    public Map Register(@RequestBody JSONObject registerRequest, HttpServletRequest request, HttpServletResponse response){
        Map register = viidApeService.register(registerRequest.toJavaObject(RegisterRequest.class),request,response);
        return register;

    }
}
