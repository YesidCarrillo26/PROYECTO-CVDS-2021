package edu.eci.cvds.persistence.mybatisimpl.DAOs;


import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.persistence.ExceptionPersistence;

import java.util.List;

public interface ResourceDAO {
    public void save(Resource resource) throws ExceptionPersistence;

    public List<Resource> loadListResources();

    public void updateResource(Resource resource);

    public List<Resource> loadListActiveResources();

}

    //metodo para consultar recurso

    //metodo para insertar recurso


