/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NGUYEN LAN
 */
public class Account {
    private int id;
    private String name;
    private String email;
    private String password;
    private int isSeller;

    public Account() {
    }

    public Account(int id, String name, String email, String password, int isSeller) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isSeller = isSeller;
    }

    public int getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(int isSeller) {
        this.isSeller = isSeller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + '}';
    }
    
    
    
}
