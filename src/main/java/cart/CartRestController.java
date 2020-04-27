package cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class CartRestController {

    @Autowired
    FirebaseModel firebaseModel;


    @PostMapping(path = "/add")
    public ResponseEntity postItem(@RequestBody Item item) throws ExecutionException, InterruptedException {

        //add to orders
        item.setItemId(System.currentTimeMillis());
        item.setQuantity(1);
        firebaseModel.saveItem(item);

        //POST to Orders service
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://34.229.53.170:8081/cartSummary", item, Item.class);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete/{cartID}/{itemID}")
    public String delete(@PathVariable String itemID, @PathVariable String cartID, Model model)
            throws ExecutionException, InterruptedException {
        boolean problem = false;
        try {

            //DELETE from Orders Service.
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete("http://34.229.53.170:8081/deleteItem/" + itemID);
        }catch(Exception e){
            problem = true;
        }
        //delete from own only if there is 200 response from the Orders Service
        if(!problem) {
            firebaseModel.deleteItem(itemID);
            List<Item> list = firebaseModel.getItemById(Integer.parseInt(cartID));
            model.addAttribute("items", list);
        }
        return "index";
    }


    @GetMapping("/")
    public String mainWithParam(
            @RequestParam(name = "cartID", required = true, defaultValue = "")
                    String id, Model model) throws ExecutionException, InterruptedException {

        model.addAttribute("message", id);
        List<Item> list = firebaseModel.getItemById(Integer.parseInt(id));
        model.addAttribute("items", list);
        return "index";
    }
}
