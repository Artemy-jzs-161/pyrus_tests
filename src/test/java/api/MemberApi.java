package api;

import io.restassured.http.ContentType;
import lombok.Getter;
import models.members.Member;
import models.members.MembersResponseModel;
import specs.TestSpecifications;
import tests.api.TestBase;

import static io.restassured.RestAssured.given;

public class MemberApi {
    @Getter
    private final String accessToken;

    public MemberApi(String accessToken) {
        this.accessToken = accessToken;
    }


    public MembersResponseModel getAllMember(String memberId) {
        return given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("v4/members")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().as(MembersResponseModel.class);
    }

    public Member getMember(String memberId) {
        return given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("v4/members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().as(Member.class);
    }


    public Member createMember(Member member) {
        return given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(member)
                .when()
                .post("v4/members")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().as(Member.class);
    }

    public void updateMember(String memberId, MembersResponseModel memberRequest) {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(memberRequest)
                .when()
                .put("v4/members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200));
    }

    public void deleteMember(String memberId) {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete("v4/members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200));
    }
}