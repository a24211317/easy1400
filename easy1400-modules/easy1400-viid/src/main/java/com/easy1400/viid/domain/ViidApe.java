package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 采集设备表
 * @TableName viid_ape
 */
@TableName(value ="viid_ape")
public class ViidApe implements Serializable {
    /**
     * 设备ID
     */
    @JsonProperty("ApeID")
    @TableId(value = "ApeID")
    private String ApeID;

    /**
     * 名称
     */
    @JsonProperty("Name")
    @TableField(value = "Name")
    private String Name;

    /**
     * 型号
     */
    @JsonProperty("Model")
    @TableField(value = "Model")
    private String Model;

    /**
     * IP地址
     */
    @JsonProperty("IPAddr")
    @TableField(value = "IPAddr")
    private String IPAddr;

    /**
     * IPv6地址
     */
    @JsonProperty("IPV6Addr")
    @TableField(value = "IPV6Addr")
    private String IPV6Addr;

    /**
     * 端口号
     */
    @JsonProperty("Port")
    @TableField(value = "Port")
    private Integer Port;

    /**
     * 经度
     */
    @JsonProperty("Longitude")
    @TableField(value = "Longitude")
    private Double Longitude;

    /**
     * 纬度
     */
    @JsonProperty("Latitude")
    @TableField(value = "Latitude")
    private Double Latitude;

    /**
     * 安装地点行政区划代码
     */
    @JsonProperty("PlaceCode")
    @TableField(value = "PlaceCode")
    private String PlaceCode;

    /**
     * 位置名
     */
    @JsonProperty("Place")
    @TableField(value = "Place")
    private String Place;

    /**
     * 管辖单位代码
     */
    @JsonProperty("OrgCode")
    @TableField(value = "OrgCode")
    private String OrgCode;

    /**
     * 车辆抓拍方向
     */
    @JsonProperty("CapDirection")
    @TableField(value = "CapDirection")
    private Integer CapDirection;

    /**
     * 监视方向
     */
    @JsonProperty("MonitorDirection")
    @TableField(value = "MonitorDirection")
    private Integer MonitorDirection;

    /**
     * 监视区域说明
     */
    @JsonProperty("MonitorAreaDesc")
    @TableField(value = "MonitorAreaDesc")
    private String MonitorAreaDesc;

    /**
     * 是否在线
     */
    @JsonProperty("IsOnline")
    @TableField(value = "IsOnline")
    private String IsOnline;

    /**
     * 所属采集系统
     */
    @JsonProperty("OwnerApsID")
    @TableField(value = "OwnerApsID")
    private String OwnerApsID;

    /**
     * 口令
     */
    @JsonProperty("Password")
    @TableField(value = "Password")
    private String Password;

    /**
     * 用户帐号
     */
    @JsonProperty("UserId")
    @TableField(value = "UserId")
    private String UserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public ViidApe() {
    }

    public ViidApe(String apeID, String name, String model, String IPAddr, String IPV6Addr, Integer port, Double longitude, Double latitude, String placeCode, String place, String orgCode, Integer capDirection, Integer monitorDirection, String monitorAreaDesc, String isOnline, String ownerApsID, String password, String userId) {
        ApeID = apeID;
        Name = name;
        Model = model;
        this.IPAddr = IPAddr;
        this.IPV6Addr = IPV6Addr;
        Port = port;
        Longitude = longitude;
        Latitude = latitude;
        PlaceCode = placeCode;
        Place = place;
        OrgCode = orgCode;
        CapDirection = capDirection;
        MonitorDirection = monitorDirection;
        MonitorAreaDesc = monitorAreaDesc;
        IsOnline = isOnline;
        OwnerApsID = ownerApsID;
        Password = password;
        UserId = userId;
    }

    public String getApeID() {
        return ApeID;
    }

    public void setApeID(String apeID) {
        ApeID = apeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getIPAddr() {
        return IPAddr;
    }

    public void setIPAddr(String IPAddr) {
        this.IPAddr = IPAddr;
    }

    public String getIPV6Addr() {
        return IPV6Addr;
    }

    public void setIPV6Addr(String IPV6Addr) {
        this.IPV6Addr = IPV6Addr;
    }

    public Integer getPort() {
        return Port;
    }

    public void setPort(Integer port) {
        Port = port;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public String getPlaceCode() {
        return PlaceCode;
    }

    public void setPlaceCode(String placeCode) {
        PlaceCode = placeCode;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getOrgCode() {
        return OrgCode;
    }

    public void setOrgCode(String orgCode) {
        OrgCode = orgCode;
    }

    public Integer getCapDirection() {
        return CapDirection;
    }

    public void setCapDirection(Integer capDirection) {
        CapDirection = capDirection;
    }

    public Integer getMonitorDirection() {
        return MonitorDirection;
    }

    public void setMonitorDirection(Integer monitorDirection) {
        MonitorDirection = monitorDirection;
    }

    public String getMonitorAreaDesc() {
        return MonitorAreaDesc;
    }

    public void setMonitorAreaDesc(String monitorAreaDesc) {
        MonitorAreaDesc = monitorAreaDesc;
    }

    public String getIsOnline() {
        return IsOnline;
    }

    public void setIsOnline(String isOnline) {
        IsOnline = isOnline;
    }

    public String getOwnerApsID() {
        return OwnerApsID;
    }

    public void setOwnerApsID(String ownerApsID) {
        OwnerApsID = ownerApsID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}