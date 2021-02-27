package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    @TestSecurity(authorizationEnabled = false)
    public void testGenerateNameEndpoint() {
        given()
          .when().get("/generate/name")
          .then()
             .statusCode(200)
             .body(anyOf(is("Ada"), is("Alexandra"), is("Burr"), is("Edson"), is("Kamesh"), is("Sebi"), is("Anna"), is("Gavina")));
    }

}