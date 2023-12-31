package com.easy1400.viid.service;

import com.easy1400.viid.domain.ViidApe;
import com.baomidou.mybatisplus.extension.service.IService;
import com.easy1400.viid.domain.message.KeepaliveRequest;
import com.easy1400.viid.domain.message.RegisterRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
* @author chenghong
* @description 针对表【viid_ape(采集设备表)】的数据库操作Service
* @createDate 2023-08-16 12:51:56
*/
public interface ViidApeService extends IService<ViidApe> {
    /**
     * 注册方法
     * 下级平台的数据进行注册方法
     * @return
     */
    Map register(RegisterRequest registerRequest ,HttpServletRequest request, HttpServletResponse response);

    /**
     * 心跳保活方法
     *
     * @return
     */
    Map Keepalive(KeepaliveRequest keepaliveRequest, HttpServletResponse response);
}
