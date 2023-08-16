package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 采集设备表
 * @TableName viid_ape
 */
@TableName(value ="viid_ape")
public class ViidApe implements Serializable {
    /**
     * 设备ID
     */
    @TableId
    private String apeid;

    /**
     * 名称
     */
    private String name;

    /**
     * 型号
     */
    private String model;

    /**
     * IP地址
     */
    private String ipaddr;

    /**
     * IPv6地址
     */
    private String ipv6addr;

    /**
     * 端口号
     */
    private Integer port;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 安装地点行政区划代码
     */
    private String placecode;

    /**
     * 位置名
     */
    private String place;

    /**
     * 管辖单位代码
     */
    private String orgcode;

    /**
     * 车辆抓拍方向
     */
    private Integer capdirection;

    /**
     * 监视方向
     */
    private Integer monitordirection;

    /**
     * 监视区域说明
     */
    private String monitorareadesc;

    /**
     * 是否在线
     */
    private String isonline;

    /**
     * 所属采集系统
     */
    private String ownerapsid;

    /**
     * 口令
     */
    private String password;

    /**
     * 用户帐号
     */
    private byte[] userid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 设备ID
     */
    public String getApeid() {
        return apeid;
    }

    /**
     * 设备ID
     */
    public void setApeid(String apeid) {
        this.apeid = apeid;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * IP地址
     */
    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * IP地址
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    /**
     * IPv6地址
     */
    public String getIpv6addr() {
        return ipv6addr;
    }

    /**
     * IPv6地址
     */
    public void setIpv6addr(String ipv6addr) {
        this.ipv6addr = ipv6addr;
    }

    /**
     * 端口号
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 端口号
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 安装地点行政区划代码
     */
    public String getPlacecode() {
        return placecode;
    }

    /**
     * 安装地点行政区划代码
     */
    public void setPlacecode(String placecode) {
        this.placecode = placecode;
    }

    /**
     * 位置名
     */
    public String getPlace() {
        return place;
    }

    /**
     * 位置名
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 管辖单位代码
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * 管辖单位代码
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    /**
     * 车辆抓拍方向
     */
    public Integer getCapdirection() {
        return capdirection;
    }

    /**
     * 车辆抓拍方向
     */
    public void setCapdirection(Integer capdirection) {
        this.capdirection = capdirection;
    }

    /**
     * 监视方向
     */
    public Integer getMonitordirection() {
        return monitordirection;
    }

    /**
     * 监视方向
     */
    public void setMonitordirection(Integer monitordirection) {
        this.monitordirection = monitordirection;
    }

    /**
     * 监视区域说明
     */
    public String getMonitorareadesc() {
        return monitorareadesc;
    }

    /**
     * 监视区域说明
     */
    public void setMonitorareadesc(String monitorareadesc) {
        this.monitorareadesc = monitorareadesc;
    }

    /**
     * 是否在线
     */
    public String getIsonline() {
        return isonline;
    }

    /**
     * 是否在线
     */
    public void setIsonline(String isonline) {
        this.isonline = isonline;
    }

    /**
     * 所属采集系统
     */
    public String getOwnerapsid() {
        return ownerapsid;
    }

    /**
     * 所属采集系统
     */
    public void setOwnerapsid(String ownerapsid) {
        this.ownerapsid = ownerapsid;
    }

    /**
     * 口令
     */
    public String getPassword() {
        return password;
    }

    /**
     * 口令
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用户帐号
     */
    public byte[] getUserid() {
        return userid;
    }

    /**
     * 用户帐号
     */
    public void setUserid(byte[] userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ViidApe other = (ViidApe) that;
        return (this.getApeid() == null ? other.getApeid() == null : this.getApeid().equals(other.getApeid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getModel() == null ? other.getModel() == null : this.getModel().equals(other.getModel()))
            && (this.getIpaddr() == null ? other.getIpaddr() == null : this.getIpaddr().equals(other.getIpaddr()))
            && (this.getIpv6addr() == null ? other.getIpv6addr() == null : this.getIpv6addr().equals(other.getIpv6addr()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getPlacecode() == null ? other.getPlacecode() == null : this.getPlacecode().equals(other.getPlacecode()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getOrgcode() == null ? other.getOrgcode() == null : this.getOrgcode().equals(other.getOrgcode()))
            && (this.getCapdirection() == null ? other.getCapdirection() == null : this.getCapdirection().equals(other.getCapdirection()))
            && (this.getMonitordirection() == null ? other.getMonitordirection() == null : this.getMonitordirection().equals(other.getMonitordirection()))
            && (this.getMonitorareadesc() == null ? other.getMonitorareadesc() == null : this.getMonitorareadesc().equals(other.getMonitorareadesc()))
            && (this.getIsonline() == null ? other.getIsonline() == null : this.getIsonline().equals(other.getIsonline()))
            && (this.getOwnerapsid() == null ? other.getOwnerapsid() == null : this.getOwnerapsid().equals(other.getOwnerapsid()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (Arrays.equals(this.getUserid(), other.getUserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApeid() == null) ? 0 : getApeid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getModel() == null) ? 0 : getModel().hashCode());
        result = prime * result + ((getIpaddr() == null) ? 0 : getIpaddr().hashCode());
        result = prime * result + ((getIpv6addr() == null) ? 0 : getIpv6addr().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getPlacecode() == null) ? 0 : getPlacecode().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getOrgcode() == null) ? 0 : getOrgcode().hashCode());
        result = prime * result + ((getCapdirection() == null) ? 0 : getCapdirection().hashCode());
        result = prime * result + ((getMonitordirection() == null) ? 0 : getMonitordirection().hashCode());
        result = prime * result + ((getMonitorareadesc() == null) ? 0 : getMonitorareadesc().hashCode());
        result = prime * result + ((getIsonline() == null) ? 0 : getIsonline().hashCode());
        result = prime * result + ((getOwnerapsid() == null) ? 0 : getOwnerapsid().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + (Arrays.hashCode(getUserid()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", apeid=").append(apeid);
        sb.append(", name=").append(name);
        sb.append(", model=").append(model);
        sb.append(", ipaddr=").append(ipaddr);
        sb.append(", ipv6addr=").append(ipv6addr);
        sb.append(", port=").append(port);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", placecode=").append(placecode);
        sb.append(", place=").append(place);
        sb.append(", orgcode=").append(orgcode);
        sb.append(", capdirection=").append(capdirection);
        sb.append(", monitordirection=").append(monitordirection);
        sb.append(", monitorareadesc=").append(monitorareadesc);
        sb.append(", isonline=").append(isonline);
        sb.append(", ownerapsid=").append(ownerapsid);
        sb.append(", password=").append(password);
        sb.append(", userid=").append(userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}