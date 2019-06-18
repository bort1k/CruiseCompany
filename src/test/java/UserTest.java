import com.bortni.exceptions.EmailAlreadyExistException;
import com.bortni.model.User;
import com.bortni.service.UserService;
import org.junit.Test;

public class UserTest {
    UserService userService = new UserService();

    @Test
    public void createAndPrintUser() throws EmailAlreadyExistException {
        User user = new User();
        user.setId(1);
        user.setEmail("email2");
        user.setFirstName("nik");
        user.setLastName("bort");
        user.setPassword("1qaz");
        userService.createUser(user);

        User user1 = userService.getUserById(1);
        System.out.println(user1);
    }

    @Test
    public void getUserByEmailAndPassword(){
        String email = "nikita.bortnichuk41@gmail.com";
        String password = "1qaz";

        User user = userService.getUserByEmailAndPassword(email, password);
        System.out.println(user);
    }
}
