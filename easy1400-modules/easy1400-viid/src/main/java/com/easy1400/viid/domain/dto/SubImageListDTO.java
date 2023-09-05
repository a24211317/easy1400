package com.easy1400.viid.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @ClassName SubImageListDTO
 * @Author CH
 * @Date 2023/9/5 11:28
 * @Version 1.0
 */

@lombok.NoArgsConstructor
@lombok.Data
public  class SubImageListDTO {
    @JsonProperty("SubImageInfoObject")
    private List<SubImageInfoObjectDTO> subImageInfoObject;

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class SubImageInfoObjectDTO {
        @JsonProperty("Data")
        private String data;
        @JsonProperty("DeviceID")
        private String deviceID;
        @JsonProperty("EventSort")
        private Integer eventSort;
        @JsonProperty("FileFormat")
        private String fileFormat;
        @JsonProperty("Height")
        private Integer height;
        @JsonProperty("ImageID")
        private String imageID;
        @JsonProperty("ShotTime")
        private String shotTime;
        @JsonProperty("StoragePath")
        private String storagePath;
        @JsonProperty("Type")
        private String type;
        @JsonProperty("Width")
        private Integer width;
    }
}
