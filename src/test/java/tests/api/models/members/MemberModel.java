package tests.api.models.members;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberModel {
    private int id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String type;
    private String status;
    private boolean banned;
    private String position;
    private String skype;
    private String phone;
    @JsonProperty("department_id")
    private int departmentId;
    @JsonProperty("external_id")
    private String externalId;
}





