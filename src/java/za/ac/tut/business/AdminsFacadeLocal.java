/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Admins;

/**
 *
 * @author Asus
 */
@Local
public interface AdminsFacadeLocal {

    List<Admins> getAdmins();
    
}
