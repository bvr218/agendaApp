/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author fvr
 */
public class colorcelda extends JTable {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int ColumnIndex) {
        Component componente = super.prepareRenderer(renderer, rowIndex, ColumnIndex);
            if (getValueAt(rowIndex, ColumnIndex).getClass().equals(String.class)) {
                String valor = this.getValueAt(rowIndex, ColumnIndex).toString();
                switch(this.getColumnName(ColumnIndex)){
                    case "Estado":
                        if (valor.trim().equals("pendiente")) {

                            componente.setBackground(Color.RED);
                            componente.setForeground(Color.BLACK);


                        } else if (valor.trim().equals("asignado")) {

                            componente.setBackground(Color.ORANGE);
                            componente.setForeground(Color.BLACK);


                        } else if (valor.trim().equals("realizado")) {
                            componente.setBackground(Color.GREEN);
                            componente.setForeground(Color.BLACK);


                        } else {

                            componente.setBackground(Color.WHITE);
                            componente.setForeground(Color.BLACK);

                        }
                        break;
                    case "fecha para instalacion":
                        if (new ValidadorFecha().TimeAgo(getValueAt(rowIndex, ColumnIndex).toString()) > 5) {
                            componente.setBackground(Color.GREEN);
                            componente.setForeground(Color.BLACK);
                        } else if (new ValidadorFecha().TimeAgo(getValueAt(rowIndex, ColumnIndex).toString()) > 2 && new ValidadorFecha().TimeAgo(getValueAt(rowIndex, ColumnIndex).toString()) <= 5) {
                            componente.setBackground(Color.ORANGE);
                            componente.setForeground(Color.BLACK);
                        } else if (new ValidadorFecha().TimeAgo(getValueAt(rowIndex, ColumnIndex).toString()) <= 2) {
                            componente.setBackground(Color.RED);
                            componente.setForeground(Color.BLACK);
                        }else {
                            componente.setBackground(Color.WHITE);
                            componente.setForeground(Color.BLACK);
                        }
                        break;
                    case "...":
                        if (valor.trim().equals("online")) {

                            componente.setBackground(Color.GREEN);
                            componente.setForeground(Color.BLACK);
                        } else if (valor.trim().equals("offline")) {
                            componente.setBackground(Color.RED);
                            componente.setForeground(Color.BLACK);
                        } else {
                            componente.setBackground(Color.WHITE);
                            componente.setForeground(Color.BLACK);
                        } 
                        break;
                    case "Fecha_Asignaciòn": 
                        if (new ValidadorFecha().TimeAgo(getValueAt(rowIndex, ColumnIndex).toString()) <= -2 && new ValidadorFecha().TimeAgo(getValueAt(rowIndex, ColumnIndex).toString()) >= -1000) {

                            componente.setBackground(Color.RED);
                            componente.setForeground(Color.BLACK);
                        } else if (new ValidadorFecha().TimeAgo(getValueAt(rowIndex, ColumnIndex).toString()) <= -1000) {
                            componente.setBackground(Color.WHITE);
                            componente.setForeground(Color.BLACK);
                        } else {
                            componente.setBackground(Color.GREEN);
                            componente.setForeground(Color.BLACK);
                        }
                        break;
                    case "estadoC":
                        if (valor.trim().equals("sin cobrar")) {

                            componente.setBackground(Color.ORANGE);
                            componente.setForeground(Color.BLACK);

                        } else if (valor.trim().equals("cobrado")) {
                            componente.setBackground(Color.GREEN);
                            componente.setForeground(Color.BLACK);
                        }else {
                            componente.setBackground(Color.WHITE);
                            componente.setForeground(Color.BLACK);
                        }
                        break;
                    case "estadoT":
                        if (valor.trim().equals("sin pagar")) {
                            componente.setBackground(Color.ORANGE);
                            componente.setForeground(Color.BLACK);

                        } else if (valor.trim().equals("aceptada")) {
                            componente.setBackground(Color.GREEN);
                            componente.setForeground(Color.BLACK);
                        } else if (valor.trim().equals("rechazada")) {
                            componente.setBackground(Color.RED);
                            componente.setForeground(Color.BLACK);
                        } else {
                            componente.setBackground(Color.WHITE);
                            componente.setForeground(Color.BLACK);
                        }
                        break;
                    default:
                        componente.setBackground(Color.WHITE);
                        componente.setForeground(Color.BLACK);
                        break;

                }



            }
        

        return componente;

    }

}
