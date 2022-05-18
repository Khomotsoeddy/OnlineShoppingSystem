/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.Order;

/**
 *
 * @author Asus
 */
@Stateless
public class OrderFacade extends AbstractFacade<Order> implements OrderFacadeLocal {

    @PersistenceContext(unitName = "OnlineShoppingSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFacade() {
        super(Order.class);
    }

    @Override
    
    public void createOrder(Order order) {
        create(order);
    }

    @Override
    public int generateOrderNo() {
        int random = 9999 + (int)Math.floor(Math.random()*(99999 - 9999)+1);
        
        return random;
    }

    @Override
    public List<Order> getOrders() {
        return findAll();
    }

    @Override
    public Order findOrder(int id) {
        return find(id);
    }

    @Override
    public void updateOrder(Order order) {
        edit(order);
    }
    
}
