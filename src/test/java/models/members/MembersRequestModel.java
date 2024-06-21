package models.members;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Конструктор по умолчанию
@AllArgsConstructor // Конструктор со всеми полями
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembersRequestModel {
    private int id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String position;
    @JsonProperty("department_id")
    private int department;
    private String skype;
    private String phone;
    private String status;


    public MembersRequestModel(String firstName, String lastName, String email, String position, int department, String skype, String phone, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.department = department;
        this.skype = skype;
        this.phone = phone;
        this.status = status;
    }
}
