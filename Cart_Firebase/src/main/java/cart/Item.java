package cart;

import org.springframework.stereotype.Component;

@Component
public class Item {

    private Long cartID;
    private String title, description;
    private String itemId;
    private Integer quantity;
    private Double price;

    public Item(){
        super();
    }

    public Item(Long cartID, String title, String description, Integer quantity, Double price){

        this.cartID = cartID;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.itemId = System.currentTimeMillis()+"";

    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {

        return title + " " + description + " " + quantity;
    }
}
