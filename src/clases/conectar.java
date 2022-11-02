/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


import javax.swing.JLabel;
import ventanas.mantenerConexion;

/**
 *
 * @author bvr217
 */
public class conectar implements Runnable {

    conexion bar;
    conexionFututel boton;
    mantenerConexion mantener;
    JLabel texto;

    @Override
    public void run() {
        int i = 0;

        
        while (this.getconec1().establecer() && this.getconec2().establecer()) {
            this.getmantener().setVisible(false);
        } 
        this.getmantener().reestablecer();
    }

    public void setconec1(conexion bar) {
        this.bar = bar;
    }

    public void setconec2(conexionFututel boton) {
        this.boton = boton;
    }

    public void setmantener(mantenerConexion mantener) {
        this.mantener = mantener;
    }

    public void settexto(JLabel texto) {
        this.texto = texto;
    }

    public conexionFututel getconec1() {
        return boton;
    }

    public conexion getconec2() {

        return bar;
    }

    public mantenerConexion getmantener() {
        return mantener;
    }

    public JLabel gettexto() {
        return texto;
    }

}
