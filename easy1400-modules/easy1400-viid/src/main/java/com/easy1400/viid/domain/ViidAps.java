package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 采集系统表
 * @TableName viid_aps
 */
@TableName(value ="viid_aps")
public class ViidAps implements Serializable {
    /**
     * 设备 ID
     */
    @TableId(value = "ApsID")
    private String ApsID;

    /**
     * 名称
     */
    @TableField(value = "Name")
    private String Name;

    /**
     * IP 地址
     */
    @TableField(value = "IPAddr")
    private String IPAddr;

    /**
     * IPv6地址
     */
    @TableField(value = "IPV6Addr")
    private String IPV6Addr;

    /**
     * 端口号
     */
    @TableField(value = "Port")
    private Integer Port;

    /**
     * 是否在线
     */
    @TableField(value = "IsOnline")
    private String IsOnline;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public ViidAps() {
    }

    public ViidAps(String apsID, String name, String IPAddr, String IPV6Addr, Integer port, String isOnline) {
        ApsID = apsID;
        Name = name;
        this.IPAddr = IPAddr;
        this.IPV6Addr = IPV6Addr;
        Port = port;
        IsOnline = isOnline;
    }

    public String getApsID() {
        return ApsID;
    }

    public void setApsID(String apsID) {
        ApsID = apsID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getIsOnline() {
        return IsOnline;
    }

    public void setIsOnline(String isOnline) {
        IsOnline = isOnline;
    }
}