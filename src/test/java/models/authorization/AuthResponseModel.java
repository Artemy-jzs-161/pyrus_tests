package models.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponseModel {
   String access_token;
   String api_url;
   String files_url;




}
