/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NGUYEN LAN
 */
public class Cart {
    private String id;
    private String productID;

    public Cart(String id, String productID) {
        this.id = id;
        this.productID = productID;
    }

    public Cart(String productID) {
        this.productID = productID;
    }

    
    public Cart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", productID=" + productID + '}';
    }
    
    
    
}
