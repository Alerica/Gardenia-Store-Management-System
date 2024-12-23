package cashier;

public class CartItem {

    String ID, name;
    int quantity, price;
    
    public CartItem(String ID, String name, int quantity, int price) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
    
    public void AddQuantity(int quantity) {
        this.quantity += quantity;
    }
    
    public void RemoveQuantity(int quantity) {
        this.quantity -= quantity;
    }
    
    public String getQuantityAsString() {
        return String.valueOf(quantity);
    }
    
    public String getPriceAsString() {
        return String.valueOf(price);
    }
    
}
