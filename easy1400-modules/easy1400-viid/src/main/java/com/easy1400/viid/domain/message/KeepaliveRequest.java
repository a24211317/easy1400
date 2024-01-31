package com.easy1400.viid.domain.message;

/**
 * @ClassName KeepAliveRequest
 * @Author CH
 * @Date 2023/8/16 17:46
 * @Version 1.0
 */
public class KeepaliveRequest {
    private KeepaliveObject KeepaliveObject;

    public KeepaliveRequest(KeepaliveObject keepaliveObject) {
        this.KeepaliveObject = keepaliveObject;
    }

    public KeepaliveRequest() {
        KeepaliveObject = new KeepaliveObject();
    }

    public KeepaliveObject getKeepaliveObject() {
        return KeepaliveObject;
    }

    public void setKeepaliveObject(KeepaliveObject keepaliveObject) {
        this.KeepaliveObject = keepaliveObject;
    }


    public String getDeviceID() {
        return KeepaliveObject.getDeviceID();
    }

    public void setDeviceID(String deviceID) {
        KeepaliveObject.setDeviceID(deviceID);
    }

    static class KeepaliveObject {
        private String DeviceID;

        public String getDeviceID() {
            return DeviceID;
        }


        public void setDeviceID(String deviceID) {
            DeviceID = deviceID;
        }

        public KeepaliveObject(String deviceID) {
            DeviceID = deviceID;
        }

        public KeepaliveObject() {
        }

    }

}
