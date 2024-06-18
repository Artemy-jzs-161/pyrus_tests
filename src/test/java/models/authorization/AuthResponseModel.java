package models.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponseModel {
   private String access_token;
   private String api_url;
   private String files_url;

   public AuthResponseModel(AuthRequestModel authRequestModel) {
   }
}
