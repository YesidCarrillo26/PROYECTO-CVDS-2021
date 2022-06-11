package edu.eci.cvds.persistence.mybatisimpl.MybatisDAOs;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.persistence.ExceptionReport.ReportFile;
import edu.eci.cvds.persistence.ExceptionPersistence;
import edu.eci.cvds.persistence.mybatisimpl.DAOs.ResourceDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ResourceMapper;

import java.util.List;


public class MyBatisResourceDAO implements ResourceDAO{

    @Inject
    private ResourceMapper resourceMapper;


    @Override
    public void save(Resource resource) throws ExceptionPersistence {
        try {
            ReportFile.loadReport("Aqui pasa");
            resourceMapper.createResource(resource);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Resource> loadListResources() {
        try{
            return resourceMapper.getListResources();
        } catch (Exception e){
            ReportFile.loadReport(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateResource(Resource resource){
        try{

            if (resource.getEstado().equals("Activo")) {
                resource.setEstado("Inactivo");
            }
            else if (resource.getEstado().equals("Inactivo")){
                //System.out.println("entra");
                resource.setEstado("Activo");}
            resourceMapper.updateResource(resource);
            ReportFile.loadReport("pasa por aca");
        }catch (Exception e){
            ReportFile.loadReport(e.getMessage());
        }
    }

    @Override
    public List<Resource> loadListActiveResources() {
        try{
            return resourceMapper.getListActiveResources();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
