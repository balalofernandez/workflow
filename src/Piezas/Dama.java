//(f1==f2) || (c1==c2) || (Math.abs(f1-f2) == Math.abs(c1-c2))
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
public class Dama extends Pieza implements Serializable{
    
    private static final String simboloD = "D";//En cada pieza vamos a poner un símbolo
    // LO DECLARO STRING PARA LUEGO HACER EL TOSTRING.
    public Dama(int Fila, int Column, Color color){
       super(Fila, Column, color, simboloD);
    }
    
    public void mover(int filaNueva, int columnaNueva, Tablero tab){
        //Math.abs(f1 – f2) == Math.abs(c1 – c2)
        int filaOriginal = this.getFila();
        int columnaOriginal = this.getColumna();
        
        boolean casillaVacia = true;
        boolean aux1 = (filaNueva==filaOriginal);
        boolean aux2 = (columnaOriginal==columnaNueva);
        boolean aux3 = (Math.abs(filaOriginal-filaNueva) == Math.abs(columnaOriginal-columnaNueva));
        if( aux1 || aux2 || aux3){
            boolean aux = true; //para saber si ha pasado
            if (aux1){
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
            else if(aux2){
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
            else if(aux3){
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
        
            }
        }
        else{
            System.out.println("No es movimiento de Dama");
        }
    }
}
