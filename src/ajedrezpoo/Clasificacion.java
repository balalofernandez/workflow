/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezpoo;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author balalo
 */
public class Clasificacion  implements Serializable{//Cada vez que creamos un usuario lo metemos en la clasificacion!!
//    private TreeSet<Usuario> usuarios;
//    
//    
//    public Clasificacion(){
//        usuarios= new TreeSet<>();
//    }
//    public Clasificacion(TreeSet<Usuario> usuarios){
//        this.usuarios= usuarios;
//    }
//    
//    public void AñadirUsu(Usuario u){
//        usuarios.add(u);
//    }
//    
//    public Clasificacion reordenarXresueltos(){//ojo cuidado si queremos que la clasificacion sea entera por resueltos hay que cambiar todo
//        CompararResueltos r = new CompararResueltos();
//        TreeSet<Usuario> usuR = new TreeSet<>(r);//Creo un nuevo TreeSet ordenado por el comparator
//        Iterator i = usuarios.iterator();
//        while (i.hasNext()){
//            Usuario u = (Usuario) i.next();
//            usuR.add(u);
//        }
////        for (Usuario u : usuarios) {
////            usuR.add(u);//los meto todos en el orden que hemos dicho
////        }
//        Clasificacion aux = new Clasificacion(usuR);
//        return aux;
//    }
//    
//    public String mostrarClasificacion(){
//        // no se si va a  funcionar si queremos imprimir ordenado por resueltos
//        // seria u.reordenarXresueltos().mostrarClasificacion();
//        String texto = "";
//        Integer i=1;
//        for(Usuario u: usuarios){
//            texto += i.toString()+") ";
//            texto += u.toString()+"\n";
//            i++;
//        }
//        return texto;
//    }
    
    private ArrayList<Usuario> usuarios;
    
    public Clasificacion(){
       usuarios= new ArrayList<>();
    }
    
    public Clasificacion(ArrayList<Usuario> usuarios){
        this.usuarios= usuarios;
    }
    public void AñadirUsu(Usuario u){
        usuarios.add(u);
    }
    
    public void ordenNatural(){
        Collections.sort(usuarios);        
    }
    
    public String mostrarClasificacion(){
        // no se si va a  funcionar si queremos imprimir ordenado por resueltos
        // seria u.reordenarXresueltos().mostrarClasificacion();
        String texto = "";
        Integer i=1;
        for(Usuario u: usuarios){
            texto += i.toString()+") ";
            texto += u.toString()+"\n";
            texto += "Las estadisticas del usuarios son"+ "\n";
            texto += u.mostrarEstadistica();
            texto += "\n";
            i++;
        }
        return texto;
    }
    
    public Clasificacion reordenarXresueltos(){//ojo cuidado si queremos que la clasificacion sea entera por resueltos hay que cambiar todo
        CompararResueltos r = new CompararResueltos();
//        TreeSet<Usuario> usuR = new TreeSet<>(r);//Creo un nuevo TreeSet ordenado por el comparator
        ArrayList<Usuario> aux = usuarios;
        Collections.sort(aux, r);
//        Iterator i = usuarios.iterator();
//        while (i.hasNext()){
//            Usuario u = (Usuario) i.next();
//            usuR.add(u);
//        }
//        for (Usuario u : usuarios) {
//            usuR.add(u);//los meto todos en el orden que hemos dicho
//        }
        Clasificacion nuevaC = new Clasificacion(aux);
        return nuevaC;
    }
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
}
