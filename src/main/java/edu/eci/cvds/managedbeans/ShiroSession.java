package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.ExceptionPersistence;
import edu.eci.cvds.security.SessionLogger;
import edu.eci.cvds.services.ExceptionServices;
import edu.eci.cvds.services.implementation.CiclasServices;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;

public class ShiroSession implements SessionLogger {
    @Inject
    private CiclasServices userServices;


    public CiclasServices getUserServices() {
        return userServices;
    }

    public void setUserServices(CiclasServices userServices) {
        this.userServices = userServices;
    }
    
    public void login(String correo, String contrasena) throws ExceptionServices, IOException {
        User usuario = userServices.getUser(correo, contrasena);
        if(usuario != null){
            if(usuario.getRol().equals("admin")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/paginaAdmin.xhtml?faces-redirect=true");
            }else{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/paginaUser.xhtml?faces-redirect=true");
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public void logout(){
        SecurityUtils.getSubject().logout();
    }


}