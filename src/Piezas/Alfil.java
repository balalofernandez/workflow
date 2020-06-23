  
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
public class Alfil extends Pieza implements Serializable{
    
    private static final String simboloA = "A";//En cada pieza vamos a poner un símbolo
    // LO DECLARO STRING PARA LUEGO HACER EL TOSTRING.
    public Alfil(int Fila, int Column, Color color){
        super(Fila, Column, color, simboloA);
    }
    
    public void mover(int filaNueva, int columnaNueva, Tablero tab){
        //Math.abs(f1 – f2) == Math.abs(c1 – c2)
        int filaOriginal = this.getFila();
        int columnaOriginal = this.getColumna();
        
         boolean casillaVacia = true;
        
        if(Math.abs(columnaNueva-columnaOriginal)==Math.abs(filaNueva-filaOriginal)){
        if(filaNueva<filaOriginal){
                if(columnaOriginal<columnaNueva){
                    columnaOriginal ++;
                    filaOriginal++;
                    while(casillaVacia && (columnaOriginal<=columnaNueva)){
                        casillaVacia = tab.esCasillaVacia(filaOriginal, columnaOriginal);
                        columnaOriginal++;
                        filaOriginal++;
                    }
                }
                else{
                    columnaOriginal --;
                    filaOriginal--;
                    while(casillaVacia && (columnaOriginal>=columnaNueva)){
                        casillaVacia = tab.esCasillaVacia(filaOriginal, columnaOriginal);
                        columnaOriginal--;
                        filaOriginal--;
                    }   
                }
            }
        
        else{
               if(columnaNueva<columnaOriginal){
                     filaOriginal++;
                    columnaOriginal++;
                    while(casillaVacia && (filaOriginal<=filaNueva)){
                        casillaVacia = tab.esCasillaVacia(filaOriginal, columnaOriginal);
                        columnaOriginal++;
                        filaOriginal++;
                        }        
                }
                else{
                    filaOriginal--;
                    columnaOriginal--;
                    while(casillaVacia && (filaOriginal>=filaNueva)){
                        casillaVacia = tab.esCasillaVacia(filaOriginal, columnaOriginal);
                        columnaOriginal--;
                        filaOriginal--;
                    }        
                }
        }
    //a esto le tengo que dar una buena pensada
        if((!casillaVacia && tab.esCasillaVacia(filaNueva, columnaNueva))||((columnaOriginal==columnaNueva) && (filaNueva==filaOriginal)))/*&&aux*/{
        System.out.println("No es posible mover la pieza porque en su linea de movimiento hay casillas no vacias");
            }
            else{
                this.setColumna(columnaNueva);
                this.setFila(filaNueva);
            }
        }
        else{
            System.out.println("No es un movimiento de torre");
        }      
            
    }

}
