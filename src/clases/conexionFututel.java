/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author fvr
 */
public class conexionFututel {

    private static Connection cn = null;
    int i=0;

    public boolean establecer() {
        if (cn == null) {
            String[] datos = new String[5];
            ArchivoC1 establecer = new ArchivoC1();
            datos = establecer.leer();
            try {
                
                cn = DriverManager.getConnection("jdbc:mysql://" + datos[1] + ":" + datos[2] + "/" + datos[0] + "?user=" + datos[3] + "&password=" + datos[4] + "&useSSL=false&amp;allowMultiQueries=true&amp;autoReconnect=true&amp;useUnicode=yes&amp;characterEncoding=UTF-8&amp;sessionVariables=sql_mode=''");

                return true;
            } catch (Exception e) {
                
                cn = null;
                return false;
            }
        }
        else{
            if (i > 100) {
                try {
                    PreparedStatement pst = getcn().prepareStatement("show processlist");
                    pst.execute();
                } catch (Exception e) {
                    cn = null;
                    return false;
                }
                 i=0;
            }
            else{
                i++;
            }
            return true;
        }

    }

    public Connection getcn() {

        return cn;
    }
}
