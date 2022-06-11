package edu.eci.cvds.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;
import edu.eci.cvds.security.SessionLogger;
import edu.eci.cvds.services.ExceptionServices;
import edu.eci.cvds.persistence.ExceptionPersistence;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresGuest;

import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@ApplicationScoped

public class LoginBean extends BasePageBean{

    private String username;
    private String password;
    private String rol;
    @Inject
    SessionLogger sessionLogger;


    @RequiresGuest
    public void login() throws ExceptionPersistence, IOException, ExceptionServices {

        try {

            sessionLogger.login(username, password);

        } catch (ExceptionServices | IOException e){
            throw e;
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }
}