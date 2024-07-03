package data.models.members;

import lombok.Data;

import java.util.List;

@Data
public class MembersResponseModel {
    List<MemberModel> memberModels;
}
