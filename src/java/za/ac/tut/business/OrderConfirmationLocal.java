/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package za.ac.tut.business;

import javax.ejb.Local;
import za.ac.tut.entity.Order;

/**
 *
 * @author Asus
 */
@Local
public interface OrderConfirmationLocal {

    void orderConfirm(String emailAddress,Order order);
    
}
