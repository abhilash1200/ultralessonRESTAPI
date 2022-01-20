import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTests {
    @Test
    public void shouldGetAllUsers(){
        given()
                .when()
                     .get("https://gorest.co.in/public/v1/users")
                .then()
                    .statusCode(200)
                    .body("data",Matchers.hasSize(20))
                    .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                    .log().body();
    }
    @Test
    public void shouldCreateUser (){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer a1a2a6234bc45c474a967ea6be3b56af091df98c272d3823ad41db39a2428790")
                .body("{\n" +
                        "    \"name\": \"Tenali Ramakrishna\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"tenali.ramakrishna8@email.com\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when()
                    .post("https://gorest.co.in/public/v1/users")
                .then()
                    .log().body()
                    .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna8@email.com"));



    }

}
