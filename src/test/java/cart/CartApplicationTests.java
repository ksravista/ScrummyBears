package cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartApplicationTests {

	@Autowired
	FirebaseService firebaseService;
	@Test
	void contextLoads() {
	}

	@Test
	void testService() throws ExecutionException, InterruptedException {

		try {
			firebaseService.saveItem(new Item(656357L, "title","description", 1, 8.0));
		} catch (ExecutionException e) {
			assertTrue(false);
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<Item> list = firebaseService.getItemById(656357L);
		Item item = list.get(0);
		assertEquals("title", item.getTitle());
		assertTrue(true);


	}

}
