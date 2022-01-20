import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

public class CreateUserNegativeTests {

    // 1. Arrange
    private UsersClient usersClient;
    @BeforeClass
    private void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateAUserWithInvalidEmailID(){
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Ramya Krishna").gender("female")
                .email("ramyakrishnaemail.com").status("active").build();

        // 2. Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()

                // 3. Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }

}
