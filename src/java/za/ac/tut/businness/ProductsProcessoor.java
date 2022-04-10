/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.businness;

import java.util.ArrayList;
import java.util.List;
import za.ac.tut.model.Cart;
import za.ac.tut.model.Products;

/**
 *
 * @author Asus
 */
public class ProductsProcessoor {

    public ProductsProcessoor() {
    }

    public List<Products> getAllProducts() {
        List<Products> products = new ArrayList<>();

        Products row = new Products();
        row.setProductId(100);
        row.setName("product_name");
        row.setImage("buy-1.jpg");
        row.setPrice(176.34);
        row.setCategory("category");

        products.add(row);

        return products;
    }

    public ArrayList<Cart> getCartProducts(ArrayList<Cart> cartList) {
        ArrayList<Cart> products = new ArrayList<>();

        try {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public double getTotalPrice(ArrayList<Cart> cartList) {
        double sum = 0;

        try {
            if (cartList.size() > 0) {
                for (Cart c : cartList) {
                    //select price where product_id = c.getProductId()

                    //while(rs.next()){
                    //sum =+ rs.getDouble("product_price) * c.getQuantity();
                    //}
                    c.setPrice(176.34);
                    sum = c.getPrice() * c.getQuantity();

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return sum;
    }
    public int getTotalQuantity(ArrayList<Cart> cartList){
        int totalQuantity = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart c : cartList) {
                    //select price where product_id = c.getProductId()

                    //while(rs.next()){
                    //sum =+ rs.getDouble("product_price) * c.getQuantity();
                    //}
                    
                    totalQuantity += c.getQuantity();

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return totalQuantity;
    }
}
