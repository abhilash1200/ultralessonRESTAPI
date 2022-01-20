import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {

    // 1. Arrange

    private UsersClient usersClient;
    @BeforeClass
    private void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateAUserWithInvalidEmailID(){
        String body = "{\n" +
                "    \"name\": \"Ramya Krishna\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"ramyakrishnaemail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        // 2. Act
       usersClient.createUser(body)
                .then()
                .log().body()
       // 3. Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));



    }

}
