/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ventanas.mantenerConexion;

/**
 *
 * @author fvr
 */
public class consultar {

    public void consultar() {
    }

    public String[] devolver(String id, String tipo) {
        String[] info = new String[15];
        String[] cliente = new String[6];
        consultar consul = new consultar();

        if (tipo.equals("instalaciones")) {
            try {

                PreparedStatement pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from instalaciones INNER JOIN login WHERE instalaciones.idtecnico = login.id and instalaciones.id = ? ");

                pst.setString(1, id);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    info[0] = rs.getString("fecha_instalacion");
                    info[1] = rs.getString("cliente");
                    info[2] = rs.getString("cedula");
                    info[3] = rs.getString("movil");
                    info[4] = rs.getString("notas");
                    info[5] = rs.getString("direccion");
                    info[6] = rs.getString("idvendedor");

                    info[7] = rs.getString("login.nombre");

                    info[8] = rs.getString("estate");
                    info[9] = rs.getString("zona");
                    info[10] = rs.getString("instalaciones.id");
                    info[11] = rs.getString("instalaciones.idtecnico");
                    info[12] = rs.getString("valor");
                    return info;

                } else {

                    return null;
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
            }
        } else {
            try {

                PreparedStatement pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasvarias INNER JOIN login WHERE agendasvarias.idtecnico = login.id and tipo = ? and agendasvarias.id = ?");

                pst.setString(1, tipo);
                pst.setString(2, id);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    info[0] = rs.getString("fecha_instalacion");
                    info[1] = rs.getString("nombrecliente");
                    info[2] = rs.getString("cedula");
                    info[3] = rs.getString("movil");
                    info[4] = rs.getString("comentarios");
                    info[5] = rs.getString("direccion");
                    info[6] = rs.getString("idagendador");

                    info[7] = rs.getString("login.nombre");

                    info[8] = rs.getString("estate");
                    info[9] = rs.getString("zona");
                    info[10] = rs.getString("agendasvarias.id");
                    info[11] = rs.getString("idcliente");
                    info[12] = tipo;
                    info[13] = rs.getString("idtecnico");
                    info[14] = rs.getString("valor");
                    return info;

                } else {

                    return null;
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
            }
        }

    }

