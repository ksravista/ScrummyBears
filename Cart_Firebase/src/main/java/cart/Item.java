package cart;

import org.springframework.stereotype.Component;

@Component
public class Item {

    private Long cartId;
    private String name, description;
    private Integer quantity;
    private Double price;

    public Item(){
        super();
    }

    public Item(Long cartId, String name, String description, Integer quantity, Double price){

        this.cartId = cartId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;

    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
