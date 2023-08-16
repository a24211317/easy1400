package com.easy1400.viid.common.util;

import cn.hutool.crypto.digest.DigestUtil;
import com.easy1400.viid.domain.ViidApe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public static boolean hasAuth(String response, ViidApe ape, Map<String, String> stringStringHashMap) {
        String realm = stringStringHashMap.get("realm");
        String password = ape.getPassword();
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
}
