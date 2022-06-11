package edu.eci.cvds.services.implementation;

import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.services.implementation.CiclasServices;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.mybatisimpl.DAOs.UserDAO;
import edu.eci.cvds.persistence.ExceptionPersistence;
import edu.eci.cvds.persistence.ExceptionReport.ReportFile;
import edu.eci.cvds.persistence.mybatisimpl.DAOs.*;
import edu.eci.cvds.services.ExceptionServices;

/**
 * Implementación de {@link CiclasServices}
 */
public class CiclasServicesImpl implements CiclasServices {

	@Inject
	private UserDAO userDAO;

	@Inject
	private ResourceDAO resourceDAO;

	@Inject
	private ResourceTypeDAO resourceTypeDAO;

	@Inject
	private LocationDAO locationDAO;

	@Inject
	private ReserveDAO reserveDAO;

	@Override
	public User getUser() throws ExceptionServices {
		try {
			return userDAO.load();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User getUser(String correo, String contrasena) throws ExceptionServices {

		User usuario = null;
        try{
            List<User> lista = userDAO.getUser(correo, contrasena);
            if(!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        }catch (ExceptionPersistence e){
            throw new ExceptionServices("Error", e);
        }
        return usuario;
   	}
	
	

	@Override
	public List<Resource> getListResources() throws ExceptionServices {
		try {
			return resourceDAO.loadListResources();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void createResource(Resource resource) throws ExceptionServices {
		try {
			resourceDAO.save(resource);
			ReportFile.loadReport("Recurso agregado");
			System.out.println(resource);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<ResourceType> getResourceType() throws ExceptionServices {
		try {
			return resourceTypeDAO.getResourceType();
		} catch (Exception e) {
			ReportFile.loadReport(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Location> getLocation() throws ExceptionServices {
		try {
			return locationDAO.getLocation();
		} catch (Exception e) {
			ReportFile.loadReport(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Reserve> getListReserve() throws ExceptionServices {
		try {
			return reserveDAO.getListReserves();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ReportFile.loadReport(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Reserve> getListReserve1() throws ExceptionServices {
		try {
			return reserveDAO.getListReserves1();
		} catch (Exception e){
			System.out.println(e.getMessage());
			ReportFile.loadReport(e.getMessage());
			return null;
		}
	}

	@Override
	public void createReserve(Reserve reserve) throws ExceptionServices {
		try {
			reserveDAO.createReserve(reserve);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ReportFile.loadReport(e.getMessage());
		}
	}

	@Override
	public void updateResource(Resource resource) throws ExceptionServices {
		try {
			resourceDAO.updateResource(resource);
			ReportFile.loadReport(resource.getEstado());
		} catch (Exception e) {
			ReportFile.loadReport(e.getMessage());
		}
	}

	@Override
	public void deleteReserve(Reserve reserve) throws ExceptionServices {
		try {
			reserveDAO.deleteReserve(reserve);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ReportFile.loadReport(e.getMessage());
		}
	}

	@Override
	public List<Resource> getListActiveResources() throws ExceptionServices {
		try {
			return resourceDAO.loadListActiveResources();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
