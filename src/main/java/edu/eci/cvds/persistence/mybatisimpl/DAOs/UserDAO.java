package edu.eci.cvds.persistence.mybatisimpl.DAOs;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.ExceptionPersistence;
import java.util.List;

public interface UserDAO {
    public List<User> getUser (String correo , String contrasena) throws ExceptionPersistence;
    public User load() throws ExceptionPersistence;

    public void save(User ur) throws ExceptionPersistence;
}
