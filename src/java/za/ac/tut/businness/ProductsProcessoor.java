/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.businness;

import java.util.ArrayList;
import java.util.List;
import za.ac.tut.model.Products;

/**
 *
 * @author Asus
 */
public class ProductsProcessoor {
    
    public List <Products> getAllProducts(){
        List<Products> products = new ArrayList<>();
        try{
            while(1==1){
                Products row = new Products();
                row.setProductId(0);
                row.setName("");
                row.setCategory("");
                row.setPrice("");
                row.setImage("");
                
                products.add(row);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }
}
