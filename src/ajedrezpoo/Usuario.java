/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezpoo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author balalo
 */
public class Usuario implements Comparable, Serializable{
    private String nombreUsu;
    private String password;
    private int numErrores;
    private ArrayList<Tablero> problemasResueltos;
    private int numPIntentados;
    private double porcentajeExito;
    
    public Usuario(String nom, String password){
        nombreUsu = nom;
        this.password = password;
        numErrores = 0;
        problemasResueltos = new ArrayList<>();
        numPIntentados= 0;
        porcentajeExito= 0.1;
    }
    
    public Usuario(){
        nombreUsu = "";
        password = "";
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (getClass()!= o.getClass())
            return false;
        Usuario usu = (Usuario) o;
        return(usu.getNombre().equals(this.getNombre()));//&&(usu.getNumResueltos() == this.getNumResueltos()))||(usu.getNombre().equals(this.getNombre())));
        // && usu.getPassword().equals(this.getPassword()));
    //nos va a dejar hacer usuarios con el mismo nombre de usuario;
    }
    
    @Override
    public String toString(){
        return nombreUsu;
    }
    
    public String getNombre(){
        return this.nombreUsu;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public int getNumError(){
        return numErrores;
    }
    
    public int getNumResueltos(){
        return problemasResueltos.size();
        
    }
    
    public int getNumPIntentos(){
        return numPIntentados;
    }
    
    public void setNombreUsu(String nom){
        this.nombreUsu = nom;
    }
    
    public void setPassword(String pass){
        this.password = pass;
    }
    
    public void incrementarError(){
        this.numErrores++;
    }
    
    public void añadirProblemaR(Tablero t){
        problemasResueltos.add(t);
    }
    
    public void añadirProblemaI(){
        numPIntentados++;        
    }
    
    public boolean verSiResuelto(Tablero t){//comprueba si un problema está resuelto, con los equals redefinidos
        int i=0;
        boolean encontrado = false;
        while (i<problemasResueltos.size() && !encontrado){
            Tablero tab = problemasResueltos.get(i);
            if (tab.equals(t)) //todos los metodos de ver si resuelto y comprobar si existen dependen del EQUALS, hay que ver si están bien.
                    encontrado = true;
            i++;
        }
//        return problemasResueltos.contains(t);
        return encontrado;
    }
    
    //este método voy a hacer que que devuelva un double en vez de que simplemente lo imprima por pantalla
    //ya que en el uml que hemos diseñado pone que es vacio, y luego tenemos que ordenar por porcentaje de exito
    public void setporcentajeExito(){
        porcentajeExito = (problemasResueltos.size()*100)/numPIntentados;
    }
    
    public double getporcentajeExito(){
        return porcentajeExito;
    }
    
    /*Ver estadísticas personales: serán accesibles el número de problemas intentados,
    el número de problemas resueltos, el número de errores totales y
    el porcentaje de éxito del usuario (problemas resueltos / problemas intentados * 100).*/
    
    public String mostrarEstadistica(){
        return ("El numero de problemas intentados es: "+numPIntentados+"\n"+
            "El numero de problemas resueltos es: "+problemasResueltos.size()+"\n"+
            "El porcentaje de éxito del usuario es: "+getporcentajeExito());
    }       
        
    /**
     *
     * @param o
     * @return
     */
    @Override 
    public int compareTo(Object o){//no se si esta bien porque te va a decir que dos usu son iguales si tienen el mismo porcentaje de exito
        Usuario usu = (Usuario) o;
        Double x = this.getporcentajeExito();
        Double y = usu.getporcentajeExito();
        return y.compareTo(x);
    }
    
    
    
    
}
