/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Card;

/**
 *
 * @author Asus
 */
@Local
public interface CardFacadeLocal {

    void create(Card card);

    void edit(Card card);

    void remove(Card card);

    Card find(Object id);

    List<Card> findAll();

    List<Card> findRange(int[] range);

    int count();
    
}
