package com.easy1400.viid.domain.message;

import com.easy1400.viid.domain.ViidPerson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PersonRequest
 * @Author CH
 * @Date 2023/9/5 10:18
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class PersonRequest
{
    @JsonProperty("PersonListObject")
    private PersonListObjectDTO PersonListObject;

    @NoArgsConstructor
    @Data
    public static class PersonListObjectDTO {
        @JsonProperty("PersonObject")
        private List<ViidPerson> PersonObject;

    }
}
