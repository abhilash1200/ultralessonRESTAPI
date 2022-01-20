import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import java.util.UUID;


public class CreateUserTests {

    // 1. Arrange
    private  UsersClient usersClient;
    @BeforeClass
    public void beforeClass (){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldCreateMaleUser (){
        String email = String.format("%s@email.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("enali Ramakrishna").gender("male")
                .email(email).status("active").build();

        // 2. Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()

                // 3. Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email));
    }
    @Test
    public void shouldCreateFemaleUser (){

        // 1. Arrange
        String email = String.format("%s@email.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Ramya Krishna").gender("female")
                .email(email).status("active").build();


        // 2. Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()

                // 3. Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email));
    }

}
