/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Piezas.Pieza;
import ajedrezpoo.Tablero;
import java.io.Serializable;

/**
 *
 * @author Chete
 */
public class Vacia extends Pieza implements Serializable{
    
     private static final String simboloV = "V  ";//En cada pieza vamos a poner un símbolo
     
     public Vacia(int Fila, int Column){
        super(Fila, Column, simboloV);
     }
     
     @Override
     public void mover(int filaNueva, int columnaNueva, Tablero tab){
         this.setFila(filaNueva);
     }
     
}
