/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

/**
 *
 * @author boud-
 */
public class Product {
    int itemId;
    String description;
    double price;
    int qty;

    public Product(int itemId, String description, double price, int qty) {
        this.itemId = itemId;
        this.price = price;
        this.description = description;
        this.qty = qty;
    }

    public Product() {
    }
    
    
    
    @Override
    public String toString() {
        return "Product{" + "itemId=" + itemId + ", description=" + description + ", price=" + price + ", qty=" + qty + '}';
    }

    public int getQty() {
        return qty;
    }

    public int getItemId() {
        return itemId;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
