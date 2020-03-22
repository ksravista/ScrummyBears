package cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class CartRestController {

    @Autowired
    FirebaseService firebaseService;

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("message", "messafe");
        return "index"; //view
    }

    @PostMapping(path = "/add")
    public ResponseEntity postItem(@RequestBody Item item) throws ExecutionException, InterruptedException {

        item.setItemId(System.currentTimeMillis()+"");
        item.setQuantity(1);
        firebaseService.saveItem(item);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/increment")
    public ResponseEntity increment(@RequestBody Item item) throws ExecutionException, InterruptedException {

        item.setQuantity(item.getQuantity()+1);

        firebaseService.deleteItem(item);
        firebaseService.saveItem(item);

        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/decrement")
    public ResponseEntity decrement(@RequestBody Item item) throws ExecutionException, InterruptedException {

        item.setQuantity(item.getQuantity()-1);

        firebaseService.deleteItem(item);
        firebaseService.saveItem(item);

        return ResponseEntity.ok().build();
    }


//    // /hello?name=kotlin
    @GetMapping("/cart")
    public String mainWithParam(
            @RequestParam(name = "cartID", required = true, defaultValue = "")
                    String id, Model model) throws ExecutionException, InterruptedException {

        model.addAttribute("message", id);

        List<Item> list = firebaseService.getItemById(Integer.parseInt(id));
        model.addAttribute("items", list);
        return "index";
    }
}
