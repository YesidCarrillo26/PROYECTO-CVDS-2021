package edu.eci.cvds.entities;

public class Resource {
    private Integer codigo;
    private String tipo;
    private String ubicacion;
    private String nombre;
    private String estado;
    private Integer capacidad;
    private Integer ubicacionI;
    private Integer tipoI;

    public Integer getUbicacionI() {
        return ubicacionI;
    }

    public void setUbicacionI(Integer ubicacionI) {
        this.ubicacionI = ubicacionI;
    }

    public Integer getTipoI() {
        return tipoI;
    }

    public void setTipoI(Integer tipoI) {
        this.tipoI = tipoI;
    }

    public Resource(Integer codigo, String tipo, String ubicacion, String nombre, String estado, Integer capacidad) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public Resource(Integer tipo, Integer ubicacion, String nombre, String estado, Integer capacidad){
        this.tipoI = tipo;
        this.ubicacionI = ubicacion;
        this.nombre = nombre;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public Resource getResource(){
        return this;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
