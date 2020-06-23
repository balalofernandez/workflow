/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezpoo;

import Piezas.Pieza;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author balalo
 */
public class Tablero  implements Serializable{
    private Pieza[][] Casillas;
    private ArrayList<String> Solucion;
    private ArrayList<Usuario> uResueltos;
    private int numIntentos;
    private final int max = 8;
   // private static final tamaño = 8; NO SE PORQUE NO ME DEJA HACER ESTA CONSTANTE AYUDAA
    
    public Tablero(Pieza[][] problema, ArrayList<String> Solucion){
        Casillas = problema;
        this.Solucion = Solucion;
        uResueltos = new ArrayList<>();
        // MIRAR SI SE INICIALIZA TODO EN EL CONSTRUCTOR
        }
    
    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (getClass()!= o.getClass())
            return false;
        Tablero t = (Tablero) o;
        boolean iguales = true;
        int i=0;
        int j=0;
        while(i<max && iguales){
            while(j<max && iguales){
                iguales = t.getPiezaCasilla(i,j).equals(getPiezaCasilla(i,j));
                j++;
            }
            i++;
        }
        return iguales;
    }
    
    public Pieza getPiezaCasilla(int i, int j){
        return Casillas[i][j];
    }
    
    
//    public boolean moverPieza(String movimiento){
//          
//    }
    
    @Override
    public String toString(){//no funciona bien
        String tablero= "";
        for(int i=0; i<max; i++){
            tablero+="\n";
            tablero+= Integer.toString(8-i)+"     ";
//            tablero += ("---------------------------------------------------------"+"\n");
            for(int j=0; j<max; j++){  
                tablero += (Casillas[i][j].toString()+ "     ");//"|  " 
            }
            tablero += "\n";
            tablero += "       ";
        }
        for(int k=0;k<8;k++){
            
            int aux = (int)'a';
            char aux2 = (char)(aux+k);
            String fila = Character.toString(aux2);
            tablero += fila +"        ";
        }
        return tablero;
    }
    
    
    
//    public boolean validarDestino(){
//       
//    }
    
    
    
//    public boolean solucionValida(){ Este es el opcional q son 4 puntos
//        
//    }
    public void añadirUsuRes(Usuario u){
        uResueltos.add(u);
    }
    
    public void incrementarIntento(){
        numIntentos++;
    }
    public void mostrarResueltos(){
        for(Usuario u: uResueltos){
            System.out.println(u.toString());
        }
    }
    public int mostrarNumRes(){
        return uResueltos.size();
    }
    public double porcentajeExito(){
        return (mostrarNumRes()*100)/numIntentos;
    }
    
    public boolean esCasillaVacia(int f, int c){
        return Casillas[f][c].esPiezaVacia();
    }
    
    public boolean esSolCorrecta(String sol){
        return Solucion.contains(sol);
    }
    
    public int getNumIntentos(){
        return numIntentos;
    }
    
    public ArrayList<Usuario> getUsuariosResueltos(){
        return uResueltos;
    }

}