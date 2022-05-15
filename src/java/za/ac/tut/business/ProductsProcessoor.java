/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.business;

import java.util.ArrayList;
import java.util.List;
import za.ac.tut.model.Cart;
import za.ac.tut.model.Store;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
public class ProductsProcessoor {

    public ProductsProcessoor() {
    }
    public ArrayList<Cart> getCartProducts(ArrayList<Cart> cartList) {
        
        ArrayList<Cart> products = new ArrayList<>();


            if (cartList.size() > 0) {
                for (Cart items : cartList) {
                    //select all from product where id = items.getProductId();

                    Cart row = new Cart();
                    
                    row.setProductId(100);
                    row.setName("product_name");
                    row.setImage("buy-1.jpg");
                    row.setPrice(176.34);
                    row.setCategory("category");
                    row.setQuantity(items.getQuantity());
                    
                    products.add(row);
                }
            }

        return products;
    }

    public double getTotalPrice(ArrayList<Store> cartList) {
        double sum = 0;
        double sumT =+ sum;
        try {
            if (cartList.size() > 0) {
                for (Store c : cartList) {
                
                    
                    sumT = sumT  + c.getPrice() * c.getQuantity();
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return sumT;
    }
    public int getTotalQuantity(ArrayList<Store> cartList){
        int total = 0;
        int totalQuantity = total;
        try {
            if (cartList.size() > 0) {
                for (Store c : cartList) {
                    //select price where product_id = c.getProductId()

                    //while(rs.next()){
                    //sum =+ rs.getDouble("product_price) * c.getQuantity();
                    //}
                    
                    totalQuantity = totalQuantity+ c.getQuantity();
                    
                }
System.out.println(totalQuantity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return totalQuantity;
    }
}
