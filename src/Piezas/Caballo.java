  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import ajedrezpoo.Tablero;
import java.io.Serializable;

/**
 *
 * @author balalo
 */
public class Caballo extends Pieza implements Serializable{
    private static final String simboloC = "C";//En cada pieza vamos a poner un símbolo
    // LO DECLARO STRING PARA LUEGO HACER EL TOSTRING.
    public Caballo(int Fila, int Column, Color color){
        super(Fila, Column, color, simboloC);
    }
    
    public void mover(int filaNueva, int columnaNueva, Tablero tab){
        
        int filaOriginal = this.getFila();
        int columnaOriginal = this.getColumna();
        
        boolean casillaVacia = tab.esCasillaVacia(filaNueva, columnaNueva);
        
        //(f1-f2)*(f1-f2) +(c1-c2)*(c1-c2) == 5
        int movimientoNorteSur = filaNueva-filaOriginal;
        int movimientoEsteOeste = columnaNueva-columnaOriginal;
        
        boolean saltoDeCaballo = ((filaNueva-filaOriginal)*(filaNueva-filaOriginal) +(columnaNueva-columnaOriginal)*(columnaNueva-columnaOriginal) == 5);
        if(casillaVacia /*|| this.getColorOpuestoenCasilla faltacrearlo*/ && saltoDeCaballo){
          /* if(/*this.getColorOpuestoenCasilla faltacrearlo){
               aqui borrar la figura
           }*/
          this.setFila(filaNueva);
          this.setColumna(columnaNueva);
        }   
    }
}
