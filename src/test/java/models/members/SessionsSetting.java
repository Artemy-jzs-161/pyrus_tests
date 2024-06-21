package models.members;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SessionsSetting {
    @JsonProperty("life_span_hours")
    private int lifeSpanHours;
}
