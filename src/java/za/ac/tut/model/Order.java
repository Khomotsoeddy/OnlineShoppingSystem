/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model;

/**
 *
 * @author Asus
 */
public class Order extends Products{
    private String orderId;
    private String customer_id;
    private String quanity;
    private String date;

    public Order() {
    }

    public Order(String orderId, String customer_id, String quanity, String date) {
        this.orderId = orderId;
        this.customer_id = customer_id;
        this.quanity = quanity;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getQuanity() {
        return quanity;
    }

    public void setQuanity(String quanity) {
        this.quanity = quanity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customer_id=" + customer_id + ", quanity=" + quanity + ", date=" + date + '}';
    }
}
