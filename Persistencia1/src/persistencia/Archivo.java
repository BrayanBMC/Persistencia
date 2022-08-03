/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Persona;

/**
 *
 * @author Estudiante
 */
public class Archivo {
    private File fichero;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public Archivo() {
        fichero=new File("info.txt");
        if(!fichero.exists()){
            JOptionPane.showMessageDialog(null,"Mensaje","El archivo no existe",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Mensaje","El archivo ya existe",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void escribir(Persona nuevo){
        try {
            salida= new ObjectOutputStream(new FileOutputStream("info.txt",true));
            salida.writeUnshared(nuevo);
            salida.close();
            System.out.println("Objeto guardado");
        } catch (IOException ex) {
            System.out.println("error en escribir: "+ex.getMessage());
        }
       
        
    }
    
    public List <Persona> lectura(){
        FileInputStream fis =null;
        List<Persona> lista =null;
        try {
            lista=new ArrayList<Persona>();
            fis = new FileInputStream("info.txt");
            while(fis.available()>0){
                ObjectInputStream en =new ObjectInputStream(fis);
                Persona obj=(Persona) en.readUnshared();
                lista.add(obj);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error en lectura: "+ex.getMessage());
        } finally {
            try {
                if(fis!=null){
                   fis.close(); 
                }
                
            } catch (IOException ex) {
                System.out.println("Error en cerrar objeto de lista: "+ex.getMessage());
            }
           return lista;
        }
    }
    
    
}
