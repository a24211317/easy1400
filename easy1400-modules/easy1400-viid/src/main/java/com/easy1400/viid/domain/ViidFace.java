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
 * @ClassName FaceObject
 * @Author CH
 * @Date 2023/9/5 14:45
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(autoResultMap = true)
public class ViidFace {

    /**
     * 人脸标识
     */
    @JsonProperty("FaceID")
    @TableField(value = "FaceID")
    private String FaceID;

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
     * 设备编码
     */
    @JsonProperty("DeviceID")
    @TableField(value = "DeviceID")
    private String DeviceID;

    /**
     * 左上角 X 坐标
     */
    @JsonProperty("LeftTopX")
    @TableField(value = "LeftTopX")
    private int LeftTopX;

    /**
     * 左上角 Y 坐标
     */
    @JsonProperty("LeftTopY")
    @TableField(value = "LeftTopY")
    private int LeftTopY;

    /**
     * 右下角 X 坐标
     */
    @JsonProperty("RightBtmX")
    @TableField(value = "RightBtmX")
    private int RightBtmX;

    /**
     * 右下角 Y 坐标
     */
    @JsonProperty("RightBtmY")
    @TableField(value = "RightBtmY")
    private int RightBtmY;

    /**
     * 位置标记时间
     */
    @JsonProperty("LocationMarkTime")
    @TableField(value = "LocationMarkTime")
    private String LocationMarkTime;

    /**
     * 人脸出现时间
     */
    @JsonProperty("FaceAppearTime")
    @TableField(value = "FaceAppearTime")
    private String FaceAppearTime;

    /**
     * 人脸消失时间
     */
    @JsonProperty("FaceDisAppearTime")
    @TableField(value = "FaceDisAppearTime")
    private String FaceDisAppearTime;

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
    private int AgeUpLimit;

    /**
     * 年龄下限
     */
    @JsonProperty("AgeLowerLimit")
    @TableField(value = "AgeLowerLimit")
    private int AgeLowerLimit;

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
     * 职业类别代码
     */
    @JsonProperty("JobCategory")
    @TableField(value = "JobCategory")
    private String JobCategory;

    /**
     * 同行人脸数
     */
    @JsonProperty("AccompanyNumber")
    @TableField(value = "AccompanyNumber")
    private int AccompanyNumber;

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
     * 是否驾驶员
     */
    @JsonProperty("IsDriver")
    @TableField(value = "IsDriver")
    private int IsDriver;

    /**
     * 是否涉外人员
     */
    @JsonProperty("IsForeigner")
    @TableField(value = "IsForeigner")
    private int IsForeigner;

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
    private int IsSuspectedTerrorist;

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
    private int IsCriminalInvolved;

    /**
     * 涉案人员专长代码
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
    private int IsDetainees;

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
    private int IsVictim;

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
    private int IsSuspiciousPerson;

    /**
     * 姿态分布
     */
    @JsonProperty("Attitude")
    @TableField(value = "Attitude")
    private int Attitude;

    /**
     * 相似度
     */
    @JsonProperty("Similaritydegree")
    @TableField(value = "Similaritydegree")
    private double Similaritydegree;

    /**
     * 眉型
     */
    @JsonProperty("EyebrowStyle")
    @TableField(value = "EyebrowStyle")
    private String EyebrowStyle;

    /**
     * 鼻型
     */
    @JsonProperty("NoseStyle")
    @TableField(value = "NoseStyle")
    private String NoseStyle;

    /**
     * 胡型
     */
    @JsonProperty("MustacheStyle")
    @TableField(value = "MustacheStyle")
    private String MustacheStyle;

    /**
     * 嘴唇
     */
    @JsonProperty("LipStyle")
    @TableField(value = "LipStyle")
    private String LipStyle;

    /**
     * 皱纹眼袋
     */
    @JsonProperty("WrinklePouch")
    @TableField(value = "WrinklePouch")
    private String WrinklePouch;

    /**
     * 痤疮色斑
     */
    @JsonProperty("AcneStain")
    @TableField(value = "AcneStain")
    private String AcneStain;

    /**
     * 黑痣胎记
     */
    @JsonProperty("FreckleBirthmark")
    @TableField(value = "FreckleBirthmark")
    private String FreckleBirthmark;

    /**
     * 疤痕酒窝
     */
    @JsonProperty("ScarDimple")
    @TableField(value = "ScarDimple")
    private String ScarDimple;

    /**
     * 其他特征
     */
    @JsonProperty("OtherFeature")
    @TableField(value = "OtherFeature")
    private String OtherFeature;

    /**
     * 图像列表
     */
    @JsonProperty("SubImageList")
    @TableField(value = "SubImageList", typeHandler = SubImageListTypeHandler.class, jdbcType = JdbcType.VARCHAR)
    private SubImageListDTO SubImageList;

}
