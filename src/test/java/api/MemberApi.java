package api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import lombok.Getter;
import models.members.Member;
import models.members.MembersRequestModel;
import models.members.MembersResponseModel;
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
                .get("v4/members")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(MembersResponseModel.class);
    }

    public Member getMember(String memberId) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("v4/members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(Member.class);
    }


    public MembersRequestModel createMember(MembersRequestModel memberRequestModel) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(memberRequestModel)
                .when()
                .post("v4/members")
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
                .put("v4/members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(MembersRequestModel.class);
    }

    public Member deleteMember(int memberId) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete("v4/members/" + memberId)
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().response().as(Member.class);
         }
}