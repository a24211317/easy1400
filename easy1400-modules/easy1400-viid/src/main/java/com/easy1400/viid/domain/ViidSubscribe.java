package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName viid_subscribe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "viid_subscribe")
public class ViidSubscribe implements Serializable {
    /**
     * 订阅标识符
     */
    @TableId(value = "SubscribeID")
    @JsonProperty("SubscribeID")
    private String SubscribeID;

    /**
     * 订阅的主题和目标
     */
    @TableField(value = "Title")
    @JsonProperty("Title")
    private String Title;

    /**
     * 订阅类别
     */
    @TableField(value = "SubscribeDetail")
    @JsonProperty("SubscribeDetail")
    private String SubscribeDetail;

    /**
     * 订阅资源路径
     */
    @TableField(value = "ResourceURI")
    @JsonProperty("ResourceURI")
    private String ResourceURI;

    /**
     * 申请人
     */
    @TableField(value = "ApplicantName")
    @JsonProperty("ApplicantName")
    private String ApplicantName;

    /**
     * 申请单位
     */
    @TableField(value = "ApplicantOrg")
    @JsonProperty("ApplicantOrg")
    private String ApplicantOrg;

    /**
     * 开始时间
     */
    @TableField(value = "BeginTime")
    @JsonProperty("BeginTime")
    @JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
    private String BeginTime;

    /**
     * 结束时间
     */
    @TableField(value = "EndTime")
    @JsonProperty("EndTime")
    @JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
    private String EndTime;

    /**
     * 信息接收地址
     */
    @TableField(value = "ReceiveAddr")
    @JsonProperty("ReceiveAddr")
    private String ReceiveAddr;

    /**
     * 信息上报间隔时间
     */
    @TableField(value = "ReportInterval")
    @JsonProperty("ReportInterval")
    private Integer ReportInterval;

    /**
     * 理由
     */
    @TableField(value = "Reason")
    @JsonProperty("Reason")
    private String Reason;

    /**
     * 操作类型
     */
    @TableField(value = "OperateType")
    @JsonProperty("OperateType")
    private String OperateType;

    /**
     * 订阅执行状态
     */
    @TableField(value = "SubscribeStatus")
    @JsonProperty("SubscribeStatus")
    private String SubscribeStatus;

    /**
     * 订阅取消单位
     */
    @TableField(value = "SubscribeCancOrg")
    @JsonProperty("SubscribeCancOrg")
    private String SubscribeCancOrg;

    /**
     * 订阅取消人
     */
    @TableField(value = "SubscribeCancelPerson")
    @JsonProperty("SubscribeCancelPerson")
    private String SubscribeCancelPerson;

    /**
     * 取消时间
     */
    @TableField(value = "CancelTime")
    @JsonProperty("CancelTime")
    private Date CancelTime;

    /**
     * 取消原因
     */
    @TableField(value = "CancelReason")
    @JsonProperty("CancelReason")
    private String CancelReason;

    /**
     * 0 订阅上级 1被订阅
     */
    @TableField(value = "SubscribeType")
    @JsonProperty("SubscribeType")
    private String SubscribeType;
    /**
     * 订阅资源类别
     * 订阅时必选， 指定订阅的 资源类别。
     * 0-卡口
     * 1-设备
     * 2-采集内容
     * 3-案件
     * 4-视图库
     * 5-行政区划
     */
    @TableField(value = "ResourceClass")
    @JsonProperty("ResourceClass")
    private String ResourceClass;

    /**
     * 审批状态
     */
    @TableField(value = "ApprovalStatus")
    @JsonProperty("ApprovalStatus")
    private String ApprovalStatus;

    /**
     * 审批人
     */
    @TableField(value = "ApprovalUser")
    @JsonProperty("ApprovalUser")
    private String ApprovalUser;

    /**
     * 审批时间
     */
    @TableField(value = "ApprovalTime")
    @JsonProperty("ApprovalTime")
    private Date ApprovalTime;

    /**
     * 返回结果图片约定
     * -1 不要图片
     * 其 他 取 值 参 照 GA/T 1400.3-2017 中 Imagetype的定义：
     * 01 车辆大图
     * 02 车牌彩色小图
     * 03 车牌二值化图
     * 04 驾驶员面部特征图
     * 05 副驾驶面部特征图
     * 06 车标
     * 07 违章合成图
     * 08 过车合成图
     * 09 车辆特写图
     * 10 人员图
     * 11 人脸图
     * 12 非机动车图
     * 13 物品图
     * 14 场景图
     * 100 一般图片
     */
    @TableField(value = "ResultImageDeclare")
    @JsonProperty("ResultImageDeclare")
    private String ResultImageDeclare;

    /**
     * 返回结果特征值约定
     * -1 不要特征值
     * 1 需要返回特征值
     */
    @TableField(value = "ResultFeatureDeclare")
    @JsonProperty("ResultFeatureDeclare")
    private String ResultFeatureDeclare;

    /**
     * 订阅分类标签标识
     */
    @TableField(value = "TabID")
    @JsonProperty("TabID")
    private String TabID;
    /**
     * 订阅发起方ID
     */
    @TableField(value = "SubscriberSendOrgID")
    @JsonProperty("SubscriberSendOrgID")
    private String SubscriberSendOrgID;
    /**
     * 被订阅方ID
     */
    @TableField(value = "SubscriberRecoverOrgID")
    @JsonProperty("SubscriberRecoverOrgID")
    private String SubscriberRecoverOrgID;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}