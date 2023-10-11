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
    private SubscribeNotificationListObjectDTO subscribeNotificationListObject;

    @NoArgsConstructor
    @Data
    public static class SubscribeNotificationListObjectDTO {
        @JsonProperty("SubscribeNotificationObject")
        private List<SubscribeNotificationObjectDTO> subscribeNotificationObject;

        @NoArgsConstructor
        @Data
        public static class SubscribeNotificationObjectDTO {
            @JsonProperty("NotificationID")
            private String notificationID;
            @JsonProperty("SubscribeID")
            private String subscribeID;
            @JsonProperty("MotorVehicleObjectList")
            private MotorVehicleObjectListDTO motorVehicleObjectList;
            @JsonProperty("PersonObjectList")
            private PersonObjectListDTO PersonObjectList;
            @JsonProperty("FaceObjectList")
            private FaceObjectListDTO FaceObjectList;
            @JsonProperty("NonMotorVehicleObjectList")
            private NonMotorVehicleObjectListDTO NonMotorVehicleObjectList;
            @JsonProperty("Title")
            private String title;
            @JsonProperty("TriggerTime")
            private String triggerTime;
            @JsonProperty("InfoIDs")
            private String infoIDs;

            @NoArgsConstructor
            @Data
            public static class MotorVehicleObjectListDTO {
                @JsonProperty("MotorVehicleObject")
                private List<ViidMotorVehicle> motorVehicleObject;
            }

            @NoArgsConstructor
            @Data
            public static class PersonObjectListDTO {
                @JsonProperty("PersonObject")
                private List<ViidPerson> personObject;
            }

            @NoArgsConstructor
            @Data
            public static class FaceObjectListDTO {
                @JsonProperty("FaceObject")
                private List<ViidFace> faceObject;
            }

            @NoArgsConstructor
            @Data
            public static class NonMotorVehicleObjectListDTO {
                @JsonProperty("NonMotorVehicleObject")
                private List<ViidNonMotorVehicle> nonMotorVehicleObject;
            }
        }
    }
}
