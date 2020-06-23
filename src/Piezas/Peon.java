package Piezas;

import ajedrezpoo.Tablero;
import java.io.Serializable;

/**
 *
 * @author balalo
 */
public class Peon extends Pieza implements Serializable{
    private static final String simboloP = "P";//En cada pieza vamos a poner un símbolo
    // LO DECLARO STRING PARA LUEGO HACER EL TOSTRING.
    public Peon(int Fila, int Column, Color c){
        super(Fila, Column, c, simboloP);
    }
    
//    @Override
    public void mover(int filaNueva, int columnaNueva, Tablero tab){
        //Math.abs(f1 – f2) == Math.abs(c1 – c2)
        int filaOriginal = this.getFila();
        int columnaOriginal = this.getColumna();
        
        boolean casillaVacia = tab.esCasillaVacia(filaNueva, columnaNueva);

        boolean aux1 = ((filaNueva-filaOriginal)==1&&casillaVacia); /*aqui me da error a ver como lo solucionamos*/
        boolean aux2 = ((filaNueva-filaOriginal)+(columnaNueva-columnaOriginal)==2 && !casillaVacia); /*movimiento diagonal arriba derecha*/
        boolean aux3 = ((filaNueva-filaOriginal)+(columnaNueva-columnaOriginal)==0/*&& this.getColor()== "blanco"*/&& !casillaVacia); /*movimiento diagonal izquierda*/
        boolean aux4 = ((filaNueva-filaOriginal)==(-1)&&casillaVacia); /*aqui me da error a ver como lo solucionamos*/
        boolean aux5 = (((filaNueva-filaOriginal)+(columnaNueva-columnaOriginal)==(-2)) && !casillaVacia); /*movimiento diagonal abajo izquierda negro*/
        boolean aux6 = ((filaNueva-filaOriginal)+(columnaNueva-columnaOriginal)==0/*&& this.getColor()== "negro"*/&& !casillaVacia);
        /*faltaria que la casilla es del color enemigo*/
        if(aux1){
            this.setFila(filaNueva);
            this.setColumna(columnaNueva);
        }
        else if(aux2){
            /*falta a donde va eliminar la casilla*/
            this.setFila(filaNueva);
            this.setColumna(columnaNueva);
            
        }
        else if(aux3){
            /*falta a donde va eliminar la casilla*/
            this.setFila(filaNueva);
            this.setColumna(columnaNueva);
            
        }
        else if(aux4){
            this.setFila(filaNueva);
            this.setColumna(columnaNueva);
        }
        else if(aux5){
            /*falta a donde va eliminar la casilla*/
            this.setFila(filaNueva);
            this.setColumna(columnaNueva);
            
        }
        else if(aux6){
            /*falta a donde va eliminar la casilla*/
            this.setFila(filaNueva);
            this.setColumna(columnaNueva);
            
        }
        else{
            System.out.println("No es un movimiento de peon");
        }
    }
}
