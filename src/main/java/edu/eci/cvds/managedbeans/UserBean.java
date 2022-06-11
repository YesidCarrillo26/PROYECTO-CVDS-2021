package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.security.SessionLogger;
import edu.eci.cvds.services.implementation.CiclasServices;
import javax.inject.Inject;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean extends BasePageBean {

    @Inject
    private CiclasServices ciclasServices;
    private String email;
    private String password;
    private String nombreCompleto;
    private SessionLogger shiroSession;

    /*
     * public void createUser() throws Exception{
     * try{
     * //Uso de metodos en clase eciBookServices
     * }
     * catch (Exception exception){
     * // cambiar cuando se implementen las excepciones
     * // de servicesException
     * throw exception;
     * }
     * }
     */
    public void signIn(String nombre, String clave) throws Exception {
        try {
            //// Uso de metodos en clase eciBookServices
            shiroSession.login(nombre, clave);
        } catch (Exception e) {

        }
    }

    public void logOut() throws Exception {
        try {
            if (shiroSession.isLogged()) {
                shiroSession.logout();
            }
        } catch (Exception e) {

        }
    }

    public User loadUser() throws Exception {
        try {
            return ciclasServices.getUser();
        } catch (Exception e) {
            return null;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getNombreCompleto() {
        try {
            User user = loadUser();
            nombreCompleto = user.getNombres() + user.getApellidos();
            return nombreCompleto;
        } catch (Exception e) {
            return null;
        }
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
