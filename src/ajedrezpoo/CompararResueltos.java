/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezpoo;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author balalo
 */
public class CompararResueltos implements Comparator, Serializable{
    @Override
    public int compare(Object arg0, Object arg1){
        Usuario u1 = (Usuario) arg0;
        Usuario u2 = (Usuario) arg1;
        if (u1.getNumResueltos()>u2.getNumResueltos())
            return 1;
        else if (u1.getNumResueltos() < u2.getNumResueltos())
            return -1;
        else
            return 0;
            
        
    }
}
