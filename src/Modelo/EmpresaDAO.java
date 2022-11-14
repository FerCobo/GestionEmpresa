package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class EmpresaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarEmpresa(Empresa ep){
        String sql = "INSERT INTO tiendas (nombre, cif, localidad, usuario, pass, correo, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ep.getNameEmp()); //indicamos que va a ser la posición 1 (nombre), y lo que vamos a insertar
            ps.setString(2, ep.getCif());
            ps.setString(3, ep.getPlace());
            ps.setString(4, ep.getUser());
            ps.setString(5, ep.getPass());
            ps.setString(6, ep.getMail());
            ps.setInt(7, ep.getPhone());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
