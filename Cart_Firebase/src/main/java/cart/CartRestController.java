package cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CartRestController {

    @Autowired
    FirebaseService firebaseService;

    @RequestMapping("/")
    public String hello(){

        return "hello";
    }

    @PostMapping(path = "/add")
    public String postItem(@RequestBody Item item) throws ExecutionException, InterruptedException {

        return firebaseService.saveItem(item);
    }
}
