import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser (){

        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna12@email.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        createUser(body)
                .then()
                .log().body()
        // 3. Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna12@email.com"));



    }
    @Test
    public void shouldCreateFemaleUser (){

        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Ramya Krishna\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"ramyakrishna4@email.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        // 2. Act
        createUser(body)
                .then()
                .log().body()
        // 3. Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("ramyakrishna4@email.com"));



    }


    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer a1a2a6234bc45c474a967ea6be3b56af091df98c272d3823ad41db39a2428790")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }


}
