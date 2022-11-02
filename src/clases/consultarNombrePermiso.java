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
public class consultarNombrePermiso {

    public String tipo;

    public void consultar() {
    }

    public boolean devolver(String Nombre) {
        boolean info = false;

        try {
            
            PreparedStatement pst = mantenerConexion.conectando.getconec1().getcn().prepareStatement("select * from login WHERE username = ?");
            pst.setString(1, Nombre);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                info = true;
            } else {
                info = false;
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "servidor desconectado, conectese a internet o contacte con su servidor");
        }

        return info;

    }
}
