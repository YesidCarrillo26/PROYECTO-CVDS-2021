package edu.eci.cvds.managedbeans;

import java.io.IOException;
import java.io.Serializable;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "navigationController", eager = true)
@RequestScoped



    

public class NavigationController implements Serializable {
    private User user;
    public void paginaInicio() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/inicioSesion.xhtml");
    }

    public void paginaRegistroRec() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/registrarRecurso.xhtml");
    }

    public void paginaConsultaRec() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/consultarRecursos.xhtml");
    }

    public void paginaConsultaRecU() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/consultarRecursosU.xhtml");
    }

    public void paginaReservas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/reservarRecurso.xhtml");
    }

    public void paginaAdmin() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/paginaAdmin.xhtml");
    }

    public void paginaUser() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/paginaUser.xhtml");
    }

    public void paginaModificar() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/modificarRecursos.xhtml");
    }

    public void paginaCambiarEstado() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/cambiarEstadoR.xhtml");
    }

    public void paginaConsultaReserva() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/consultarReserva.xhtml");
    }

    public void login() throws IOException {
        
        if (user.getRol().equals(Rol.Administrador)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/paginaAdmin.xhtml");}
        else if (user.getRol().equals(Rol.Usuario)){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/paginaUser.xhtml");}
    }  

}
