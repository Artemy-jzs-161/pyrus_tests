package models.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponseModel {
    String access_token;
    @JsonProperty("api_url")
    String apiUrl;
    @JsonProperty("files_url")
    String filesUrl;
}
