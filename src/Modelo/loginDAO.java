package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log(String usuario, String pass){
        login l = new login();
        String sql = "SELECT * FROM tiendas WHERE usuario = ? AND pass = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setId(rs.getInt("id_tienda"));
                l.setNameEmp(rs.getString("nombre"));
                l.setCif(rs.getString("cif"));
                l.setPlace(rs.getString("localidad"));
                l.setUser(rs.getString("usuario"));
                l.setPass(rs.getString("pass"));
                l.setMail(rs.getString("correo"));
                l.setPhone(rs.getInt("telefono"));
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
    
    
    
}
