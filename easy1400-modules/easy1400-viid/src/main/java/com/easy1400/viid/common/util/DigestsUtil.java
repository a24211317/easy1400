package com.easy1400.viid.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Random;

/**
 * Http Digest
 * @author ch
 * @date 2024-05-29
 */
public class DigestsUtil {
    public static String md5Hex(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(data.getBytes());
            return byteArrayToHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String byteArrayToHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    private static String generateCnonce() {
        Random random = new Random();
        byte[] cnonceBytes = new byte[16];
        random.nextBytes(cnonceBytes);
        return byteArrayToHexString(cnonceBytes);
    }

    public static String generateDigestAuthHeader(
            String username, String password, String realm, String nonce,
            String uri, String method, String qop, int nc) {

        String cnonce = generateCnonce();

        // HA1 = MD5(username:realm:password)
        String ha1 = md5Hex(username + ":" + realm + ":" + password);

        // HA2 = MD5(method:digestURI)
        String ha2 = md5Hex(method + ":" + uri);

        // Response = MD5(HA1:nonce:nc:cnonce:qop:HA2)
        String response = md5Hex(ha1 + ":" + nonce + ":" +  nc + ":" + cnonce + ":" + qop + ":" + ha2);

        return "Digest username=\"" + username + "\", realm=\"" + realm +
                "\", nonce=\"" + nonce + "\", uri=\"" + uri + "\", response=\"" + response +
                "\", qop=" + qop + ", nc=" +  nc + ", cnonce=\"" + cnonce + "\"";
    }

    public static boolean validateDigestAuth(
            String username, String password, String realm, String nonce,
            String uri, String method, String qop, int nc, String cnonce, String clientResponse) {

        // HA1 = MD5(username:realm:password)
        String ha1 = md5Hex(username + ":" + realm + ":" + password);

        // HA2 = MD5(method:digestURI)
        String ha2 = md5Hex(method + ":" + uri);

        // Server's expected response = MD5(HA1:nonce:nc:cnonce:qop:HA2)
        String expectedResponse = md5Hex(ha1 + ":" + nonce + ":" + nc + ":" + cnonce + ":" + qop + ":" + ha2);

        // Compare server's expected response with client's response
        return expectedResponse.equals(clientResponse);
    }
    @Deprecated
    public static String generateSalt2(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2)%2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val.toLowerCase();
    }


}
