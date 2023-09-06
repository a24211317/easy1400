package com.easy1400.viid.domain.enums;

import cn.hutool.json.XML;

/**
 * @ClassName ResponsStatus
 * @Author CH
 * 以附录 B 中类型定义 为准
 * @Date 2023/9/5 16:30
 * @Version 1.0
 */
public enum ResponsStatusEnum {

    /**
     * 正常
     */
    OK(0, "正常"),
    /**
     * 其他未知错误
     */
    Other_Error(1, "其他未知错误"),
    /**
     * 设备忙
     */
    Device_Busy(2, "设备忙"),
    /**
     * 设备错
     */
    Device_Error(3, "设备错"),
    /**
     * 无效操作
     */
    Invalid_Operation(4, "无效操作"),
    /**
     * XML 格式无效
     */
    Invalid_XML_Format(5, "XML 格式无效"),
    /**
     * XML 内容无效
     */
    Invalid_XML_Content(6, "XML 内容无效"),
    /**
     * JSON 格式无效
     */
    Invalid_JSON_Format(7, "JSON 格式无效"),
    /**
     * JSON 内容无效
     */
    Invalid_JSON_Content(8, "JSON 内容无效"),
    /**
     * 系统重启中
     */
    Reboot(9, "系统重启中");

    private final String status;
    private final Integer code;



    ResponsStatusEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public Integer getCode() {
        return code;
    }
}
