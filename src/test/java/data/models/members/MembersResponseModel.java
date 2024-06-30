package data.models.members;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class MembersResponseModel {
    List<Member> members;
}
