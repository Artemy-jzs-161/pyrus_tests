package data.models.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequestModel {
    private String login;
    private String security_key;

    public AuthRequestModel(String login, String security_key) {
        this.login = login;
        this.security_key = security_key;
    }
}
