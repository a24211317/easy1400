package com.easy1400.viid.domain.message;

import com.easy1400.viid.domain.dto.SubImageListDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @ClassName FaceRequest
 * @Author CH
 * @Date 2023/9/5 10:18
 * @Version 1.0
 */
@lombok.NoArgsConstructor
@lombok.Data
public class FaceRequest
{
    @JsonProperty("FaceListObject")
    private FaceListObjectDTO faceListObject;

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class FaceListObjectDTO {
        @JsonProperty("FaceObject")
        private List<FaceObjectDTO> faceObject;

        @lombok.NoArgsConstructor
        @lombok.Data
        public static class FaceObjectDTO {
            @JsonProperty("AgeLowerLimit")
            private Integer ageLowerLimit;
            @JsonProperty("AgeUpLimit")
            private Integer ageUpLimit;
            @JsonProperty("DeviceID")
            private String deviceID;
            @JsonProperty("FaceID")
            private String faceID;
            @JsonProperty("GenderCode")
            private String genderCode;
            @JsonProperty("InfoKind")
            private Integer infoKind;
            @JsonProperty("IsCriminalInvolved")
            private Integer isCriminalInvolved;
            @JsonProperty("IsDetainees")
            private Integer isDetainees;
            @JsonProperty("IsDriver")
            private Integer isDriver;
            @JsonProperty("IsForeigner")
            private Integer isForeigner;
            @JsonProperty("IsSuspectedTerrorist")
            private Integer isSuspectedTerrorist;
            @JsonProperty("IsSuspiciousPerson")
            private Integer isSuspiciousPerson;
            @JsonProperty("IsVictim")
            private Integer isVictim;
            @JsonProperty("LeftTopX")
            private Integer leftTopX;
            @JsonProperty("LeftTopY")
            private Integer leftTopY;
            @JsonProperty("RightBtmX")
            private Integer rightBtmX;
            @JsonProperty("RightBtmY")
            private Integer rightBtmY;
            @JsonProperty("SourceID")
            private String sourceID;
            @JsonProperty("SubImageList")
            private SubImageListDTO subImageList;

        }
    }
}
