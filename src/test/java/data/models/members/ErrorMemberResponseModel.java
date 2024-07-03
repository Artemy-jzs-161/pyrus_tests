package data.models.members;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMemberResponseModel {
    private String error;
    @JsonProperty("error_code")
    private String errorCode;

}
