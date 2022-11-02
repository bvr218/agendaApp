/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
/**
 *
 * @author fvr
 */
public class Archivo {

    public String[] leer(){
        String []datos = {"",""};
        byte[] bdecodes;
        File archivo;
        FileReader fr;
        BufferedReader br;
        try{
           archivo = new File("Usr.txt");
           fr = new FileReader(archivo);
           br = new BufferedReader(fr);
           String linea;
           int i = 0;
           while((linea = br.readLine()) != null){
               bdecodes = Base64.getDecoder().decode(linea);
               datos[i] = new String(bdecodes);
               i++;
           }
           fr.close();
        }
        catch(IOException e){
            
        }
        
       
       return datos;
    }
    public void escribir(String Usuario, String Contraseña){
            File f;
            FileWriter w;
            BufferedWriter bw;
            PrintWriter pw;
            Usuario = Base64.getEncoder().encodeToString(Usuario.getBytes());
            Contraseña = Base64.getEncoder().encodeToString(Contraseña.getBytes());
            
        try{
            f = new File("Usr.txt");
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            pw = new PrintWriter(bw);
            pw.write(Usuario + "\r\n"+ Contraseña);
            pw.close();
            bw.close();
        }
        catch(IOException e){ 
        }
    }
    
}
