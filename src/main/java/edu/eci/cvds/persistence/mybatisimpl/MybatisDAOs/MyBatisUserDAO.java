package edu.eci.cvds.persistence.mybatisimpl.MybatisDAOs;

import com.google.inject.Inject;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.ExceptionReport.ReportFile;
import edu.eci.cvds.persistence.ExceptionPersistence;
import edu.eci.cvds.persistence.mybatisimpl.DAOs.UserDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UserMapper;
import java.util.List;

public class MyBatisUserDAO implements UserDAO {

    @Inject
    private UserMapper userMapper;

    @Override
    public List<User> getUser(String correo, String contrasena) throws ExceptionPersistence {
        try{
            return userMapper.getUser(correo, contrasena);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new ExceptionPersistence("Error", e);
        }
    }
    // Insert
    @Override
    public void save(User rs) throws ExceptionPersistence {
        try {

            userMapper.createUser();
        }
        catch (Exception e){
        }
    }
    // Consulta
    @Override
    public User load() throws ExceptionPersistence {
        try {
            return userMapper.getUser();
        }
        catch (Exception e){
            ReportFile.loadReport(e.getMessage());
            return null;
        }
    }


}
