/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package za.ac.tut.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import za.ac.tut.business.CartSBLocal;
import za.ac.tut.model.Cart;
import za.ac.tut.model.Store;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
@Stateless
public class CartSB implements CartSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<Cart> getCartProducts(List<Cart> cartList) {

        ArrayList<Cart> products = new ArrayList<>();

        if (cartList.size() > 0) {
            for (Cart items : cartList) {

                Cart row = new Cart();

                row.setProductId(items.getProductId());
                row.setName(items.getName());
                row.setImage(items.getImage());
                row.setPrice(items.getPrice());
                row.setCategory(items.getCategory());
                row.setQuantity(items.getQuantity());

                products.add(row);
            }
        }
        return products;
    }

    @Override
    public double getTotalPrice(ArrayList<Store> products) {
        double sum = 0;
        double sumT =+ sum;

        for (Store c : products) {
            sumT = sumT+ c.getPrice() * c.getQuantity();

        }
        return sumT;
    }

    @Override
    public int getTotalQuantity(ArrayList<Store> products) {
        int total = 0;
        int totalQuantity = total;

        if (products.size() > 0) {
            for (Store c : products) {
                totalQuantity = totalQuantity + c.getQuantity();
            }
        }
        return totalQuantity;
    }
}
