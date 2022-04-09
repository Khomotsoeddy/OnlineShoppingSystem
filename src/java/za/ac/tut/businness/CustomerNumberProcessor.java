/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.businness;

/**
 *
 * @author Asus
 */
public class CustomerNumberProcessor {
    public String generateCustomerNumber(){
        String customerNumber = "";
        for(int i=0;i<5;i++){
            int random =(int)Math.floor(Math.random()*9);
            customerNumber = customerNumber + random;
        }
        return customerNumber;
    }
}
