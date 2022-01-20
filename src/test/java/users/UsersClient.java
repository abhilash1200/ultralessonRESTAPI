package users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import static io.restassured.RestAssured.given;

public class UsersClient {
    public Response createUser(CreateUserRequestBody body) {
        return
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer a1a2a6234bc45c474a967ea6be3b56af091df98c272d3823ad41db39a2428790")
                        .body(body)
                        .when()
                        .post("https://gorest.co.in/public/v1/users");
    }
    public Response getAllUsers() {
        return
                given()
                        .when()
                        .get("https://gorest.co.in/public/v1/users");
    }

}
