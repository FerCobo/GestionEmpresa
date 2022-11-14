package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List ListarEmpleados(){
        List<Empleados> ListaEmp = new ArrayList();
        String sql = "SELECT * FROM empleados";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Empleados emp = new Empleados();
                emp.setDni(rs.getString("dni"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setCorreo(rs.getString("correo"));
                emp.setCategoria(rs.getString("categoria"));
                ListaEmp.add(emp);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaEmp;
    }
    
    public boolean RegistrarEmpleado(Empleados emp){
        String sql = "INSERT INTO empleados (dni, nombre, apellidos, categoria, correo, pass, extension_tienda) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getDni()); //indicamos que va a ser la posición 1 de nuestra sentencia sql (dni), y lo que vamos a insertar
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellidos());
            ps.setString(4, emp.getCategoria());
            ps.setString(5, emp.getCorreo());
            ps.setString(6, emp.getPass());
            ps.setInt(7, emp.getExtension_tienda());
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
    
    public Empleados BuscarEmpleado(String dni){
        Empleados emp = new Empleados();
        String sql = "SELECT * FROM empleados WHERE dni = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if(rs.next()){
                emp.setNombre(rs.getString("nombre"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setCategoria(rs.getString("categoria"));
                emp.setCorreo(rs.getString("correo"));
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return emp;
    }
    
    public boolean ModificarEmpleado (Empleados emp){
        String sql = "UPDATE empleados SET nombre = ?, apellidos = ?, categoria = ?, correo = ? WHERE dni = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellidos());
            ps.setString(3, emp.getCategoria());
            ps.setString(4, emp.getCorreo());
            ps.setString(5, emp.getDni());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally{
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean EliminarEmpleado (String dni){
        String sql = "DELETE FROM empleados WHERE dni = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally{
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public Empleados login(String dni, String pass){
        Empleados em = new Empleados();
        String sql = "SELECT * FROM empleados WHERE dni = ? AND pass = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                em.setDni(rs.getString("dni"));
                em.setNombre(rs.getString("nombre"));
                em.setApellidos(rs.getString("apellidos"));
                em.setPass(rs.getString("pass"));
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return em;
    }
    
    public Empleados CrearTabla(String dni){
        Empleados em = new Empleados();
        String sql = "CREATE TABLE " + dni +" (fecha VARCHAR(10) NOT NULL," +
                "hora_inicio VARCHAR(10)," +
                "hora_final VARCHAR(10))";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return em;
    }
    
    public Empleados RegistrarHoraIncio(String dni){
        DateFormat fechaActual = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat horaActual = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String sql = "INSERT INTO " + dni + " (fecha, hora_inicio) VALUES (?, ?)";
        Empleados em = new Empleados();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fechaActual.format(date));
            ps.setString(2, horaActual.format(date));
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return em;
    }
    
    public Empleados RegistrarHoraFinal(String dni){
        DateFormat fechaActual = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat horaActual = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String sql = "UPDATE " + dni + " SET hora_final = ? WHERE fecha = ?";
        Empleados em = new Empleados();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, horaActual.format(date));
            ps.setString(2, fechaActual.format(date));
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return em;
    }
}