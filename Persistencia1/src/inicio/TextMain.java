/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicio;

import java.util.List;
import modelo.Persona;
import persistencia.Archivo;

/**
 *
 * @author Estudiante
 */
public class TextMain {

   
    public static void main(String[] args) {
          Archivo archi =new Archivo();
//        Persona p1=new Persona(1234,"noe","arcos");
//        Persona p2=new Persona(1243,"braya","ghsa");
//        Persona p3=new Persona(1343,"sdasda","ghsa");
//        
//        archi.escribir(p1);
//        archi.escribir(p2);
//        archi.escribir(p3);
        List<Persona> lista=archi.lectura();
        if(lista!=null){
            for(Persona i: lista){
                System.out.println(i.toString());
            }
        }else{
            System.out.println("La lista no existe");
        }
        
    }
    
}
