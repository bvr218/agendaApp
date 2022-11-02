
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
import java.io.PrintWriter;
import java.util.Base64;
/**
 *
 * @author fvr
 */
public class ArchivoC {

    public String[] leer(){
        String []datos = new String[5];
        byte[] bdecodes;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{
           archivo = new File("conexion.txt");
           fr = new FileReader(archivo);
           br = new BufferedReader(fr);
           String linea;
           int i = 0;
           while((linea = br.readLine()) != null){
               bdecodes = Base64.getDecoder().decode(linea);
               datos[i] = new String(bdecodes);
               i++;
           }
           i = 0; 
           fr.close();
        }
        catch(Exception e){
            
        }
        
        
       return datos;
    }
    public void escribir(String NombreBase, String Url, String puerto, String User, String contraseña){
            File f;
            FileWriter w;
            BufferedWriter bw;
            PrintWriter pw;
            NombreBase = Base64.getEncoder().encodeToString(NombreBase.getBytes());
            Url = Base64.getEncoder().encodeToString(Url.getBytes());
            puerto = Base64.getEncoder().encodeToString(puerto.getBytes());
            User = Base64.getEncoder().encodeToString(User.getBytes());
            contraseña = Base64.getEncoder().encodeToString(contraseña.getBytes());
        try{
            f = new File("conexion.txt");
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            pw = new PrintWriter(bw);
            pw.write(NombreBase + "\r\n"+ Url + "\r\n"+ puerto + "\r\n"+ User + "\r\n" + contraseña);
            pw.close();
            bw.close();
        }
        catch(Exception e){ 

        }
    }
    
}
