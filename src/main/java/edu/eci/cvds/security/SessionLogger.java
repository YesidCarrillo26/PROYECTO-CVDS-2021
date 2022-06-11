package edu.eci.cvds.security;

import java.io.IOException;

import edu.eci.cvds.services.ExceptionServices;

public interface SessionLogger {

    public void login(String correo, String contrasena) throws ExceptionServices, IOException;

    public boolean isLogged() throws ExceptionServices;

    public void logout() throws ExceptionServices;
}