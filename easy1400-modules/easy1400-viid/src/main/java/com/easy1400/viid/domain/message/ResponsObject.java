package com.easy1400.viid.domain.message;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.easy1400.viid.domain.enums.ResponsStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ResponsObject
 * @Author CH
 * @Date 2023/9/5 16:26
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class ResponsObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("ResponseStatusListObject")
    private ResponseStatusListObjectDTO responseStatusListObject;

    public ResponsObject(ResponsStatusEnum responsStatusEnum) {
        ResponseStatusListObjectDTO.ResponseStatusObjectDTO responseStatusObjectDTO = new ResponseStatusListObjectDTO.ResponseStatusObjectDTO();
        responseStatusObjectDTO.setStatusCode(responsStatusEnum.getCode());
        responseStatusObjectDTO.setStatusString(responsStatusEnum.getStatus());
        responseStatusObjectDTO.setLocalTime(DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_FORMAT));
        List<ResponseStatusListObjectDTO.ResponseStatusObjectDTO> responseStatusObject = new ArrayList<>();
        responseStatusObject.add(responseStatusObjectDTO);
        this.responseStatusListObject = new ResponseStatusListObjectDTO();
        responseStatusListObject.setResponseStatusObject(responseStatusObject);
    }

    public ResponsObject(ResponsStatusEnum responsStatusEnum, String id, String requestURL) {
        ResponseStatusListObjectDTO.ResponseStatusObjectDTO responseStatusObjectDTO = new ResponseStatusListObjectDTO.ResponseStatusObjectDTO();
        responseStatusObjectDTO.setStatusCode(responsStatusEnum.getCode());
        responseStatusObjectDTO.setStatusString(responsStatusEnum.getStatus());
        responseStatusObjectDTO.setLocalTime(DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_FORMAT));
        responseStatusObjectDTO.setId(id);
        responseStatusObjectDTO.setRequestURL(requestURL);
        List<ResponseStatusListObjectDTO.ResponseStatusObjectDTO> responseStatusObject = new ArrayList<>();
        responseStatusObject.add(responseStatusObjectDTO);
        this.responseStatusListObject = new ResponseStatusListObjectDTO();
        responseStatusListObject.setResponseStatusObject(responseStatusObject);
    }

    @NoArgsConstructor
    @Data
    public static class ResponseStatusListObjectDTO {
        @JsonProperty("ResponseStatusObject")
        private List<ResponseStatusObjectDTO> responseStatusObject;

        @NoArgsConstructor
        @Data
        public static class ResponseStatusObjectDTO {
            @JsonProperty("StatusString")
            private String statusString;
            @JsonProperty("StatusCode")
            private Integer statusCode;
            @JsonProperty("RequestURL")
            private String requestURL;
            @JsonProperty("Id")
            private String id;
            @JsonProperty("LocalTime")
            private String LocalTime;
        }
    }
}
