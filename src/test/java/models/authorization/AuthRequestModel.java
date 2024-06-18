package models.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AuthRequestModel {
    private String login;
    private String security_key;
}
