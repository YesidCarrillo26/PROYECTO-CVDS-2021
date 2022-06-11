package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {

    public void createResource(Resource resource);

    public List<Resource> getListResources();

    public void updateResource(Resource resource);

    public List<Resource> getListActiveResources();
}
