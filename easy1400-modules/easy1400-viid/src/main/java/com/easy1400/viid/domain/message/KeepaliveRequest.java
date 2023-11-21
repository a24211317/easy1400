package com.easy1400.viid.domain.message;

/**
 * @ClassName KeepAliveRequest
 * @Author CH
 * @Date 2023/8/16 17:46
 * @Version 1.0
 */
public class KeepaliveRequest {
    private KeepaliveObject keepaliveObject;

    public KeepaliveRequest(KeepaliveObject keepaliveObject) {
        this.keepaliveObject = keepaliveObject;
    }

    public KeepaliveRequest() {
        keepaliveObject = new KeepaliveObject();
    }

    public KeepaliveObject getKeepaliveObject() {
        return keepaliveObject;
    }

    public void setKeepaliveObject(KeepaliveObject keepaliveObject) {
        this.keepaliveObject = keepaliveObject;
    }


    public String getDeviceID() {
        return keepaliveObject.getDeviceID();
    }

    public void setDeviceID(String deviceID) {
        keepaliveObject.setDeviceID(deviceID);
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
