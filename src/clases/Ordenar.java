/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventanas.mantenerConexion;

/**
 *
 * @author fvr
 */
public class Ordenar {

    public void Ordenar() {

    }

    public void OrdenarPor(String tipo, String dato, String Zona, DefaultTableModel modelo) {
        String[] info = new String[11];
        try {
            PreparedStatement pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("");

            if (Zona.equals("todos")) {
                if (tipo.equals("instalaciones")) {
                    switch (dato) {
                        case "Nombre":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.estate != \"INSTALADO\" ORDER by cliente; ");
                            break;
                        case "Fecha para instalacion":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.estate != \"INSTALADO\" ORDER by fecha_instalacion; ");
                            break;
                        case "Estado":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.estate != \"INSTALADO\"  ORDER by estate; ");
                            break;
                        case "Codigo":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.estate != \"INSTALADO\"  ORDER by instalaciones.id; ");
                            break;
                    }

                } else {
                    switch (dato) {
                        case "Nombre":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" ORDER by idcliente; ");
                            break;
                        case "Fecha para instalacion":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" ORDER by fecha_instalacion; ");
                            break;
                        case "Estado":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" ORDER by estate; ");
                            break;
                        case "Codigo":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" ORDER by agendasvarias.id; ");
                            break;

                    }
                    pst.setString(1, tipo);
                }

            } else {
                if (tipo.equals("instalaciones")) {
                    switch (dato) {
                        case "Nombre":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.zona = ? AND instalaciones.estate != \"INSTALADO\" ORDER by cliente; ");
                            break;
                        case "Fecha para instalacion":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.zona = ? AND instalaciones.estate != \"INSTALADO\" ORDER by fecha_instalacion; ");
                            break;
                        case "Estado":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.zona = ? AND instalaciones.estate != \"INSTALADO\"  ORDER by estate; ");
                            break;
                        case "Codigo":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.zona = ? AND instalaciones.estate != \"INSTALADO\"  ORDER by instalaciones.id; ");
                            break;
                    }

                    pst.setString(1, Zona);
                } else {
                    switch (dato) {
                        case "Nombre":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.zona = ? AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" ORDER by idcliente; ");
                            break;
                        case "Fecha para instalacion":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.zona = ? AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" ORDER by fecha_instalacion; ");
                            break;
                        case "Estado":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.zona = ? AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" ORDER by estate; ");
                            break;
                        case "Codigo":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.zona = ? AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" ORDER by agendasvarias.id; ");
                            break;

                    }
                    pst.setString(2, tipo);
                    pst.setString(1, Zona);
                }
            }

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if (tipo.equals("instalaciones")) {
                    do {
                        info[1] = rs.getString("cliente");
                        info[2] = rs.getString("fecha_instalacion").substring(0, 10);
                        info[3] = rs.getString("notas");
                        switch (rs.getString("estate")) {
                            case "PENDIENTE":
                                info[4] = "pendiente";
                                break;
                            case "ASIGNADO":
                                info[4] = "asignado";
                                break;
                            case "INSTALADO":
                                info[4] = "realizado";
                                break;
                        }

                        info[5] = rs.getString("cedula");
                        info[0] = rs.getString("instalaciones.id");

                        info[6] = rs.getString("zonas.nombre");
                        info[7] = rs.getString("login.nombre");
                        info[8] = rs.getString("fecha_asignacion");
                        info[9] = "null";
                        info[10] = rs.getString("direccion");
                        modelo.addRow(info);

                    } while (rs.next());
                } else {
                    do {

                        info[1] = rs.getString("nombrecliente");
                        info[2] = rs.getString("fecha_instalacion");
                        info[3] = rs.getString("comentarios");
                        switch (rs.getString("estate")) {
                            case "PENDIENTE":
                                info[4] = "pendiente";
                                break;
                            case "ASIGNADO":
                                info[4] = "asignado";
                                break;
                            case "INSTALADO":
                                info[4] = "realizado";
                                break;
                        }

                        info[5] = rs.getString("cedula");
                        info[0] = rs.getString("agendasvarias.id");
                        info[6] = rs.getString("zonas.nombre");
                        info[7] = rs.getString("login.nombre");
                        info[8] = rs.getString("fecha_asignacion");
                        info[9] = rs.getString("status");
                        info[10] = rs.getString("direccion");
                        modelo.addRow(info);

                    } while (rs.next());
                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void OrdenarPor(String tipo, String dato, String Zona, String por, String buscar, DefaultTableModel modelo) {
        String[] info = new String[11];
        try {
            PreparedStatement pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("");

            if (Zona.equals("todos")) {
                if (tipo.equals("instalaciones")) {
                    switch (dato) {
                        case "Nombre":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by cliente; ");
                            break;
                        case "Fecha para instalacion":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by fecha_instalacion; ");
                            break;
                        case "Estado":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%'  ORDER by estate; ");
                            break;
                        case "Codigo":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by instalaciones.id; ");
                            break;
                    }

                } else {
                    switch (dato) {
                        case "Nombre":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by idcliente; ");
                            break;
                        case "Fecha para instalacion":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by fecha_instalacion; ");
                            break;
                        case "Estado":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by estate; ");
                            break;
                        case "Codigo":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by agendasvarias.id; ");
                            break;

                    }
                    pst.setString(1, tipo);
                }

            } else {
                if (tipo.equals("instalaciones")) {
                    switch (dato) {
                        case "Nombre":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.zona = ? AND instalaciones.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by cliente; ");
                            break;
                        case "Fecha para instalacion":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.zona = ? AND instalaciones.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by fecha_instalacion; ");
                            break;
                        case "Estado":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.zona = ? AND instalaciones.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%'  ORDER by estate; ");
                            break;
                        case "Codigo":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `instalaciones` INNER JOIN zonas,login WHERE instalaciones.zona = zonas.id AND instalaciones.idtecnico = login.id AND instalaciones.zona = ? AND instalaciones.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by instalaciones.id; ");
                            break;
                    }

                    pst.setString(1, Zona);
                } else {
                    switch (dato) {
                        case "Nombre":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.zona = ? AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by idcliente; ");
                            break;
                        case "Fecha para instalacion":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.zona = ? AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by fecha_instalacion; ");
                            break;
                        case "Estado":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.zona = ? AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by estate; ");
                            break;
                        case "Codigo":
                            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT * FROM `agendasvarias` INNER JOIN zonas,login WHERE agendasvarias.zona = zonas.id AND agendasvarias.idtecnico = login.id AND agendasvarias.zona = ? AND agendasvarias.tipo = ? AND agendasvarias.estate != \"INSTALADO\" and " + por + " like '%" + buscar + "%' ORDER by agendasvarias.id; ");
                            break;

                    }
                    pst.setString(2, tipo);
                    pst.setString(1, Zona);
                }
            }

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if (tipo.equals("instalaciones")) {
                    do {
                        info[1] = rs.getString("cliente");
                        info[2] = rs.getString("fecha_instalacion").substring(0, 10);
                        info[3] = rs.getString("notas");
                        switch (rs.getString("estate")) {
                            case "PENDIENTE":
                                info[4] = "pendiente";
                                break;
                            case "ASIGNADO":
                                info[4] = "asignado";
                                break;
                            case "INSTALADO":
                                info[4] = "realizado";
                                break;
                        }

                        info[5] = rs.getString("cedula");
                        info[0] = rs.getString("instalaciones.id");

                        info[6] = rs.getString("zonas.nombre");
                        info[7] = rs.getString("login.nombre");
                        info[8] = rs.getString("fecha_asignacion");
                        info[9] = "null";
                        info[10] = rs.getString("direccion");
                        modelo.addRow(info);

                    } while (rs.next());
                } else {
                    do {

                        info[1] = rs.getString("nombrecliente");
                        info[2] = rs.getString("fecha_instalacion");
                        info[3] = rs.getString("comentarios");
                        switch (rs.getString("estate")) {
                            case "PENDIENTE":
                                info[4] = "pendiente";
                                break;
                            case "ASIGNADO":
                                info[4] = "asignado";
                                break;
                            case "INSTALADO":
                                info[4] = "realizado";
                                break;
                        }

                        info[5] = rs.getString("cedula");
                        info[0] = rs.getString("agendasvarias.id");
                        info[6] = rs.getString("zonas.nombre");
                        info[7] = rs.getString("login.nombre");
                        info[8] = rs.getString("fecha_asignacion");
                        info[9] = rs.getString("status");
                        info[10] = rs.getString("direccion");
                        modelo.addRow(info);

                    } while (rs.next());
                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /*
    public void OrdenarPor(String tipo, String dato, DefaultTableModel modelo) {
        consultar consul = new consultar();
        String[] info = new String[7];
        String[] cliente = new String[6];
        try {
            PreparedStatement pst = conec.getcn().prepareStatement("");

            if (tipo.equals("instalaciones")) {
                switch (dato) {
                    case "Nombre":
                        pst = conec.getcn().prepareStatement("SELECT * FROM agendasrealizadas ORDER by cliente; ");
                        break;
                    case "Fecha para instalacion":
                        pst = conec.getcn().prepareStatement("SELECT * FROM agendasrealizadas ORDER by fecha_instalacion; ");
                        break;
                    case "Estado":
                        pst = conec.getcn().prepareStatement("SELECT * FROM agendasrealizadas  ORDER by estate; ");
                        break;
                    case "Codigo":
                        pst = conec.getcn().prepareStatement("SELECT * FROM agendasrealizadas  ORDER by id; ");
                        break;
                }

            } else {
                switch (dato) {
                    case "Nombre":
                        pst = conec.getcn().prepareStatement("SELECT * FROM agendasrealizadas WHERE tipo = ? ORDER by idcliente; ");
                        break;
                    case "Fecha para instalacion":
                        pst = conec.getcn().prepareStatement("SELECT * FROM agendasrealizadas WHERE tipo = ? ORDER by fecha_instalacion; ");
                        break;
                    case "Estado":
                        pst = conec.getcn().prepareStatement("SELECT * FROM agendasrealizadas WHERE tipo = ? ORDER by estate; ");
                        break;
                    case "Codigo":
                        pst = conec.getcn().prepareStatement("SELECT * FROM agendasrealizadas WHERE tipo = ? ORDER by id; ");
                        break;

                }
                pst.setString(1, tipo);
            }

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                do {
                    info[0] = rs.getString("id");
                    info[1] = rs.getString("fecha_instalacion").substring(0, 10);
                    info[2] = rs.getString("tipo");
                    info[3] = rs.getString("zona");
                    info[3] = consul.devolver(info[3]);
                    info[4] = rs.getString("nombrecliente");
                    info[5] = rs.getString("nombreTecnico");

                    modelo.addRow(info);

                } while (rs.next());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

     */
    public void OrdenarPor(String tipo, DefaultTableModel modelo) {

        String[] info = new String[5];
        try {

            PreparedStatement pst;

            pst = mantenerConexion.conectando.getconec1().getcn().prepareStatement("SELECT * FROM login WHERE privilege = ? ORDER by nombre; ");
            switch (tipo) {
                case "admin":
                    tipo = "0";
                    pst.setString(1, tipo);
                    break;
                case "oficina":
                    tipo = "1";
                    pst.setString(1, tipo);
                    break;
                case "tecnico":
                    tipo = "2";
                    pst.setString(1, tipo);
                    break;
                default:
                    pst = mantenerConexion.conectando.getconec1().getcn().prepareStatement("SELECT * FROM login ORDER by nombre; ");
                    break;
            }

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                do {
                    info[0] = rs.getString("Nombre");
                    info[1] = rs.getString("correo");
                    info[3] = rs.getString("username");
                    switch (rs.getString("privilege")) {
                        case "0":
                            info[2] = "admin";
                            break;
                        case "1":
                            info[2] = "oficina";
                            break;
                        case "2":
                            info[2] = "tecnico";
                            break;
                    }

                    modelo.addRow(info);

                } while (rs.next());

            }
        } catch (SQLException e) {

        }

    }

    public void OrdenarEJ(String tipo, String dato, String Tecnico, DefaultTableModel modelo) {

        String[] info = new String[10];

        try {
            PreparedStatement pst;
            if (Tecnico.equals("todos")) {
                if (tipo.equals("instalaciones")) {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,instalaciones where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = instalaciones.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? ORDER by agendasrealizadas." + dato);

                    pst.setString(1, tipo);
                } else {

                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,agendasvarias where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = agendasvarias.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? ORDER by agendasrealizadas." + dato);

                    pst.setString(1, tipo);
                }

            } else {
                if (tipo.equals("instalaciones")) {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,instalaciones where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = instalaciones.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.idtecnico = ? and agendasrealizadas.tipo = ? ORDER by agendasrealizadas." + dato);

                    pst.setString(1, Tecnico);
                    pst.setString(2, tipo);
                } else {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,agendasvarias where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = agendasvarias.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.idtecnico = ? and agendasrealizadas.tipo = ? ORDER by agendasrealizadas." + dato);

                    pst.setString(1, Tecnico);
                    pst.setString(2, tipo);
                }

            }
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                do {

                    info[0] = rs.getString("agendasrealizadas.iddeagenda");
                    info[1] = rs.getString("agendasrealizadas.fecha_instalacion");
                    info[3] = rs.getString("zonas.nombre");
                    info[4] = rs.getString("agendasrealizadas.nombrecliente");
                    info[5] = rs.getString("login.nombre");
                    info[6] = rs.getString("pagos.estadoC");
                    info[7] = rs.getString("pagos.estadoT");
                    info[8] = rs.getString("ubicacion");
                    info[9] = rs.getString("agendasrealizadas.cedula");
                    if (tipo.equals("instalaciones")) {
                        info[2] = rs.getString("fecha_creacion");
                    } else {
                        info[2] = rs.getString("agendasvarias.fecha_instalacion");
                    }

                    modelo.addRow(info);

                } while (rs.next());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "m-" + e);

        }

    }

    public void OrdenarEJ(String tipo, String dato, String Tecnico, DefaultTableModel modelo, String o) {
        LocalDate fechaA = LocalDate.now();
        String fechaCorte;
        int año = Integer.parseInt(fechaA.toString().substring(0, 4));
        int mes = Integer.parseInt(fechaA.toString().substring(5, 7));
        int dia = Integer.parseInt(fechaA.toString().substring(8, 10));
        if (dia <= 14) {
            if (mes == 1) {
                año = año - 1;
                mes = 12;
            } else {
                mes = mes - 1;
            }
            if (mes <= 9) {
                fechaCorte = String.valueOf(año) + "-0" + String.valueOf(mes) + "-14";
            } else {
                fechaCorte = String.valueOf(año) + "-" + String.valueOf(mes) + "-14";
            }

        } else {

            if (mes <= 9) {
                fechaCorte = String.valueOf(año) + "-0" + String.valueOf(mes) + "-14";
            } else {
                fechaCorte = String.valueOf(año) + "-" + String.valueOf(mes) + "-14";
            }
        }

        String[] info = new String[10];

        try {
            PreparedStatement pst;
            if (Tecnico.equals("todos")) {
                if (tipo.equals("instalaciones")) {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,instalaciones where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = instalaciones.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? and agendasrealizadas.fecha_instalacion >= ? ORDER by agendasrealizadas." + dato);

                    pst.setString(1, tipo);
                    pst.setString(2, fechaCorte);
                } else {

                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,agendasvarias where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = agendasvarias.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? and agendasrealizadas.fecha_instalacion >= ? ORDER by agendasrealizadas." + dato);

                    pst.setString(1, tipo);
                    pst.setString(2, fechaCorte);
                }

            } else {
                if (tipo.equals("instalaciones")) {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,instalaciones where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = instalaciones.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.idtecnico = ? and agendasrealizadas.tipo = ?  and agendasrealizadas.fecha_instalacion >= ? ORDER by agendasrealizadas." + dato);

                    pst.setString(1, Tecnico);
                    pst.setString(2, tipo);
                    pst.setString(3, fechaCorte);
                } else {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,agendasvarias where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = agendasvarias.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.idtecnico = ? and agendasrealizadas.tipo = ?  and agendasrealizadas.fecha_instalacion >= ? ORDER by agendasrealizadas." + dato);

                    pst.setString(1, Tecnico);
                    pst.setString(2, tipo);
                    pst.setString(3, fechaCorte);
                }

            }
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                do {

                    info[0] = rs.getString("agendasrealizadas.iddeagenda");
                    info[1] = rs.getString("agendasrealizadas.fecha_instalacion");
                    info[3] = rs.getString("zonas.nombre");
                    info[4] = rs.getString("agendasrealizadas.nombrecliente");
                    info[5] = rs.getString("login.nombre");
                    info[6] = rs.getString("pagos.estadoC");
                    info[7] = rs.getString("pagos.estadoT");
                    info[8] = rs.getString("ubicacion");
                    info[9] = rs.getString("agendasrealizadas.cedula");
                    if (tipo.equals("instalaciones")) {
                        info[2] = rs.getString("fecha_creacion");
                    } else {
                        info[2] = rs.getString("agendasvarias.fecha_instalacion");
                    }

                    modelo.addRow(info);

                } while (rs.next());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void Consultar(String id, DefaultTableModel modelo) {
        consultar consul = new consultar();
        String[] info = new String[4];
        try {

            PreparedStatement pst;

            pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("SELECT fecha_hora,estado,idtecnico,actor FROM historialagendas WHERE idagenda = ?");
            pst.setString(1, id);
            String[] tecnico;
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                do {
                    info[0] = rs.getString("fecha_hora");
                    info[1] = rs.getString("estado");
                    info[2] = rs.getString("idtecnico");
                    tecnico = consul.devolverU(info[2]);
                    info[2] = tecnico[0];
                    info[3] = rs.getString("actor");

                    modelo.addRow(info);

                } while (rs.next());

            }
        } catch (SQLException e) {

        }

    }

    public String[] OrdenarEJ(String id) {
        String[] info = new String[7];

        try {

            PreparedStatement pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join login,pagos where agendasrealizadas.idtecnico = login.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.iddeagenda = ? LIMIT 1");

            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                do {

                    info[0] = rs.getString("agendasrealizadas.id");
                    info[1] = rs.getString("login.nombre");
                    info[2] = rs.getString("correo");
                    info[3] = rs.getString("nombrecliente");
                    info[4] = rs.getString("tipo");
                    info[5] = rs.getString("estadoT");
                    info[6] = rs.getString("valortecnico");

                } while (rs.next());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return info;
    }

    public void OrdenarEJ(String opcion,String buscar,String tipo, String dato, String Tecnico, DefaultTableModel modelo) {

        String[] info = new String[10];

        try {
            PreparedStatement pst;
            if (Tecnico.equals("todos")) {
                if (tipo.equals("instalaciones")) {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,instalaciones where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = instalaciones.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? and "+opcion+" like '"+buscar+"%' ORDER by agendasrealizadas." + dato);

                    pst.setString(1, tipo);
                } else {

                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,agendasvarias where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = agendasvarias.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? and "+opcion+" like '"+buscar+"%' ORDER by agendasrealizadas." + dato);

                    pst.setString(1, tipo);
                }

            } else {
                if (tipo.equals("instalaciones")) {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,instalaciones where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = instalaciones.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.idtecnico = ? and agendasrealizadas.tipo = ? and "+opcion+" like '"+buscar+"%' ORDER by agendasrealizadas." + dato);

                    pst.setString(1, Tecnico);
                    pst.setString(2, tipo);
                } else {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,agendasvarias where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = agendasvarias.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.idtecnico = ? and agendasrealizadas.tipo = ? and "+opcion+" like '"+buscar+"%' ORDER by agendasrealizadas." + dato);

                    pst.setString(1, Tecnico);
                    pst.setString(2, tipo);
                }

            }
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                do {

                    info[0] = rs.getString("agendasrealizadas.iddeagenda");
                    info[1] = rs.getString("agendasrealizadas.fecha_instalacion");
                    info[3] = rs.getString("zonas.nombre");
                    info[4] = rs.getString("agendasrealizadas.nombrecliente");
                    info[5] = rs.getString("login.nombre");
                    info[6] = rs.getString("pagos.estadoC");
                    info[7] = rs.getString("pagos.estadoT");
                    info[8] = rs.getString("ubicacion");
                    info[9] = rs.getString("agendasrealizadas.cedula");
                    if (tipo.equals("instalaciones")) {
                        info[2] = rs.getString("fecha_creacion");
                    } else {
                        info[2] = rs.getString("agendasvarias.fecha_instalacion");
                    }

                    modelo.addRow(info);

                } while (rs.next());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "m-" + e);

        }

    }

    public void OrdenarEJ(String opcion,String buscar,String tipo, String dato, String Tecnico, DefaultTableModel modelo, String o) {
        LocalDate fechaA = LocalDate.now();
        String fechaCorte;
        int año = Integer.parseInt(fechaA.toString().substring(0, 4));
        int mes = Integer.parseInt(fechaA.toString().substring(5, 7));
        int dia = Integer.parseInt(fechaA.toString().substring(8, 10));
        if (dia <= 14) {
            if (mes == 1) {
                año = año - 1;
                mes = 12;
            } else {
                mes = mes - 1;
            }
            if (mes <= 9) {
                fechaCorte = String.valueOf(año) + "-0" + String.valueOf(mes) + "-14";
            } else {
                fechaCorte = String.valueOf(año) + "-" + String.valueOf(mes) + "-14";
            }

        } else {

            if (mes <= 9) {
                fechaCorte = String.valueOf(año) + "-0" + String.valueOf(mes) + "-14";
            } else {
                fechaCorte = String.valueOf(año) + "-" + String.valueOf(mes) + "-14";
            }
        }

        String[] info = new String[10];

        try {
            PreparedStatement pst;
            if (Tecnico.equals("todos")) {
                if (tipo.equals("instalaciones")) {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,instalaciones where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = instalaciones.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? and agendasrealizadas.fecha_instalacion >= ? and "+opcion+" like '"+buscar+"%' ORDER by agendasrealizadas." + dato);

                    pst.setString(1, tipo);
                    pst.setString(2, fechaCorte);
                } else {

                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,agendasvarias where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = agendasvarias.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.tipo = ? and agendasrealizadas.fecha_instalacion >= ? and "+opcion+" like '"+buscar+"%' ORDER by agendasrealizadas." + dato);

                    pst.setString(1, tipo);
                    pst.setString(2, fechaCorte);
                }

            } else {
                if (tipo.equals("instalaciones")) {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,instalaciones where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = instalaciones.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.idtecnico = ? and agendasrealizadas.tipo = ?  and agendasrealizadas.fecha_instalacion >= ? and "+opcion+" like '"+buscar+"%' ORDER by agendasrealizadas." + dato);

                    pst.setString(1, Tecnico);
                    pst.setString(2, tipo);
                    pst.setString(3, fechaCorte);
                } else {
                    pst = mantenerConexion.conectando.getconec2().getcn().prepareStatement("select * from agendasrealizadas inner join zonas,login,pagos,agendasvarias where agendasrealizadas.zona = zonas.id and agendasrealizadas.iddeagenda = agendasvarias.id and agendasrealizadas.iddeagenda = pagos.iddeagenda and agendasrealizadas.idtecnico = login.id and agendasrealizadas.idtecnico = ? and agendasrealizadas.tipo = ?  and agendasrealizadas.fecha_instalacion >= ? and "+opcion+" like '"+buscar+"%' ORDER by agendasrealizadas." + dato);

                    pst.setString(1, Tecnico);
                    pst.setString(2, tipo);
                    pst.setString(3, fechaCorte);
                }

            }
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                do {

                    info[0] = rs.getString("agendasrealizadas.iddeagenda");
                    info[1] = rs.getString("agendasrealizadas.fecha_instalacion");
                    info[3] = rs.getString("zonas.nombre");
                    info[4] = rs.getString("agendasrealizadas.nombrecliente");
                    info[5] = rs.getString("login.nombre");
                    info[6] = rs.getString("pagos.estadoC");
                    info[7] = rs.getString("pagos.estadoT");
                    info[8] = rs.getString("ubicacion");
                    info[9] = rs.getString("agendasrealizadas.cedula");
                    if (tipo.equals("instalaciones")) {
                        info[2] = rs.getString("fecha_creacion");
                    } else {
                        info[2] = rs.getString("agendasvarias.fecha_instalacion");
                    }

                    modelo.addRow(info);

                } while (rs.next());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
