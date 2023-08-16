package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName viid_cascade_platform
 */
@TableName(value ="viid_cascade_platform")
public class ViidCascadePlatform implements Serializable {
    /**
     * 平台ID
     */
    private String systemid;

    /**
     * 平台名称
     */
    private String name;

    /**
     * IP地址
     */
    private String ipaddr;

    /**
     * 端口
     */
    private String port;

    /**
     * 是否在线
     */
    private String isonline;

    /**
     * 最后在线时间
     */
    private Date lastonlinetime;

    /**
     * 级联平台类型（0上级 1下级）
     */
    private String type;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 密码
     */
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 平台ID
     */
    public String getSystemid() {
        return systemid;
    }

    /**
     * 平台ID
     */
    public void setSystemid(String systemid) {
        this.systemid = systemid;
    }

    /**
     * 平台名称
     */
    public String getName() {
        return name;
    }

    /**
     * 平台名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 端口
     */
    public String getPort() {
        return port;
    }

    /**
     * 端口
     */
    public void setPort(String port) {
        this.port = port;
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
     * 最后在线时间
     */
    public Date getLastonlinetime() {
        return lastonlinetime;
    }

    /**
     * 最后在线时间
     */
    public void setLastonlinetime(Date lastonlinetime) {
        this.lastonlinetime = lastonlinetime;
    }

    /**
     * 级联平台类型（0上级 1下级）
     */
    public String getType() {
        return type;
    }

    /**
     * 级联平台类型（0上级 1下级）
     */
    public void setType(String type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}