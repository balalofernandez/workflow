/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezpoo;

import Piezas.Color;
import Piezas.Torre;
import Piezas.Vacia;
import Piezas.Rey;
import Piezas.Pieza;
import Piezas.Peon;
import Piezas.Dama;
import Piezas.Caballo;
import Piezas.Alfil;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author balalo
 */
public class Sistema  implements Serializable{
    private ArrayList<Usuario> Usuarios;
    private ArrayList<Tablero> Tableros;
    private final int max = 8;
    
    public Sistema(){
        Usuarios = new ArrayList<>();
        Tableros = new ArrayList<>();
        
    }
    
    public ArrayList<Tablero> getTableros(){
        return Tableros;
    }
    
    public int getNumUsu(){
        return Usuarios.size();
    }
    
    public void añadirUsuario(Usuario u){
        if (existeUsu(u)== false)
                Usuarios.add(u);
    }
    
    public boolean existeUsu(Usuario u){
        int i=0;
        boolean encontrado = false;
        while (i<Usuarios.size() && !encontrado){
            Usuario usu = Usuarios.get(i);
            if (usu.equals(u))
                    encontrado = true;
            i++;
        }
        return encontrado;
    }
    
    public Usuario autenticar(String nom, String contraseña)throws UsuarioNoEncontradoException{
        Usuario prueba = new Usuario(nom, contraseña);
        if (existeUsu(prueba) == true && contraseña.equals(prueba.getPassword()))//lo tengo que poner asi para que las contraseñas coincidan tambien
            return prueba;
        else 
            throw new UsuarioNoEncontradoException("No existe el usuario") ;            
    }
    
