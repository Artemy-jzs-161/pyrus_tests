package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.*;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static helpers.CustomAllureListener.withCustomTemplates;

public class TestSpecifications {
    public static RequestSpecification requestSpecification = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers();

    public static ResponseSpecification responseSpecification(int status) {
        return new ResponseSpecBuilder().
                expectStatusCode(status)
                .log(STATUS)
                .log(BODY)
                .build();
    }
}
