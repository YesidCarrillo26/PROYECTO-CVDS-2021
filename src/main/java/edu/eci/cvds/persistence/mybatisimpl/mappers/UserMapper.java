package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User getUser();

    public void createUser(
            /*
            @Param("id") String id,
            @Param("nid") String nid,
            @Param("apellidos") String apellidos,
            @Param("nombres") String nombres,
            @Param("programa") String programa
            */
    );

    public List<User> getUser(String correo, String contrasena);
}
