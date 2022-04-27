/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model;

import za.ac.tut.entity.Product;

/**
 *
 * @author Asus
 */
public class Cart extends Product{
    private int quantity;
    private Product product;

    public Cart() {
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString()+"Cart{" + "quantity=" + quantity + '}';
    }
}
