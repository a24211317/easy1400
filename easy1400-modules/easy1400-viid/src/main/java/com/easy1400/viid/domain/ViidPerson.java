package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class ViidPerson {
    /**
     * 人员标识
     */
    @JsonProperty("PersonID")
    @TableField(value = "PersonID")
    private String PersonID;
    /**
     * 信息分类
     */
    @JsonProperty("InfoKind")
    @TableField(value = "InfoKind")
    private String InfoKind;
    /**
     * 来源标识
     */
    @JsonProperty("SourceID")
    @TableField(value = "SourceID")
    private String SourceID;
    /**
     * 设备编码
     */
    @JsonProperty("DeviceID")
    @TableField(value = "DeviceID")
    private String DeviceID;
    /**
     * 左上角X坐标
     */
    @JsonProperty("LeftTopX")
    @TableField(value = "LeftTopX")
    private String LeftTopX;
    /**
     * 左上角Y坐标
     */
    @JsonProperty("LeftTopY")
    @TableField(value = "LeftTopY")
    private String LeftTopY;
    /**
     * 右下角X坐标
     */
    @JsonProperty("RightBtmX")
    @TableField(value = "RightBtmX")
    private String RightBtmX;
    /**
     * 右下角Y坐标
     */
    @JsonProperty("RightBtmY")
    @TableField(value = "RightBtmY")
    private String RightBtmY;
    /**
     * 位置标记时间
     */
    @JsonProperty("LocationMarkTime")
    @TableField(value = "LocationMarkTime")
    private String LocationMarkTime;
    /**
     * 人员出现时间
     */
    @JsonProperty("PersonAppearTime")
    @TableField(value = "PersonAppearTime")
    private String PersonAppearTime;
    /**
     * 人员消失时间
     */
    @JsonProperty("PersonDisAppearTime")
    @TableField(value = "PersonDisAppearTime")
    private String PersonDisAppearTime;

    /**
     * 证件种类
     */
    @JsonProperty("IDType")
    @TableField(value = "IDType")
    private String IDType;

    /**
     * 证件号码
     */
    @JsonProperty("IDNumber")
    @TableField(value = "IDNumber")
    private String IDNumber;

    /**
     * 姓名
     */
    @JsonProperty("Name")
    @TableField(value = "Name")
    private String Name;

    /**
     * 曾用名
     */
    @JsonProperty("UsedName")
    @TableField(value = "UsedName")
    private String UsedName;

    /**
     * 绰号
     */
    @JsonProperty("Alias")
    @TableField(value = "Alias")
    private String Alias;

    /**
     * 性别代码
     */
    @JsonProperty("GenderCode")
    @TableField(value = "GenderCode")
    private String GenderCode;

    /**
     * 年龄上限
     */
    @JsonProperty("AgeUpLimit")
    @TableField(value = "AgeUpLimit")
    private String AgeUpLimit;

    /**
     * 年龄下限
     */
    @JsonProperty("AgeLowerLimit")
    @TableField(value = "AgeLowerLimit")
    private String AgeLowerLimit;

    /**
     * 民族代码
     */
    @JsonProperty("EthicCode")
    @TableField(value = "EthicCode")
    private String EthicCode;

    /**
     * 国籍代码
     */
    @JsonProperty("NationalityCode")
    @TableField(value = "NationalityCode")
    private String NationalityCode;

    /**
     * 籍贯省市县代码
     */
    @JsonProperty("NativeCityCode")
    @TableField(value = "NativeCityCode")
    private String NativeCityCode;

    /**
     * 居住地
     * 行政区划
     */
    @JsonProperty("ResidenceAdminDivision")
    @TableField(value = "ResidenceAdminDivision")
    private String ResidenceAdminDivision;

    /**
     * 汉语口音代码
     */
    @JsonProperty("ChineseAccentCode")
    @TableField(value = "ChineseAccentCode")
    private String ChineseAccentCode;
    /**
     * 单位名称
     */
    @JsonProperty("PersonOrg")
    @TableField(value = "PersonOrg")
    private String PersonOrg;

    /**
     * 职业类别代码
     */
    @JsonProperty("JobCategory")
    @TableField(value = "JobCategory")
    private String JobCategory;

    /**
     * 同行人数
     */
    @JsonProperty("AccompanyNumber")
    @TableField(value = "AccompanyNumber")
    private String AccompanyNumber;
    /**
     * 身高上限
     */
    @JsonProperty("HeightUpLimit")
    @TableField(value = "HeightUpLimit")
    private String HeightUpLimit;
    /**
     * 身高下限
     */
    @JsonProperty("HeightLowerLimit")
    @TableField(value = "HeightLowerLimit")
    private String HeightLowerLimit;


    /**
     * 体型
     */
    @JsonProperty("BodyType")
    @TableField(value = "BodyType")
    private String BodyType;

    /**
     * 肤色
     */
    @JsonProperty("SkinColor")
    @TableField(value = "SkinColor")
    private String SkinColor;

    /**
     * 发型
     */
    @JsonProperty("HairStyle")
    @TableField(value = "HairStyle")
    private String HairStyle;

    /**
     * 发色
     */
    @JsonProperty("HairColor")
    @TableField(value = "HairColor")
    private String HairColor;

    /**
     * 姿态
     */
    @JsonProperty("Gesture")
    @TableField(value = "Gesture")
    private String Gesture;
    /**
     * 状态
     */
    @JsonProperty("Status")
    @TableField(value = "Status")
    private String Status;
    /**
     * 脸型
     */
    @JsonProperty("FaceStyle")
    @TableField(value = "FaceStyle")
    private String FaceStyle;

    /**
     * 脸部特征
     */
    @JsonProperty("FacialFeature")
    @TableField(value = "FacialFeature")
    private String FacialFeature;

    /**
     * 体貌特征
     */
    @JsonProperty("PhysicalFeature")
    @TableField(value = "PhysicalFeature")
    private String PhysicalFeature;
    /**
     * 体表特征
     */
    @JsonProperty("BodyFeature")
    @TableField(value = "BodyFeature")
    private String BodyFeature;
    /**
     * 习惯动作
     */
    @JsonProperty("HabitualMovement")
    @TableField(value = "HabitualMovement")
    private String HabitualMovement;
    /**
     * 行为
     */
    @JsonProperty("Behavior")
    @TableField(value = "Behavior")
    private String Behavior;
    /**
     * 行为描述
     */
    @JsonProperty("BehaviorDescription")
    @TableField(value = "BehaviorDescription")
    private String BehaviorDescription;
    /**
     * 附属物
     */
    @JsonProperty("Appendant")
    @TableField(value = "Appendant")
    private String Appendant;
    /**
     * 附属物描述
     */
    @JsonProperty("AppendantDescription")
    @TableField(value = "AppendantDescription")
    private String AppendantDescription;
    /**
     * 伞颜色
     */
    @JsonProperty("UmbrellaColor")
    @TableField(value = "UmbrellaColor")
    private String UmbrellaColor;

    /**
     * 口罩颜色
     */
    @JsonProperty("RespiratorColor")
    @TableField(value = "RespiratorColor")
    private String RespiratorColor;

    /**
     * 帽子款式
     */
    @JsonProperty("CapStyle")
    @TableField(value = "CapStyle")
    private String CapStyle;

    /**
     * 帽子颜色
     */
    @JsonProperty("CapColor")
    @TableField(value = "CapColor")
    private String CapColor;

    /**
     * 眼镜款式
     */
    @JsonProperty("GlassStyle")
    @TableField(value = "GlassStyle")
    private String GlassStyle;

    /**
     * 眼镜颜色
     */
    @JsonProperty("GlassColor")
    @TableField(value = "GlassColor")
    private String GlassColor;
    /**
     * 围巾颜色
     */
    @JsonProperty("ScarfColor")
    @TableField(value = "ScarfColor")
    private String ScarfColor;
    /**
     * 包款式
     */
    @JsonProperty("BagStyle")
    @TableField(value = "BagStyle")
    private String BagStyle;
    /**
     * 包颜色
     */
    @JsonProperty("BagColor")
    @TableField(value = "BagColor")
    private String BagColor;
    /**
     * 上衣款式
     */
    @JsonProperty("CoatStyle")
    @TableField(value = "CoatStyle")
    private String CoatStyle;
    /**
     * 上衣长度
     */
    @JsonProperty("CoatLength")
    @TableField(value = "CoatLength")
    private String CoatLength;
    /**
     * 上衣颜色
     */
    @JsonProperty("CoatColor")
    @TableField(value = "CoatColor")
    private String CoatColor;
    /**
     * 裤子款式
     */
    @JsonProperty("TrousersStyle")
    @TableField(value = "TrousersStyle")
    private String TrousersStyle;
    /**
     * 裤子颜色
     */
    @JsonProperty("TrousersColor")
    @TableField(value = "TrousersColor")
    private String TrousersColor;
    /**
     * 裤子长度
     */
    @JsonProperty("TrousersLen")
    @TableField(value = "TrousersLen")
    private String TrousersLen;
    /**
     * 鞋子款式
     */
    @JsonProperty("ShoesStyle")
    @TableField(value = "ShoesStyle")
    private String ShoesStyle;
    /**
     * 鞋子颜色
     */
    @JsonProperty("ShoesColor")
    @TableField(value = "ShoesColor")
    private String ShoesColor;

    /**
     * 是否驾驶员
     */
    @JsonProperty("IsDriver")
    @TableField(value = "IsDriver")
    private String IsDriver;

    /**
     * 是否涉外人员
     */
    @JsonProperty("IsForeigner")
    @TableField(value = "IsForeigner")
    private String IsForeigner;

    /**
     * 护照证件种类
     */
    @JsonProperty("PassportType")
    @TableField(value = "PassportType")
    private String PassportType;

    /**
     * 出入境人员类别
     * 代码
     */
    @JsonProperty("ImmigrantTypeCode")
    @TableField(value = "ImmigrantTypeCode")
    private String ImmigrantTypeCode;

    /**
     * 是否涉恐人员
     */
    @JsonProperty("IsSuspectedTerrorist")
    @TableField(value = "IsSuspectedTerrorist")
    private String IsSuspectedTerrorist;

    /**
     * 涉恐人员编号
     */
    @JsonProperty("SuspectedTerroristNumber")
    @TableField(value = "SuspectedTerroristNumber")
    private String SuspectedTerroristNumber;

    /**
     * 是否涉案人员
     */
    @JsonProperty("IsCriminalInvolved")
    @TableField(value = "IsCriminalInvolved")
    private String IsCriminalInvolved;

    /**
     * 涉案人员专长代
     * 码
     */
    @JsonProperty("CriminalInvolvedSpecilisationCode")
    @TableField(value = "CriminalInvolvedSpecilisationCode")
    private String CriminalInvolvedSpecilisationCode;

    /**
     * 体表特殊标记
     */
    @JsonProperty("BodySpeciallMark")
    @TableField(value = "BodySpeciallMark")
    private String BodySpeciallMark;

    /**
     * 作案手段
     */
    @JsonProperty("CrimeMethod")
    @TableField(value = "CrimeMethod")
    private String CrimeMethod;

    /**
     * 作案特点代码
     */
    @JsonProperty("CrimeCharacterCode")
    @TableField(value = "CrimeCharacterCode")
    private String CrimeCharacterCode;

    /**
     * 在逃人员编号
     */
    @JsonProperty("EscapedCriminalNumber")
    @TableField(value = "EscapedCriminalNumber")
    private String EscapedCriminalNumber;

    /**
     * 是否在押人员
     */
    @JsonProperty("IsDetainees")
    @TableField(value = "IsDetainees")
    private String IsDetainees;

    /**
     * 看守所编码
     */
    @JsonProperty("DetentionHouseCode")
    @TableField(value = "DetentionHouseCode")
    private String DetentionHouseCode;

    /**
     * 在押人员身份
     */
    @JsonProperty("DetaineesIdentity")
    @TableField(value = "DetaineesIdentity")
    private String DetaineesIdentity;

    /**
     * 在押人员特殊身
     * 份
     */
    @JsonProperty("DetaineesSpecialIdentity")
    @TableField(value = "DetaineesSpecialIdentity")
    private String DetaineesSpecialIdentity;

    /**
     * 成员类型代码
     */
    @JsonProperty("MemberTypeCode")
    @TableField(value = "MemberTypeCode")
    private String MemberTypeCode;

    /**
     * 是否被害人
     */
    @JsonProperty("IsVictim")
    @TableField(value = "IsVictim")
    private String IsVictim;

    /**
     * 被害人种类
     */
    @JsonProperty("VictimType")
    @TableField(value = "VictimType")
    private String VictimType;

    /**
     * 受伤害程度
     */
    @JsonProperty("InjuredDegree")
    @TableField(value = "InjuredDegree")
    private String InjuredDegree;

    /**
     * 尸体状况代码
     */
    @JsonProperty("CorpseConditionCode")
    @TableField(value = "CorpseConditionCode")
    private String CorpseConditionCode;

    /**
     * 是否可疑人
     */
    @JsonProperty("IsSuspiciousPerson")
    @TableField(value = "IsSuspiciousPerson")
    private String IsSuspiciousPerson;


    /**
     * 图像列表
     */
    @JsonProperty("SubImageList")
    @TableField(value = "SubImageList", typeHandler = SubImageListTypeHandler.class, jdbcType = JdbcType.VARCHAR)
    SubImageListDTO SubImageList;
}
