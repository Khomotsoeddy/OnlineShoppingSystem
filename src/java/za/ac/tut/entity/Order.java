/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
@Entity
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int orderNo;
    private List<Store> store;
    @OneToOne
    private Address address;
    private String OrderedDate;
    private String expectedDate;
    @OneToOne
    private Customer customerNo;
    
    
    public Order() {
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public List<Store> getStore() {
        return store;
    }

    public void setStore(List<Store> store) {
        this.store = store;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getOrderedDate() {
        return OrderedDate;
    }

    public void setOrderedDate(String OrderedDate) {
        this.OrderedDate = OrderedDate;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Customer getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Customer customerNo) {
        this.customerNo = customerNo;
    }

    
}
