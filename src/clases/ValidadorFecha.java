/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author fvr
 */
public class ValidadorFecha {
    private LocalDate fecha;
    private LocalDate fechaA = LocalDate.now();
    
   
    public ValidadorFecha(){
        
    }
    public int TimeAgo(String fecha){
       
       int time; 
       int año = Integer.parseInt(fecha.substring(0, 4));
       int mes = Integer.parseInt(fecha.substring(5, 7));
       int dia = Integer.parseInt(fecha.substring(8, 10));
       this.fecha = LocalDate.of(año, mes, dia);
       time = Math.toIntExact(ChronoUnit.DAYS.between(fechaA, this.fecha));
       
    return time;
    }
    public boolean validar(String fecha){
       boolean valido = false;
       
       
       try{
           int año = Integer.parseInt(fecha.substring(0, 4));
           int mes = Integer.parseInt(fecha.substring(5, 7));
           int dia = Integer.parseInt(fecha.substring(8, 10));
           this.fecha = LocalDate.of(año, mes, dia);
           
           valido = true;
       }
       catch(Exception e){
           
       }
        
    return valido;
    }
    public String Devolver(String fecha){
       String valido = "";

       try{
           int año = Integer.parseInt(fecha.substring(0, 4));
           int mes = Integer.parseInt(fecha.substring(5, 7));
           int dia = Integer.parseInt(fecha.substring(8, 10));
           valido = año+"-"+mes+"-"+dia;
       }
       catch(Exception e){
           
       }
        
    return valido;
    }
}
