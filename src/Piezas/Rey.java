  
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
 * @author balalo
 */
public class Rey extends Pieza implements Serializable{
    private static final String simboloR = "R";//En cada pieza vamos a poner un símbolo
    // LO DECLARO STRING PARA LUEGO HACER EL TOSTRING.
    public Rey(int Fila, int Column, Color color){
        super(Fila, Column, color, simboloR);
    }
    
    public void mover(int filaNueva, int columnaNueva, Tablero tab){
        
        int filaOriginal = this.getFila();
        int columnaOriginal = this.getColumna();
        
        boolean movimientoRey = ((Math.abs(filaNueva-filaOriginal)<=1& (Math.abs(columnaNueva-columnaOriginal) <=1)));
        boolean casillaVacia = tab.esCasillaVacia(filaNueva, columnaNueva);
        
        if (movimientoRey && (casillaVacia /*|| falta metodo que comprueba que la ficha es del color opuesto*/)){
            /*if(falta metodo que comprueba que la ficha es del color opuesto)
                eliminar la ficha etc;
            */
          this.setFila(filaNueva);
          this.setColumna(columnaNueva);
        }
        else{
            System.out.println("No es movimiento de Rey");
        }
    }
}

            
