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
public abstract class Pieza implements Serializable{
    protected int posFila; //convertir el char en int porque es mas facil para bucles
    protected int posColumna;
    protected Color color;
    protected String simbolo;
    
    public Pieza(int fila, int columna, Color color, String simbolo){
        this.posFila = fila;
        this.posColumna = columna;
        this.color = color;
        this.simbolo = simbolo;
    }
    public Pieza(int fila, int columna, String simbolo){
        this.posFila = fila;
        this.posColumna = columna;
        this.simbolo = simbolo;
    }

    public String getSimbolo(){
        return simbolo;
    }
    
    public int getFila(){
        return posFila;
    }
    
    public int getColumna(){
        return posColumna;
    }

    public Color getColor(){
        return color;
    }
    
    public void setFila(int fila){
        this.posFila = fila;
    }
    
    public void setColumna(int columna){
        this.posColumna = columna;
    }
    
    public void setColor(Color c){
        this.color = c;
    }
    
    @Override
    public String toString(){
        if (color == null)
            return simbolo;
        else
            return simbolo+color;
    }
            
    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (getClass()!= o.getClass())
            return false;
        Pieza p = (Pieza) o;
        return(p.getSimbolo().equals(getSimbolo()));
    }
    
    public boolean esPiezaVacia(){
        Pieza p = new Vacia(posFila, posColumna);
        return this.equals(p);
    }
        
    
  public abstract void mover(int fila, int columna, Tablero tab);
    
}
