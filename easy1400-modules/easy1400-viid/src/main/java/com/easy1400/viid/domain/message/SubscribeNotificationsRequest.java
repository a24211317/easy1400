package com.easy1400.viid.domain.message;

import com.easy1400.viid.domain.ViidFace;
import com.easy1400.viid.domain.ViidMotorVehicle;
import com.easy1400.viid.domain.ViidNonMotorVehicle;
import com.easy1400.viid.domain.ViidPerson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName SubscribeNotificationsRequest
 * @Author CH
 * @Date 2023/10/11 14:39
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class SubscribeNotificationsRequest {

    @JsonProperty("SubscribeNotificationListObject")
    private SubscribeNotificationListObjectDTO SubscribeNotificationListObject;

    @NoArgsConstructor
    @Data
    public static class SubscribeNotificationListObjectDTO {
        @JsonProperty("SubscribeNotificationObject")
        private List<SubscribeNotificationObjectDTO> SubscribeNotificationObject;

        @NoArgsConstructor
        @Data
        public static class SubscribeNotificationObjectDTO {
            @JsonProperty("NotificationID")
            private String NotificationID;
            @JsonProperty("SubscribeID")
            private String SubscribeID;
            @JsonProperty("MotorVehicleObjectList")
            private MotorVehicleObjectListDTO MotorVehicleObjectList;
            @JsonProperty("PersonObjectList")
            private PersonObjectListDTO PersonObjectList;
            @JsonProperty("FaceObjectList")
            private FaceObjectListDTO FaceObjectList;
            @JsonProperty("NonMotorVehicleObjectList")
            private NonMotorVehicleObjectListDTO NonMotorVehicleObjectList;
            @JsonProperty("Title")
            private String Title;
            @JsonProperty("TriggerTime")
            private String TriggerTime;
            @JsonProperty("InfoIDs")
            private String InfoIDs;

            @NoArgsConstructor
            @Data
            public static class MotorVehicleObjectListDTO {
                @JsonProperty("MotorVehicleObject")
                private List<ViidMotorVehicle> MotorVehicleObject;
            }

            @NoArgsConstructor
            @Data
            public static class PersonObjectListDTO {
                @JsonProperty("PersonObject")
                private List<ViidPerson> PersonObject;
            }

            @NoArgsConstructor
            @Data
            public static class FaceObjectListDTO {
                @JsonProperty("FaceObject")
                private List<ViidFace> FaceObject;
            }

            @NoArgsConstructor
            @Data
            public static class NonMotorVehicleObjectListDTO {
                @JsonProperty("NonMotorVehicleObject")
                private List<ViidNonMotorVehicle> NonMotorVehicleObject;
            }
        }
    }
}
