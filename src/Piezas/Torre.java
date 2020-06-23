
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
public class Torre extends Pieza implements Serializable{
    private static final String simboloT = "T";//En cada pieza vamos a poner un símbolo
    // LO DECLARO STRING PARA LUEGO HACER EL TOSTRING.
    public Torre(int Fila, int Column, Color color) {
        super(Fila, Column, color, simboloT);
    }
    
    public void mover(int filaNueva, int columnaNueva, Tablero tab){
        
        int filaOriginal = this.getFila();
        int columnaOriginal = this.getColumna();
        
        
        boolean casillaVacia = true;
       /* boolean aux = (getColorPiezaCasilla(filaNueva, columnaNueva).equals(this.getColor()));*/
                
        if((filaNueva==filaOriginal) || (columnaNueva==columnaOriginal)){
            if(filaNueva==filaOriginal){
                if(columnaOriginal<columnaNueva){
                    columnaOriginal ++;
                    while(casillaVacia && (columnaOriginal<=columnaNueva)){
                        casillaVacia = tab.esCasillaVacia(filaOriginal, columnaOriginal);
                        columnaOriginal++;
                    }
                }
                else{
                    columnaOriginal --;
                    while(casillaVacia && (columnaOriginal>=columnaNueva)){
                        casillaVacia = tab.esCasillaVacia(filaOriginal, columnaOriginal);
                        columnaOriginal--;
                    }   
                }
            }
            else{
                if(filaOriginal<filaNueva){
                filaOriginal++;
                while(casillaVacia && (filaOriginal<=filaNueva)){
                    casillaVacia = tab.esCasillaVacia(filaOriginal, columnaOriginal);
                    columnaOriginal++;
                    }        
                }
                else{
                filaOriginal--;
                while(casillaVacia && (filaOriginal>=filaNueva)){
                    casillaVacia = tab.esCasillaVacia(filaOriginal, columnaOriginal);
                    columnaOriginal--;
                    }        
                }
            }
            
            if(!casillaVacia &&((columnaOriginal==columnaNueva) && (filaNueva==filaOriginal)/*&&aux*/)){
                /*eliminar la pieza*/
                this.setColumna(columnaNueva);
                this.setFila(filaNueva);
            }
            else if (casillaVacia){
                this.setColumna(columnaNueva);
                this.setFila(filaNueva);
            }
        }
        else{
            System.out.println("No es un movimiento de torre");
        }      
    }
}
