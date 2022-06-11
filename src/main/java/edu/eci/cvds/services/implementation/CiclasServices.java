package edu.eci.cvds.services.implementation;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.services.ExceptionServices;

import java.util.List;

public interface CiclasServices {

    public User getUser() throws ExceptionServices;

    public abstract User getUser(String correo, String contrasena) throws ExceptionServices;

    public List<Resource> getListResources() throws ExceptionServices;

    public void createResource(Resource resource) throws ExceptionServices;

    public List<ResourceType> getResourceType() throws ExceptionServices;

    public List<Location> getLocation() throws ExceptionServices;

    public List<Reserve> getListReserve() throws ExceptionServices;

    public List<Reserve> getListReserve1() throws ExceptionServices;

    public void createReserve(Reserve reserve) throws ExceptionServices;

    public void updateResource(Resource resource) throws ExceptionServices;

    public void deleteReserve(Reserve reserve) throws ExceptionServices;

    public List<Resource> getListActiveResources() throws ExceptionServices;
}
