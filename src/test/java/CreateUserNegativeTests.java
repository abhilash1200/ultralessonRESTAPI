import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {
    @Test
    public void shouldNotAllowToCreateAUserWithInvalidEmailID(){
        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Ramya Krishna\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"ramyakrishnaemail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        // 2. Act
       new UsersClient().createUser(body)
                .then()
                .log().body()
       // 3. Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));



    }

}
