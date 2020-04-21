package cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CartApplicationTests {
	@Autowired
	FirebaseService firebaseService;
	@Test
	void contextLoads() {
	}
	@Test
	void testService(){
	}

}
