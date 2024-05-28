package com.easy1400.viid.domain.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName SubscribeRequest
 * @Author CH
 * @Date 2024/05/28 14:39
 * @Version 1.0
 */

@NoArgsConstructor
@Data
public class SubscribeRequest {

    @JsonProperty("SubscribeListObject")
    private SubscribeListObjectDTO subscribeListObject;

    @NoArgsConstructor
    @Data
    public static class SubscribeListObjectDTO {
        @JsonProperty("SubscribeObject")
        private List<SubscribeObjectDTO> subscribeObject;

        @NoArgsConstructor
        @Data
        public static class SubscribeObjectDTO {
            @JsonProperty("SubscribeID")
            private String subscribeID;
            @JsonProperty("Title")
            private String title;
            @JsonProperty("SubscribeDetail")
            private String subscribeDetail;
            @JsonProperty("ResourceURI")
            private String resourceURI;
            @JsonProperty("ApplicantName")
            private String applicantName;
            @JsonProperty("ApplicantOrg")
            private String applicantOrg;
            @JsonProperty("BeginTime")
            private String beginTime;
            @JsonProperty("EndTime")
            private String endTime;
            @JsonProperty("ReceiveAddr")
            private String receiveAddr;
            @JsonProperty("ReportInterval")
            private Integer reportInterval;
            @JsonProperty("Reason")
            private String reason;
            @JsonProperty("OperateType")
            private String operateType;
            @JsonProperty("SubscribeStatus")
            private String subscribeStatus;
            @JsonProperty("SubscribeCancelOrg")
            private String subscribeCancelOrg;
            @JsonProperty("SubscribeCancelPerson")
            private String subscribeCancelPerson;
            @JsonProperty("ResourceClass")
            private String resourceClass;
            @JsonProperty("ResultImageDeclare")
            private String resultImageDeclare;
            @JsonProperty("ResultFeatureDeclare")
            private String resultFeatureDeclare;
            @JsonProperty("CancelReason")
            private String cancelReason;
            @JsonProperty("CancelTime")
            private String cancelTime;
            @JsonProperty("TabID")
            private String tabID;
        }
    }
}
