package com.easy1400.viid.common.util;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.common.core.utils.uuid.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RegisterAuthorizationUtil
 * @Author CH
 * @Date 2023/8/16 13:31
 * @Version 1.0
 */
public class RegisterAuthUtil {

    private static final Logger log = LoggerFactory.getLogger(RegisterAuthUtil.class);

    /**
     * 解密验证
     *
     * @return 验证结果
     */
    public static boolean hasAuth(String response, String password, Map<String, String> stringStringHashMap) {
        String realm = stringStringHashMap.get("realm");
        String strUsername = stringStringHashMap.get("Digest username");
        String HA1 = strUsername + ':' + realm + ':' + password;
        String strHA1 = DigestUtil.md5Hex(HA1);
        String strMethod = "POST";
        String HA2 = strMethod + ":" + stringStringHashMap.get("uri");
        String strHA2 = DigestUtil.md5Hex(HA2);
        String strHD = stringStringHashMap.get("nonce") +
                ":" + stringStringHashMap.get("nc") +
                ":" + stringStringHashMap.get("cnonce") +
                ":" + stringStringHashMap.get("qop");
        String strResponse = strHA1 + ':' + strHD + ':' + strHA2;
        strResponse = DigestUtil.md5Hex(strResponse);
        log.debug("HA1====strHA1===={}===={}", HA1, strHA1);
        log.debug("HA2====strHA2===={}======={}", HA2, strHA2);
        return strResponse.equals(response);
    }

    /**
     * 生成授权信息
     *
     * @param authorization 上一次调用返回401的WWW-Authenticate数据
     * @param username      用户名
     * @param password      密码
     * @return 授权后的数据, 应放在http头的Authorization里
     * @throws IOException 异常
     */
    public static String getAuthorization(String authorization, String uri, String username, String password, String method,Integer nc) throws IOException {

        uri = StringUtils.isEmpty(uri) ? "/" : uri;
        String temp = authorization.replaceFirst("Digest", "").trim().replace("MD5", "\"MD5\"");
        String json = withdrawJson(authorization);

        JSONObject jsonObject = JSON.parseObject(json);
        String cnonce = DigestsUtil.generateSalt2(8);
        String ncstr = ("00000000" + nc).substring(Integer.toString(nc).length());     //认证的次数,第一次是1，第二次是2...
        String algorithm = jsonObject.getString("algorithm");
        String qop = jsonObject.getString("qop");
        String nonce = jsonObject.getString("nonce");
        String realm = jsonObject.getString("realm");


        String response = getResponse(username, realm, password,
                nonce, ncstr, cnonce, qop,
                method, uri, algorithm);

        //组成响应authorization
        authorization = "Digest username=\"" + username;
        authorization += "\",uri=\"" + uri
                + "\",realm=\"" + realm
                + "\",nonce=\"" + nonce
                + "\",nc=\"" + ncstr
                + "\",cnonce=\"" + cnonce
                + "\",qop=\"" + qop
                + "\",response=\"" + response + "\"";
        return authorization;
    }
    /**
     * 加密工具
     *
     * @return 验证结果
     */
    private static String getResponse(String username, String realm, String password,
                                      String nonce, String nc, String cnonce, String qop,
                                      String method, String uri, String algorithm) {
        String HA1 = username + ':' + realm + ':' + password;
        String strHA1 = DigestUtil.md5Hex(HA1);
        String HA2 = method + ":" + uri;
        String strHA2 = DigestUtil.md5Hex(HA2);
        String strHD = nonce +
                ":" + nc +
                ":" + cnonce +
                ":" + qop;
        String strResponse = strHA1 + ':' + strHD + ':' + strHA2;
        strResponse = DigestUtil.md5Hex(strResponse);
        log.info("HA1====strHA1===={}===={}", HA1, strHA1);
        log.info("HA2====strHA2===={}======={}", HA2, strHA2);
        return strResponse;
    }

    /**
     * 将返回的Authrization信息转成json
     *
     * @param authorization authorization info
     * @return 返回authrization json格式数据 如：String json = "{ \"realm\": \"Wowza\", \" domain\": \"/\", \" nonce\": \"MTU1NzgxMTU1NzQ4MDo2NzI3MWYxZTZkYjBiMjQ2ZGRjYTQ3ZjNiOTM2YjJjZA==\", \" algorithm\": \"MD5\", \" qop\": \"auth\" }";
     */
    private static String withdrawJson(String authorization) {
        String temp = authorization.replaceFirst("\\[Digest ", "").trim().replaceAll("\"", "");
        String json = temp.replaceAll("]", ",");
        String[] split = json.split(",");
        Map<String, String> map = new HashMap<>();
        Arrays.asList(split).forEach(c -> {
            String c1 = c.replaceFirst("=", ":");
            String[] split1 = c1.split(":");
            map.put(split1[0].trim(), split1[1].trim());
        });
        return JSONObject.toJSONString(map);
    }
    public static String getAuthHeader(){
        StringBuilder responseHeader = new StringBuilder();
        responseHeader.append("Digest realm=\"easy1400.ch@com\"");
        responseHeader.append(",qop=\"auth\"");
        responseHeader.append(",algorithm=\"MD5\"");
        responseHeader.append(",nonce=\"" + UUID.randomUUID() + "\"");
        responseHeader.append(",opaque=\"" + UUID.randomUUID() + "\"");
        return responseHeader.toString();
    }
}
