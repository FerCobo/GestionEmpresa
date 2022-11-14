package Modelo;

public class Empleados {
    private String dni;
    private String nombre;
    private String apellidos;
    private String categoria;
    private String correo;
    private String pass;
    private int extension_tienda;
    private int fecha;
    private int hora_inicio;
    private int hora_final;

    public Empleados() {
    }

    public Empleados(String dni, String nombre, String apellidos, String categoria, String correo, String pass, int extension_tienda) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.categoria = categoria;
        this.correo = correo;
        this.pass = pass;
        this.extension_tienda = extension_tienda;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getExtension_tienda() {
        return extension_tienda;
    }

    public void setExtension_tienda(int extension_tienda) {
        this.extension_tienda = extension_tienda;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getHora_final() {
        return hora_final;
    }

    public void setHora_final(int hora_final) {
        this.hora_final = hora_final;
    }
    
    
}
