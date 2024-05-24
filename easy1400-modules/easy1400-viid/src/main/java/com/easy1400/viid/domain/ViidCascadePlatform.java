package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 级联信息表
 * @TableName viid_cascade_platform
 */
@TableName(value ="viid_cascade_platform")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViidCascadePlatform implements Serializable {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private String id;

    /**
     * 平台ID
     */
    @JsonProperty("SystemID")
    @TableField(value = "SystemID")
    private String SystemID;

    /**
     * 平台名称
     */
    @JsonProperty("Name")
    @TableField(value = "Name")
    private String Name;

    /**
     * IP地址
     */
    @JsonProperty("IPAddr")
    @TableField(value = "IPAddr")
    private String IPAddr;

    /**
     * 端口
     */
    @JsonProperty("Port")
    @TableField(value = "Port")
    private String Port;

    /**
     * 是否在线
     */
    @JsonProperty("IsOnline")
    @TableField(value = "IsOnline")
    private String IsOnline;

    /**
     * 最后在线时间
     */
    @JsonProperty("LastOnlineTime")
    @TableField(value = "LastOnlineTime")
    private Date LastOnlineTime;

    /**
     * 级联平台类型（0上级 1下级 2本级）
     */
    @JsonProperty("Type")
    @TableField(value = "Type")
    private String Type;

    /**
     * 用户ID
     */
    @JsonProperty("UserId")
    @TableField(value = "UserId")
    private String UserId;

    /**
     * 密码
     */
    @JsonProperty("Password")
    @TableField(value = "Password")
    private String Password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}