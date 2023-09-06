package com.easy1400.viid.domain.message;

import com.easy1400.viid.domain.ViidFace;
import com.easy1400.viid.domain.ViidMotorVehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName MotorVehicleRequest
 * @Author CH
 * @Date 2023/9/5 10:18
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class MotorVehicleRequest
{
    @JsonProperty("MotorVehicleListObject")
    private MotorVehicleListObjectDTO MotorVehicleListObject;

    @NoArgsConstructor
    @Data
    public static class MotorVehicleListObjectDTO {
        @JsonProperty("MotorVehicleObject")
        private List<ViidMotorVehicle> MotorVehicleObject;

    }
}
