package com.easy1400.viid.domain.message;

import com.easy1400.viid.domain.ViidNonMotorVehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName NonMotorVehicleRequest
 * @Author CH
 * @Date 2023/9/5 10:18
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class NonMotorVehicleRequest {
    @JsonProperty("NonMotorVehicleListObject")
    private NonMotorVehicleListObjectDTO NonMotorVehicleListObject;

    @NoArgsConstructor
    @Data
    public static class NonMotorVehicleListObjectDTO {
        @JsonProperty("NonMotorVehicleObject")
        private List<ViidNonMotorVehicle> NonMotorVehicleObject;

    }
}
