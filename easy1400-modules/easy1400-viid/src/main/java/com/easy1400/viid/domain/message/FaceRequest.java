package com.easy1400.viid.domain.message;

import com.easy1400.viid.domain.ViidFace;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName FaceRequest
 * @Author CH
 * @Date 2023/9/5 10:18
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class FaceRequest
{
    @JsonProperty("FaceListObject")
    private FaceListObjectDTO faceListObject;

    @NoArgsConstructor
    @Data
    public static class FaceListObjectDTO {
        @JsonProperty("FaceObject")
        private List<ViidFace> faceObject;

    }
}