    public boolean tablaValida(String[][] tabla){//SERIA BUENA IDEA TIRAR UNA EXCEPTION SI NO SE PUEDE AÑADIR
        //Vamos a comprobar que hay un rey por cada bando y solo uno
        int numRN= 0;
        int numRB = 0;
        int numPN = 0;
        int numPB = 0;
        int numTN = 0;
        int numTB = 0;
        int numAB = 0;
        int numAN = 0;
        int numCB = 0;
        int numCN = 0;
        int numDB = 0;
        int numDN = 0;
        for(int i=0; i<max; i++){
            for(int j=0; j<max; j++){
                switch(tabla[i][j]){
                        case "PN":
                            numPN++;
                            break;
                        case "CN":
                            numCN++;
                            break;
                        case "AN":
                            numAN++;
                            break;
                        case "TN":
                            numTN++;
                            break;
                        case "DN":
                            numDN++;
                            break;
                        case "CB":
                            numCB++;
                            break;
                        case "PB":
                            numPB++;
                            break;
                        case "AB":
                            numAB++;
                            break;
                        case "TB":
                            numTB++;
                            break;
                        case "DB":
                            numDB++;
                            break; 
                        case "RN":
                            numRN++;
                            break;
                        case "RB":
                            numRB++;
                            break;
                }
            }
        }
        
        if(numRB != 1){
            return false;
        }
        else if(numRN != 1){
            return false;
        }
        else if((numPN < 9)&&(numPB < 9)){
            if((numDN+numPN <10)&&(numCN+numPN <11)&&(numAN+numPN <11)&&(numTN+numPN <11)&&(numDB+numPB <10)&&(numCB+numPB <11)&&(numAB+numPB <11)&&(numTB+numPB <11))
                        return (numCN+numTN+numPN-8<4)&&(numTN+numAN+numPN-8<4)&&(numCN+numDN+numPN-8<3)
                                &&(numAN+numDN+numPN-8<3)&&(numTN+numDN+numPN-8<3)&&(numCN+numAN+numPN-8<4)
                                &&(numCB+numTB+numPB-8<4)&&(numTB+numAB+numPB-8<4)&&(numCB+numDB+numPB-8<3)
                                &&(numAB+numDB+numPB-8<3)&&(numTB+numDB+numPB-8<3)&&(numCB+numAB+numPB-8<4);
                
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
//    public boolean iniciarSesion(); CREO QUE ESTE MÉTODO ES MÁS DEL MAIN. YA QUE TENEMOS EXISTE USU Y SE PUEDE EMPLEAR EN EL MAIN
//    ¿COMO LO VEIS?
    
    // este método se puede ver de dos formas, que añade al sistema un tablero o que lee un tablero.txt
    // lo iba a hacer boolean pero si no lo añade muestra un msg y no lo añade y ya
    
    public void añadirTablero(String fichero)throws java.io.FileNotFoundException, TablaNoValidaException{// Tienes el fichero o la ruta que te la pasan y voy a leerlo y añadirlo. 
        try {
            FileReader fr= new FileReader(fichero);
            BufferedReader entrada = new BufferedReader(fr);
            String s;
            String texto= "";
            while((s = entrada.readLine()) != null){
                texto += s;
                texto += ",";//SEPARO EL TABLERO POR COMAS  
            }
            entrada.close();
            texto= texto.toUpperCase();//PONGO TODAS LAS LETRAS EM MAYUSCULA
            String[] captura = texto.split(",");//DIVIDO EL TEXTO ENTERO DONDE PONE TODAS LAS PIEZAS EN UN ARRAY CON LAS 64 CASILLAS Y LA PIEZA
            ArrayList<String> soluciones = new ArrayList<>();
                for (int i=64; i<captura.length; i++){
                    soluciones.add(captura[i]);
            }
            String[][] subcaptura= new String[max][max];
            
            for(int i=0; i<64; i++){//CON ESTO LO QUE CONSIGO ES UN ARRAY BIDIMENSIONAL CON LAS PIEZAS
                subcaptura[i/max][i%max]= captura[i];              
            }
            Pieza[][] problema = new Pieza[max][max];
            if(this.tablaValida(subcaptura)){//FALTA COMPLETAR ESTO, NO DEJAR QUE LO CREE Y A LO MEJOR TIRAR OTRA EXCEPTION
                for(int i= 0; i<max; i++){
//                    char fila = (char) ('a'+i);
                    //solucionar!!! porque no es así el tablero
                    //A8....H8
                    //.
                    //.
                    //.
                    //A1....H1
                    for(int j=0; j<max; j++){
                        switch (subcaptura[i][j]){
                            case "V": //YA ESTAN EN MAYUSCULAS!! SOLO PONGO LAS MAYUSC.
                                Pieza x = new Vacia(i,j+1);
                                problema[i][j] = x;
                                break;
                            case "PN":
                                Pieza pn = new Peon(i,j+1,Color.N);
                                problema[i][j] = pn;
                                break;
                            case "PB":
                                Pieza pb = new Peon(i,j+1,Color.B);
                                problema[i][j] = pb;
                                break;
                            case "CN":
                                Pieza cn = new Caballo(i,j+1,Color.N);
                                problema[i][j] = cn;
                                break;
                            case "CB":
                                Pieza cb = new Caballo(i,j+1,Color.B);
                                problema[i][j] = cb;
                                break;
                            case "AN":
                                Pieza an = new Alfil(i,j+1,Color.N);
                                problema[i][j] = an;
                                break;
                            case "AB":
                                Pieza ab = new Alfil(i,j+1,Color.B);
                                problema[i][j] = ab;
                                break;
                            case "TN":
                                Pieza tn = new Torre(i,j+1,Color.N);
                                problema[i][j] = tn;
                                break;
                            case "TB":
                                Pieza tb = new Torre(i,j+1,Color.B);
                                problema[i][j] = tb;
                                break;
                            case "RN":
                                Pieza rn = new Rey(i,j+1,Color.N);
                                problema[i][j] = rn;
                                break;
                            case "RB":
                                Pieza rb = new Rey(i,j+1,Color.B);
                                problema[i][j] = rb;
                                break;
                            case "DN":
                                Pieza dn = new Dama(i,j+1,Color.N);
                                problema[i][j] = dn;
                                break;
                            case "DB":
                                Pieza db = new Dama(i,j+1,Color.B);
                                problema[i][j] = db;
                                break;
                        }
                    }
                }
            Tablero t = new Tablero(problema,soluciones);
            Tableros.add(t);
            }
            
            
            else{
                throw new TablaNoValidaException(); 
                    }
            
            }
            catch(java.io.FileNotFoundException fnfex) {
                throw fnfex;
            }
            catch(java.io.IOException ioex) {
            System.out.println("Excepción de E/S:" + ioex);
            }
    }           
    
//    public void MostrarListaP(){
//        
//    }
//    public void elegirProblema(){
//        
//    }
    
//    public void Menu(){ ESTO HAY QUE HACER LA INTERFAZ
//        
//    }
    
    
    
}
