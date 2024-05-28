package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.easy1400.viid.common.handler.SubImageListTypeHandler;
import com.easy1400.viid.domain.dto.SubImageListDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;

/**
 * @ClassName ViidMotorVehicle
 * @Author CH
 * @Date 2023/3/29 10:57
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(autoResultMap = true)
public class ViidMotorVehicle {
    /**
     * 车辆标识
     */
    @JsonProperty("MotorVehicleID")
    @TableField(value = "MotorVehicleID")
    private String MotorVehicleID;
    /**
     * 信息分类
     */
    @JsonProperty("InfoKind")
    @TableField(value = "InfoKind")
    private int InfoKind;
    /**
     * 来源标识
     */
    @JsonProperty("SourceID")
    @TableField(value = "SourceID")
    private String SourceID;
    /**
     * 关联卡口编号
     */
    @JsonProperty("TollgateID")
    @TableField(value = "TollgateID")
    private String TollgateID;
    /**
     * 设备编码
     */
    @JsonProperty("DeviceID")
    @TableField(value = "DeviceID")
    private String DeviceID;
    /**
     * 近景照片
     */
    @JsonProperty("StorageUrl1")
    @TableField(value = "StorageUrl1")
    private String StorageUrl1;
    /**
     * 车牌照片
     */
    @JsonProperty("StorageUrl2")
    @TableField(value = "StorageUrl2")
    private String StorageUrl2;
    /**
     * 远景照片
     */
    @JsonProperty("StorageUrl3")
    @TableField(value = "StorageUrl3")
    private String StorageUrl3;
    /**
     * 合成图
     */
    @JsonProperty("StorageUrl4")
    @TableField(value = "StorageUrl4")
    private String StorageUrl4;
    /**
     * 缩略图
     */
    @JsonProperty("StorageUrl5")
    @TableField(value = "StorageUrl5")
    private String StorageUrl5;
    /**
     * 左上角X坐标
     */
    @JsonProperty("LeftTopX")
    @TableField(value = "LeftTopX")
    private int LeftTopX;
    /**
     * 左上角Y坐标
     */
    @JsonProperty("LeftTopY")
    @TableField(value = "LeftTopY")
    private int LeftTopY;
    /**
     * 右下角X坐标
     */
    @JsonProperty("RightBtmX")
    @TableField(value = "RightBtmX")
    private int RightBtmX;
    /**
     * 右下角Y坐标
     */
    @JsonProperty("RightBtmY")
    @TableField(value = "RightBtmY")
    private int RightBtmY;
    /**
     * 位置标记时间
     */
    @JsonProperty("MarkTime")
    @TableField(value = "MarkTime")
    private String MarkTime;
    /**
     * 车辆出现时间
     */
    @JsonProperty("AppearTime")
    @TableField(value = "AppearTime")
    private String AppearTime;
    /**
     * 车辆消失时间
     */
    @JsonProperty("DisappearTime")
    @TableField(value = "DisappearTime")
    private String DisappearTime;
    /**
     * 车道号
     */
    @JsonProperty("LaneNo")
    @TableField(value = "LaneNo")
    private int LaneNo;
    /**
     * 有无车牌
     */
    @JsonProperty("HasPlate")
    @TableField(value = "HasPlate")
    private String HasPlate;
    /**
     * 号牌种类
     */
    @JsonProperty("PlateClass")
    @TableField(value = "PlateClass")
    private String PlateClass;
    /**
     * 车牌颜色
     */
    @JsonProperty("PlateColor")
    @TableField(value = "PlateColor")
    private String PlateColor;
    /**
     * 车牌号
     */
    @JsonProperty("PlateNo")
    @TableField(value = "PlateNo")
    private String PlateNo;
    /**
     * 挂车牌号
     */
    @JsonProperty("PlateNoAttach")
    @TableField(value = "PlateNoAttach")
    private String PlateNoAttach;
    /**
     * 车牌描述
     */
    @JsonProperty("PlateDescribe")
    @TableField(value = "PlateDescribe")
    private String PlateDescribe;
    /**
     * 是否套牌
     */
    @JsonProperty("IsDecked")
    @TableField(value = "IsDecked")
    private String IsDecked;
    /**
     * 是否涂改
     */
    @JsonProperty("IsAltered")
    @TableField(value = "IsAltered")
    private String IsAltered;
    /**
     * 是否遮挡
     */
    @JsonProperty("IsCovered")
    @TableField(value = "IsCovered")
    private String IsCovered;
    /**
     * 行驶速度
     */
    @JsonProperty("Speed")
    @TableField(value = "Speed")
    private String Speed;
    /**
     * 行驶方向
     */
    @JsonProperty("Direction")
    @TableField(value = "Direction")
    private String Direction;
    /**
     * 行驶状态代码
     */
    @JsonProperty("DrivingStatusCode")
    @TableField(value = "DrivingStatusCode")
    private String DrivingStatusCode;
    /**
     * 车辆使用性质代码
     */
    @JsonProperty("UsingPropertiesCode")
    @TableField(value = "UsingPropertiesCode")
    private String UsingPropertiesCode;
    /**
     * 车辆类型
     */
    @JsonProperty("VehicleClass")
    @TableField(value = "VehicleClass")
    private String VehicleClass;
    /**
     * 车辆品牌
     */
    @JsonProperty("VehicleBrand")
    @TableField(value = "VehicleBrand")
    private String VehicleBrand;
    /**
     * 车辆型号
     */
    @JsonProperty("VehicleModel")
    @TableField(value = "VehicleModel")
    private String VehicleModel;
    /**
     * 车辆年款
     */
    @JsonProperty("VehicleStyles")
    @TableField(value = "VehicleStyles")
    private String VehicleStyles;
    /**
     * 车辆长度
     */
    @JsonProperty("VehicleLength")
    @TableField(value = "VehicleLength")
    private String VehicleLength;
    /**
     * 车辆宽度
     */
    @JsonProperty("VehicleWidth")
    @TableField(value = "VehicleWidth")
    private String VehicleWidth;
    /**
     * 车辆高度
     */
    @JsonProperty("FaceVehicleHeightID")
    @TableField(value = "VehicleHeight")
    private String VehicleHeight;
    /**
     * 车身颜色
     */
    @JsonProperty("VehicleColor")
    @TableField(value = "VehicleColor")
    private String VehicleColor;
    /**
     * 颜色深浅
     */
    @JsonProperty("VehicleColorDepth")
    @TableField(value = "VehicleColorDepth")
    private String VehicleColorDepth;
    /**
     * 车前盖
     */
    @JsonProperty("VehicleHood")
    @TableField(value = "VehicleHood")
    private String VehicleHood;
    /**
     * 车后盖
     */
    @JsonProperty("VehicleTrunk")
    @TableField(value = "VehicleTrunk")
    private String VehicleTrunk;
    /**
     * 车轮
     */
    @JsonProperty("VehicleWheel")
    @TableField(value = "VehicleWheel")
    private String VehicleWheel;
    /**
     * 车轮印花纹
     */
    @JsonProperty("WheelPrintedPattern")
    @TableField(value = "WheelPrintedPattern")
    private String WheelPrintedPattern;
    /**
     * 车窗
     */
    @JsonProperty("VehicleWindow")
    @TableField(value = "VehicleWindow")
    private String VehicleWindow;
    /**
     * 车顶
     */
    @JsonProperty("VehicleRoof")
    @TableField(value = "VehicleRoof")
    private String VehicleRoof;
    /**
     * 车门
     */
    @JsonProperty("VehicleDoor")
    @TableField(value = "VehicleDoor")
    private String VehicleDoor;
    /**
     * 车侧
     */
    @JsonProperty("SideOfVehicle")
    @TableField(value = "SideOfVehicle")
    private String SideOfVehicle;
    /**
     * 车厢
     */
    @JsonProperty("CarOfVehicle")
    @TableField(value = "CarOfVehicle")
    private String CarOfVehicle;
    /**
     * 后视镜
     */
    @JsonProperty("RearviewMirror")
    @TableField(value = "RearviewMirror")
    private String RearviewMirror;
    /**
     * 底盘
     */
    @JsonProperty("VehicleChassis")
    @TableField(value = "VehicleChassis")
    private String VehicleChassis;
    /**
     * 遮挡
     */
    @JsonProperty("VehicleShielding")
    @TableField(value = "VehicleShielding")
    private String VehicleShielding;
    /**
     * 贴膜颜色
     */
    @JsonProperty("FilmColor")
    @TableField(value = "FilmColor")
    private String FilmColor;
    /**
     * 改装标志
     */
    @JsonProperty("IsModified")
    @TableField(value = "IsModified")
    private String IsModified;
    /**
     * 撞痕信息
     */
    @JsonProperty("HitMarkInfo")
    @TableField(value = "HitMarkInfo")
    private String HitMarkInfo;
    /**
     * 车身描述
     */
    @JsonProperty("VehicleBodyDesc")
    @TableField(value = "VehicleBodyDesc")
    private String VehicleBodyDesc;
    /**
     * 车前部物品
     */
    @JsonProperty("VehicleFrontItem")
    @TableField(value = "VehicleFrontItem")
    private String VehicleFrontItem;
    /**
     * 车前部物品描述
     */
    @JsonProperty("DescOfFrontItem")
    @TableField(value = "DescOfFrontItem")
    private String DescOfFrontItem;
    /**
     * 车后部物品
     */
    @JsonProperty("VehicleRearItem")
    @TableField(value = "VehicleRearItem")
    private String VehicleRearItem;
    /**
     * 车后部物品描述
     */
    @JsonProperty("DescOfRearItem")
    @TableField(value = "DescOfRearItem")
    private String DescOfRearItem;
    /**
     * 车内人数
     */
    @JsonProperty("NumOfPassenger")
    @TableField(value = "NumOfPassenger")
    private String NumOfPassenger;
    /**
     * 经过时刻
     */
    @JsonProperty("PassTime")
    @TableField(value = "PassTime")
    private String PassTime;
    /**
     * 经过道路名称
     */
    @JsonProperty("NameOfPassedRoad")
    @TableField(value = "NameOfPassedRoad")
    private String NameOfPassedRoad;
    /**
     * 是否可疑车
     */
    @JsonProperty("IsSuspicious")
    @TableField(value = "IsSuspicious")
    private String IsSuspicious;
    /**
     * 遮阳板状态
     */
    @JsonProperty("Sunvisor")
    @TableField(value = "Sunvisor")
    private int Sunvisor;
    /**
     * 安全带状态
     */
    @JsonProperty("SafetyBelt")
    @TableField(value = "SafetyBelt")
    private int SafetyBelt;
    /**
     * 打电话状态
     */
    @JsonProperty("Calling")
    @TableField(value = "Calling")
    private int Calling;
    /**
     * 号牌识别可信度
     */
    @JsonProperty("PlateReliability")
    @TableField(value = "PlateReliability")
    private String PlateReliability;
    /**
     * 每位号牌号码可信度
     */
    @JsonProperty("PlateCharReliability")
    @TableField(value = "PlateCharReliability")
    private String PlateCharReliability;
    /**
     * 品牌标志识别可信度
     */
    @JsonProperty("BrandReliability")
    @TableField(value = "BrandReliability")
    private String BrandReliability;
    /**
     * 图像列表
     */
    @JsonProperty("SubImageList")
    @TableField(value = "SubImageList", typeHandler = SubImageListTypeHandler.class, jdbcType = JdbcType.VARCHAR)
    private SubImageListDTO SubImageList;
}
