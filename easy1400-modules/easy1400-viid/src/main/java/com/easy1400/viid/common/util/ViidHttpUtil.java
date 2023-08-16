package com.easy1400.viid.common.util;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.domain.message.RegisterRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1400调用上级接口
 * @ClassName ViidHttpUtil
 * @Author CH
 * @Date 2023/8/16 20:02
 * @Version 1.0
 */
public class ViidHttpUtil {
private static final Logger log= LoggerFactory.getLogger(ViidHttpUtil.class);
//nc计数器
   private static JSONObject ncCountMap=new JSONObject();

    public static String registerSend(ViidCascadePlatform viidCascadePlatform){
        RegisterRequest registerRequest=new RegisterRequest();
        registerRequest.setDeviceID(viidCascadePlatform.getUserid());
        //第一次注册 得到注册信息
       HttpResponse execute=  HttpRequest.post("http://"+viidCascadePlatform.getIpaddr()+":"+viidCascadePlatform.getPort()+"/VIID/System/Register")
                .body(JSONUtil.toJsonStr(registerRequest))
                .execute();
       ncCountMap.put(viidCascadePlatform.getSystemid(),1);
       if (execute!=null) {
           Map<String, List<String>> headers = execute.headers();
           String strings = String.valueOf(headers.get("WWW-Authenticate"));
           String authorization = "";
           try {
               //解析授权信息
               authorization = RegisterAuthUtil.getAuthorization(
                       strings, "/VIID/System/Register", viidCascadePlatform.getUserid(), viidCascadePlatform.getPassword(),
                       "POST",ncCountMap.getInteger(viidCascadePlatform.getSystemid()));
               //再次注册 注册成功会的到200OK
               HttpResponse https = HttpRequest.post("http://"+viidCascadePlatform.getIpaddr()+":"+viidCascadePlatform.getPort()+"/VIID/System/Register")
                       .header("authorization", authorization)
                       .body(JSONUtil.toJsonStr(registerRequest))
                       .execute();
               boolean ok = https.isOk();
               if (ok) {
                   //KeepaliveSend();
                   ncCountMap.put(viidCascadePlatform.getSystemid(),1);
                   return "success";
               }
               ncCountMap.put(viidCascadePlatform.getSystemid(),ncCountMap.getInteger(viidCascadePlatform.getSystemid())+1);
           } catch (IOException e) {
               log.error("[平台注册 ] 向上级平台注册失败,上级平台编号为 {}",viidCascadePlatform.getSystemid());
           }
       }
        return "faild";
    }


}
