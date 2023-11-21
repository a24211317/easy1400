package com.easy1400.viid.common.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easy1400.viid.common.conf.DynamicTask;
import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.domain.ViidSubscribe;
import com.easy1400.viid.domain.message.KeepaliveRequest;
import com.easy1400.viid.domain.message.RegisterRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 1400调用上级接口
 *
 * @ClassName ViidHttpUtil
 * @Author CH
 * @Date 2023/8/16 20:02
 * @Version 1.0
 */
@Component
public class ViidHttpUtil {

    @Autowired
    private DynamicTask dynamicTask;

    private static final Logger log = LoggerFactory.getLogger(ViidHttpUtil.class);
    //nc计数器
    private static JSONObject ncCountMap = new JSONObject();

    /**
     * 向上级发送注册
     *
     * @param viidCascadePlatform
     * @return
     */
    public String registerSend(ViidCascadePlatform viidCascadePlatform,ViidCascadePlatform bJPlatform) {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setDeviceID(bJPlatform.getSystemID());
        //第一次注册 得到注册信息
        HttpResponse execute = HttpRequest.post("http://" + viidCascadePlatform.getIPAddr() + ":" + viidCascadePlatform.getPort() + "/VIID/System/Register")
                .body(JSONUtil.toJsonStr(registerRequest))
                .execute();
        ncCountMap.put(viidCascadePlatform.getSystemID(), 1);
        if (execute != null) {
            Map<String, List<String>> headers = execute.headers();
            String strings = String.valueOf(headers.get("WWW-Authenticate"));
            String authorization = "";
            try {
                //解析授权信息
                authorization = RegisterAuthUtil.getAuthorization(
                        strings, "/VIID/System/Register", bJPlatform.getPassword(), bJPlatform.getPassword(),
                        "POST", ncCountMap.getInteger(viidCascadePlatform.getSystemID()));
                //再次注册 注册成功会的到200OK

                HttpResponse https = HttpRequest.post("http://" + viidCascadePlatform.getIPAddr() + ":" + viidCascadePlatform.getPort() + "/VIID/System/Register")
                        .header("authorization", authorization)
                        .contentType("application/VIID+JSON")
                        .body(JSONUtil.toJsonStr(registerRequest))
                        .execute();
                boolean ok = https.isOk();
                if (ok) {
                    //开启定时保活任务
                    ncCountMap.put(viidCascadePlatform.getSystemID(), 1);
                    String keepaliveTaskKey = DynamicTask.KEEPALIVE_KEY_PREFIX + viidCascadePlatform.getSystemID();
                    if (!dynamicTask.contains(DynamicTask.KEEPALIVE_KEY_PREFIX + viidCascadePlatform.getSystemID())) {
                        dynamicTask.startCron(keepaliveTaskKey,
                                () -> {
                                    this.KeepaliveSend(viidCascadePlatform);
                                    //30秒一次
                                }, 1000 * 30);
                    }
                    return "success";
                }
                ncCountMap.put(viidCascadePlatform.getSystemID(), ncCountMap.getInteger(viidCascadePlatform.getSystemID()) + 1);
            } catch (IOException e) {
                log.error("[平台注册 ] 向上级平台注册失败,上级平台编号为 {}", viidCascadePlatform.getSystemID());
            }
        }
        return "faild";
    }

    /**
     * 向上级平台发送保活
     *
     * @param viidCascadePlatform
     * @return
     */
    public Map KeepaliveSend(ViidCascadePlatform viidCascadePlatform) {
        log.info("viidCascadePlatform    {}", JSON.toJSONString(viidCascadePlatform));

        KeepaliveRequest keepaliveRequest = new KeepaliveRequest();
        keepaliveRequest.setDeviceID(viidCascadePlatform.getUserId());
        HttpRequest.post("http://" + viidCascadePlatform.getIPAddr() + ":" + viidCascadePlatform.getPort() + "/VIID/System/Keepalive")
                .body(JSONUtil.toJsonStr(keepaliveRequest))
                .header("User-Identify", viidCascadePlatform.getSystemID())
                .contentType("application/VIID+JSON")
                .execute();
        //弱校验 暂时不判断是否有效
        //TODO 判断心跳失效后重新注册
        return null;
    }

    /**
     * 向上级发送注册
     */
    public String subscribeSend(ViidSubscribe subscribe, ViidCascadePlatform viidCascadePlatform) {

        return HttpRequest.post("http://" + viidCascadePlatform.getIPAddr() + ":" + viidCascadePlatform.getPort() + "/VIID/System/Subscribe")
                .body(JSONUtil.toJsonStr(subscribe))
                .contentType("application/VIID+JSON")
                .execute().body();
    }

}
