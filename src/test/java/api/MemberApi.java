package api;

import io.restassured.http.ContentType;
import lombok.Getter;
import data.models.members.*;
import specs.TestSpecifications;

import static io.restassured.RestAssured.given;
import static specs.TestSpecifications.requestSpecification;

public class MemberApi {
    @Getter
    private final String accessToken;

    public MemberApi(String accessToken) {
        this.accessToken = accessToken;
    }

    public MembersResponseModel getAllMember() {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("members")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(MembersResponseModel.class);
    }

    public MemberModel getMember(String memberId) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(MemberModel.class);
    }

    public ErrorMemberResponseModel getMemberError(String memberId) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(403))
                .extract().response().as(ErrorMemberResponseModel.class);
    }

    public MembersRequestModel createMember(MembersRequestModel memberRequestModel) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(memberRequestModel)
                .when()
                .post("members")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(MembersRequestModel.class);
    }

    public MembersRequestModel updateMember(int memberId, MembersRequestModel membersRequestModel) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(membersRequestModel)
                .when()
                .put("members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(MembersRequestModel.class);
    }

    public MemberModel deleteMember(int memberId) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete("members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(MemberModel.class);
    }
}
