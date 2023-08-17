package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 级联信息表
 * @TableName viid_cascade_platform
 */
@TableName(value ="viid_cascade_platform")
public class ViidCascadePlatform implements Serializable {
    /**
     * 平台ID
     */
    @TableField(value = "SystemID")
    private String SystemID;

    /**
     * 平台名称
     */
    @TableField(value = "Name")
    private String Name;

    /**
     * IP地址
     */
    @TableField(value = "IPAddr")
    private String IPAddr;

    /**
     * 端口
     */
    @TableField(value = "Port")
    private String Port;

    /**
     * 是否在线
     */
    @TableField(value = "IsOnline")
    private String IsOnline;

    /**
     * 最后在线时间
     */
    @TableField(value = "LastOnlineTime")
    private Date LastOnlineTime;

    /**
     * 级联平台类型（0上级 1下级）
     */
    @TableField(value = "Type")
    private String Type;

    /**
     * 用户ID
     */
    @TableField(value = "UserId")
    private String UserId;

    /**
     * 密码
     */
    @TableField(value = "Password")
    private String Password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public ViidCascadePlatform() {
    }

    public ViidCascadePlatform(String systemID, String name, String IPAddr, String port, String isOnline, Date lastOnlineTime, String type, String userId, String password) {
        SystemID = systemID;
        Name = name;
        this.IPAddr = IPAddr;
        Port = port;
        IsOnline = isOnline;
        LastOnlineTime = lastOnlineTime;
        Type = type;
        UserId = userId;
        Password = password;
    }

    public String getSystemID() {
        return SystemID;
    }

    public void setSystemID(String systemID) {
        SystemID = systemID;
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

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }

    public String getIsOnline() {
        return IsOnline;
    }

    public void setIsOnline(String isOnline) {
        IsOnline = isOnline;
    }

    public Date getLastOnlineTime() {
        return LastOnlineTime;
    }

    public void setLastOnlineTime(Date lastOnlineTime) {
        LastOnlineTime = lastOnlineTime;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}