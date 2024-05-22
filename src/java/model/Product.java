/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NGUYEN LAN
 */
public class Product {
    private String id;
    private String name;
    private String detail;
    private float price;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String cateID;
    
    public Product() {
    }

    public Product(String id, String name, String detail, float price, String image1, String image2, String image3, String image4, String cateID) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.cateID = cateID;
    }

    public String getId() {
        return id;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

   

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", detail=" + detail + ", price=" + price + ", image1=" + image1 + ", image2=" + image2 + ", image3=" + image3 + ", image4=" + image4 + ", cateID=" + cateID + '}';
    }
    
    
    
    
    
    
}
