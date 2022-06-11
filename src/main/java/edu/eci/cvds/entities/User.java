package edu.eci.cvds.entities;

public class User {
    private int id;
    private String apellidos;
    private String nombres;
    private String programa;
    private String rol;
    private String correo;
    private String contrasena;

    public User(int id, String apellidos, String nombres, String programa, String rol, String correo, String contrasena) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.programa = programa;
        this.correo = correo;
        this.rol = rol;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
