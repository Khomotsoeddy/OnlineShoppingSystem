/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model;

/**
 *
 * @author Asus
 */
public class Cart extends Products{
    private int quantity;

    public Cart() {
    }

    public Cart(int productId, String name, String category, double price, String image,int quantity) {
        super(productId,name,category,price,image);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString()+"Cart{" + "quantity=" + quantity + '}';
    }

 
    
    
}
