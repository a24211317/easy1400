package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName viid_subscribe
 */
@TableName(value ="viid_subscribe")
public class ViidSubscribe implements Serializable {
    /**
     * 订阅标识符
     */
    @TableId(value = "SubscribeID")
    private String SubscribeID;

    /**
     * 订阅的主题和目标
     */
    @TableField(value = "Title")
    private String Title;

    /**
     * 订阅类别
     */
    @TableField(value = "SubscribeDetail")
    private String SubscribeDetail;

    /**
     * 订阅资源路径
     */
    @TableField(value = "ResourceURI")
    private String ResourceURI;

    /**
     * 申请人
     */
    @TableField(value = "ApplicantName")
    private String ApplicantName;

    /**
     * 申请单位
     */
    @TableField(value = "ApplicantOrg")
    private String ApplicantOrg;

    /**
     * 开始时间
     */
    @TableField(value = "BeginTime")
    private Date BeginTime;

    /**
     * 结束时间
     */
    @TableField(value = "EndTime")
    private Date EndTime;

    /**
     * 信息接收地址
     */
    @TableField(value = "ReceiveAddr")
    private String ReceiveAddr;

    /**
     * 信息上报间隔时间
     */
    @TableField(value = "ReportInterval")
    private Integer ReportInterval;

    /**
     * 理由
     */
    @TableField(value = "Reason")
    private String Reason;

    /**
     * 操作类型
     */
    @TableField(value = "OperateType")
    private String OperateType;

    /**
     * 订阅执行状态
     */
    @TableField(value = "SubscribeStatus")
    private String SubscribeStatus;

    /**
     * 订阅取消单位
     */
    @TableField(value = "SubscribeCancOrg")
    private String SubscribeCancOrg;

    /**
     * 订阅取消人
     */
    @TableField(value = "SubscribeCancelPerson")
    private String SubscribeCancelPerson;

    /**
     * 取消时间
     */
    @TableField(value = "CancelTime")
    private Date CancelTime;

    /**
     * 取消原因
     */
    @TableField(value = "CancelReason")
    private String CancelReason;

    /**
     * 0 订阅上级 1被订阅
     */
    @TableField(value = "SubscribeType")
    private String SubscribeType;

    /**
     * 审批状态
     */
    @TableField(value = "ApprovalStatus")
    private String ApprovalStatus;

    /**
     * 审批人
     */
    @TableField(value = "ApprovalUser")
    private String ApprovalUser;

    /**
     * 审批时间
     */
    @TableField(value = "ApprovalTime")
    private Date ApprovalTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public ViidSubscribe() {
    }

    public ViidSubscribe(String subscribeID, String title, String subscribeDetail, String resourceURI, String applicantName, String applicantOrg, Date beginTime, Date endTime, String receiveAddr, Integer reportInterval, String reason, String operateType, String subscribeStatus, String subscribeCancOrg, String subscribeCancelPerson, Date cancelTime, String cancelReason, String subscribeType, String approvalStatus, String approvalUser, Date approvalTime) {
        SubscribeID = subscribeID;
        Title = title;
        SubscribeDetail = subscribeDetail;
        ResourceURI = resourceURI;
        ApplicantName = applicantName;
        ApplicantOrg = applicantOrg;
        BeginTime = beginTime;
        EndTime = endTime;
        ReceiveAddr = receiveAddr;
        ReportInterval = reportInterval;
        Reason = reason;
        OperateType = operateType;
        SubscribeStatus = subscribeStatus;
        SubscribeCancOrg = subscribeCancOrg;
        SubscribeCancelPerson = subscribeCancelPerson;
        CancelTime = cancelTime;
        CancelReason = cancelReason;
        SubscribeType = subscribeType;
        ApprovalStatus = approvalStatus;
        ApprovalUser = approvalUser;
        ApprovalTime = approvalTime;
    }

    public String getSubscribeID() {
        return SubscribeID;
    }

    public void setSubscribeID(String subscribeID) {
        SubscribeID = subscribeID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubscribeDetail() {
        return SubscribeDetail;
    }

    public void setSubscribeDetail(String subscribeDetail) {
        SubscribeDetail = subscribeDetail;
    }

    public String getResourceURI() {
        return ResourceURI;
    }

    public void setResourceURI(String resourceURI) {
        ResourceURI = resourceURI;
    }

    public String getApplicantName() {
        return ApplicantName;
    }

    public void setApplicantName(String applicantName) {
        ApplicantName = applicantName;
    }

    public String getApplicantOrg() {
        return ApplicantOrg;
    }

    public void setApplicantOrg(String applicantOrg) {
        ApplicantOrg = applicantOrg;
    }

    public Date getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(Date beginTime) {
        BeginTime = beginTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public String getReceiveAddr() {
        return ReceiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        ReceiveAddr = receiveAddr;
    }

    public Integer getReportInterval() {
        return ReportInterval;
    }

    public void setReportInterval(Integer reportInterval) {
        ReportInterval = reportInterval;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getOperateType() {
        return OperateType;
    }

    public void setOperateType(String operateType) {
        OperateType = operateType;
    }

    public String getSubscribeStatus() {
        return SubscribeStatus;
    }

    public void setSubscribeStatus(String subscribeStatus) {
        SubscribeStatus = subscribeStatus;
    }

    public String getSubscribeCancOrg() {
        return SubscribeCancOrg;
    }

    public void setSubscribeCancOrg(String subscribeCancOrg) {
        SubscribeCancOrg = subscribeCancOrg;
    }

    public String getSubscribeCancelPerson() {
        return SubscribeCancelPerson;
    }

    public void setSubscribeCancelPerson(String subscribeCancelPerson) {
        SubscribeCancelPerson = subscribeCancelPerson;
    }

    public Date getCancelTime() {
        return CancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        CancelTime = cancelTime;
    }

    public String getCancelReason() {
        return CancelReason;
    }

    public void setCancelReason(String cancelReason) {
        CancelReason = cancelReason;
    }

    public String getSubscribeType() {
        return SubscribeType;
    }

    public void setSubscribeType(String subscribeType) {
        SubscribeType = subscribeType;
    }

    public String getApprovalStatus() {
        return ApprovalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        ApprovalStatus = approvalStatus;
    }

    public String getApprovalUser() {
        return ApprovalUser;
    }

    public void setApprovalUser(String approvalUser) {
        ApprovalUser = approvalUser;
    }

    public Date getApprovalTime() {
        return ApprovalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        ApprovalTime = approvalTime;
    }
}