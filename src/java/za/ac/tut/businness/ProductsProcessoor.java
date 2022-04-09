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
        //try{
//            int i =0;
//            i++;
//            while(i<2){
                Products row = new Products();
                row.setProductId(0);
                row.setName("Red T-Shirt");
                row.setCategory("T-Shirt");
                row.setPrice("160.99");
                row.setImage("buy-1.jpg");
                
                products.add(row);
                
//                row.setProductId(1);
//                row.setName("Black Shoes");
//                row.setCategory("Shoes");
//                row.setPrice("160.99");
//                row.setImage("buy-2.jpg");
//                
//                products.add(row);
            //}
            
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
        return products;
    }
}
