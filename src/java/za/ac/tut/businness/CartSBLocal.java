/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package za.ac.tut.businness;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import za.ac.tut.model.Cart;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
@Local
public interface CartSBLocal {
    public List<Cart> getCartProducts(List<Cart> cartList);
    public double getTotalPrice(ArrayList<Store> products);
    public int getTotalQuantity(ArrayList<Store> products);
}
