import static org.junit.jupiter.api.Assertions.assertTrue;
import com.auth.Authentication;

import org.junit.jupiter.api.Test;

public class AuthenticationTest {
    @Test
    void passwordTesting(){
        Authentication Check = new Authentication("admin","admin");
        try {
            assertTrue(Check.verify());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
