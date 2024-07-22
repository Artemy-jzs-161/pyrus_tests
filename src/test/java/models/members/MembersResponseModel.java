package models.members;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MembersResponseModel {
    @JsonProperty("members")
    List<MemberModel> memberModels;
}
