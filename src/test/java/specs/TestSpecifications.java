package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static helpers.CustomAllureListener.withCustomTemplates;

public class TestSpecifications {

    public static RequestSpecification requestSpecification = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .contentType(JSON);

    public static ResponseSpecification responseSpecification(int status) {
        return new ResponseSpecBuilder().
                expectStatusCode(status)
                .log(STATUS)
                .log(BODY)
                .build();
    }

}
