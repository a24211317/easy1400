package com.easy1400.viid.domain.message;

/**
 * @ClassName RegisterObject
 * @Author CH
 * @Date 2023/8/16 13:13
 * @Version 1.0
 */
public class RegisterRequest {
    private RegisterObject RegisterObject;



    public RegisterRequest() {
        this.RegisterObject = new RegisterObject();
    }

    public RegisterObject getRegisterObject() {
        return RegisterObject;
    }

    public void setRegisterObject(RegisterObject registerObject) {
        this.RegisterObject = registerObject;
    }

    public void setRegisterObject(String registerObject) {
    }

    public String getDeviceID() {
        return RegisterObject.getDeviceID();
    }

    public void setDeviceID(String deviceID) {
        RegisterObject.setDeviceID(deviceID);
    }

    static class RegisterObject {
        private String DeviceID;
        private String ProtocolVersion;

        public String getDeviceID() {
            return DeviceID;
        }

        public RegisterObject(String deviceID, String protocolVersion) {
            DeviceID = deviceID;
            ProtocolVersion = protocolVersion;
        }

        public void setDeviceID(String deviceID) {
            DeviceID = deviceID;
        }

        public RegisterObject(String deviceID) {
            DeviceID = deviceID;
        }

        public RegisterObject() {
        }

        public String getProtocolVersion() {
            return ProtocolVersion;
        }

        public void setProtocolVersion(String protocolVersion) {
            ProtocolVersion = protocolVersion;
        }
    }

}
