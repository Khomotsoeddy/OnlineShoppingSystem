/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Product;

/**
 *
 * @author Asus
 */
@Local
public interface ProductFacadeLocal {


    List <Product> listAllProduct();

    Product findProduct(int productId);
    
       
}
