/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ventanas.mantenerConexion;

/**
 *
 * @author bvr217
 */
public class Estado {

    public boolean buscar(String id) {
        boolean estado = false;
        try {
            PreparedStatement pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select status from agendasvarias where id=?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if(rs.getString("status").equals("online")) {
                    estado = true;
                }
                else{
                    estado = false;
                }
            }
        } catch (SQLException e) {
        }
        return estado;
    }

}
