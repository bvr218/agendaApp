package clases;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import ventanas.mantenerConexion;

/**
 *
 * @author fvr
 */
public class consultarNickPas {

    public String[] tipo = new String[2];

    public void consultar() {
    }

    public boolean devolver(String Nick, String pas) {
        boolean info = false;

        try {
            
            PreparedStatement pst =mantenerConexion.conectando.getconec1().getcn().prepareStatement("select * from login WHERE username = ?");

            pst.setString(1, Nick);
            ResultSet rs = pst.executeQuery();
            
            pas=getMD5(pas);
            
            if (rs.next()) {
                tipo[0] = rs.getString("privilege");
                if (rs.getString("password").equals(pas)) {
                    info = true;
                    tipo[1] = rs.getString("nombre");

                } else {
                    info = false;
                    JOptionPane.showMessageDialog(null, "Nick y/o contraseña incorrecta");
                }

            } else {
                info = false;
                JOptionPane.showMessageDialog(null, "Nick y/o contraseña incorrecta");
            }

        } catch (Exception e) {

           

        }
        return info;
    }

    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
