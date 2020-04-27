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
	FirebaseModel firebaseModel;
	@Test
	void contextLoads() {
	}

	@Test
	void testSaveService() throws ExecutionException, InterruptedException {

		try {
			firebaseModel.saveItem(new Item(656357L, "title","description", 1, 8.0));
		} catch (ExecutionException e) {
			assertTrue(false);
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<Item> list = firebaseModel.getItemById(656357L);
		Item item = list.get(0);
		assertEquals("title", item.getTitle());
		assertEquals("description", item.getDescription());
		assertEquals(1, item.getQuantity());

	}

	@Test
	void testDelete() throws ExecutionException, InterruptedException {

		Item item = new Item(656357L, "title","description", 1, 8.0);
		try {

			firebaseModel.saveItem(item);
			List<Item> list = firebaseModel.getItemById(656357L);
			firebaseModel.deleteItem(item.getItemId()+"");

			List<Item> newList = firebaseModel.getItemById(656357L);
			assertNotEquals(newList.size(), list.size());


		} catch (ExecutionException e) {
			assertTrue(false);
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}







	}




}
