package com.easy1400.viid.domain.message;

import com.easy1400.viid.domain.ViidApe;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName ApeRequest
 * @Author CH
 * @Date 2023/10/11 10:53
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class ApeRequest {

    @JsonProperty("APEListObject")
    private APEListObjectDTO aPEListObject;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class APEListObjectDTO {
        @JsonProperty("APEObject")
        private List<ViidApe> aPEObject;
    }
}