    public String devolver(String zona) {
        String info;

        try {

            PreparedStatement pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from zonas WHERE id = ?");

            pst.setString(1, zona);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                info = rs.getString("nombre");
                return info;

            } else {
                info = "sin zona";
                return info;
            }

        } catch (Exception e) {

            return null;
        }

    }

    public String[] devolver(String id, String tipo, String otro1) {
        String[] info = new String[14];

        try {

            PreparedStatement pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? and agendasrealizadas.iddeagenda = ? ORDER by fecha_instalacion");
            pst.setString(1, tipo);
            pst.setString(2, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                info[0] = rs.getString("comentarios");
                info[1] = rs.getString("tipo");
                info[2] = rs.getString("fecha_instalacion");
                info[3] = rs.getString("zona");
                info[4] = rs.getString("idtecnico");
                info[5] = rs.getString("nombrecliente");
                info[6] = rs.getString("agendasrealizadas.iddeagenda");
                info[7] = rs.getString("idagendador");
                info[8] = rs.getString("login.nombre");
                info[9] = rs.getString("valor");
                info[10] = rs.getString("valortecnico");
                info[11] = rs.getString("pagos.estadoC");
                info[12] = rs.getString("pagos.estadoT");
                info[13] = rs.getString("fecha_cobro");

                return info;

            } else {
                info = null;
                return info;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public String[] devolverU(String username, String privilege) {
        String[] info = new String[6];

        try {
            PreparedStatement pst;
            if (privilege.equals("todos")) {
                pst = mantenerConexion.conectando.getconec1().getcn().prepareStatement("select * from login WHERE username = ? AND estado = '1' AND id!='0'");
                pst.setString(1, username);
            } else {
                pst = mantenerConexion.conectando.getconec1().getcn().prepareStatement("select * from login WHERE username = ? and privilege = ? AND estado = '1' AND id!='0'");
                pst.setString(1, username);

                switch (privilege) {
                    case "admin":
                        pst.setString(2, "0");
                        break;
                    case "oficina":
                        pst.setString(2, "1");
                        break;
                    case "tecnico":
                        pst.setString(2, "2");
                        break;

                }

            }

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                info[0] = rs.getString("nombre");
                info[1] = rs.getString("correo");
                info[3] = rs.getString("username");
                info[5] = rs.getString("password");
                info[4] = rs.getString("id");
                switch (rs.getString("privilege")) {
                    case "admin":
                        info[2] = "0";
                        break;
                    case "oficina":
                        info[2] = "1";
                        break;
                    case "tecnico":
                        info[2] = "2";
                        break;
                    case "0":
                        info[2] = "0";
                        break;
                    case "1":
                        info[2] = "1";
                        break;
                    case "2":
                        info[2] = "2";
                        break;

                }

                return info;

            } else {
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en la conexion" + e);
            return null;
        }

    }

    public String[] devolverU(String id) {
        String[] info = new String[5];

        try {

            PreparedStatement pst = mantenerConexion.conectando.getconec1().getcn().prepareStatement("select * from login WHERE id = ?");
            pst.setString(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                info[0] = rs.getString("nombre");
                info[1] = rs.getString("correo");
                info[3] = rs.getString("username");
                info[4] = rs.getString("id");
                switch (rs.getString("privilege")) {
                    case "admin":
                        info[2] = "0";
                        break;
                    case "oficina":
                        info[2] = "1";
                        break;
                    case "tecnico":
                        info[2] = "2";
                        break;
                    case "0":
                        info[2] = "0";
                        break;
                    case "1":
                        info[2] = "1";
                        break;
                    case "2":
                        info[2] = "2";
                        break;

                }

                return info;

            } else {
                JOptionPane.showMessageDialog(null, "error en la conexion");
                return null;
            }

        } catch (SQLException e) {

            return null;
        }

    }

    public String[] devolverC(String id) {
        String[] info = new String[7];

        try {

            PreparedStatement pst
                    = mantenerConexion.conectando.getconec1().getcn().prepareStatement("select nombre,tblservicios.direccion,usuarios.movil,usuarios.cedula,idcliente,estado,instalaciones.zona "
                            + "from usuarios"
                            + " inner join instalaciones,tblservicios WHERE tblservicios.idcliente = usuarios.id and instalaciones.userid = usuarios.id and userid = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                info[0] = rs.getString("nombre");
                info[1] = rs.getString("tblservicios.direccion");
                info[2] = rs.getString("usuarios.movil");
                info[3] = rs.getString("usuarios.cedula");
                info[4] = rs.getString("idcliente");
                info[5] = rs.getString("instalaciones.zona");
                info[6] = rs.getString("estado");

                return info;

            } else {

                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en la conexion" + e);
            return null;
        }

    }
    public String[] devolverCC(String id) {
        String[] info = new String[8];

        try {

            PreparedStatement pst
                    = mantenerConexion.conectando.getconec1().getcn().prepareStatement("select nombre,tblservicios.direccion,usuarios.movil,usuarios.cedula,idcliente,estado,instalaciones.zona "
                            + "from usuarios"
                            + " inner join instalaciones,tblservicios WHERE tblservicios.idcliente = usuarios.id and instalaciones.userid = usuarios.id and usuarios.cedula = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                info[0] = rs.getString("nombre");
                info[1] = rs.getString("tblservicios.direccion");
                info[2] = rs.getString("usuarios.movil");
                info[3] = rs.getString("usuarios.cedula");
                info[4] = rs.getString("idcliente");
                info[5] = rs.getString("instalaciones.zona");
                info[6] = rs.getString("estado");

                return info;

            } else {

                return null;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error en la conexion" + e);
            return null;
        }

    }
}
