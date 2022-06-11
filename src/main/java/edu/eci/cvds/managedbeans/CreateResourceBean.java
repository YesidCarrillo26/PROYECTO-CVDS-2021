package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Location;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.entities.ResourceType;
import edu.eci.cvds.services.ExceptionServices;
import edu.eci.cvds.services.implementation.CiclasServices;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.util.List;

@ManagedBean(name = "creaRecurso")
@RequestScoped
public class CreateResourceBean extends BasePageBean {
    @Inject
    private CiclasServices ciclasServices;

    private String selectedOptionUbication;
    private String selectedOptionRecTipe;
    private String selectedOptionState;
    private String nombreRecurso;
    private String capacidadRecurso;
    private List<ResourceType> resourceTypeList;
    private List<Location> locationList;

    public CreateResourceBean() {

        try {
            resourceTypeList = ciclasServices.getResourceType();
            locationList = ciclasServices.getLocation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void createResources() throws ExceptionServices {
        System.out.println("Esta entrando");
        try {
            int indexResourceType = Integer.parseInt(selectedOptionRecTipe);
            int indexLocation = Integer.parseInt(selectedOptionUbication);
            Resource resource = new Resource(indexResourceType, indexLocation,
                    nombreRecurso, selectedOptionState,
                    Integer.parseInt(capacidadRecurso));
            ciclasServices.createResource(resource);
            addMessage("Confirmed", "Recurso Agregado");
        } catch (Exception e) {
            addMessage("Confirmed", "Error");
            System.out.println(e.getMessage());
        }
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getSelectedOptionUbication() {
        return selectedOptionUbication;
    }

    public void setSelectedOptionUbication(String selectedOptionUbication) {
        this.selectedOptionUbication = selectedOptionUbication;
    }

    public String getSelectedOptionRecTipe() {
        return selectedOptionRecTipe;
    }

    public void setSelectedOptionRecTipe(String selectedOptionRecTipe) {
        this.selectedOptionRecTipe = selectedOptionRecTipe;
    }

    public String getSelectedOptionState() {
        return selectedOptionState;
    }

    public void setSelectedOptionState(String selectedOptionState) {
        this.selectedOptionState = selectedOptionState;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getCapacidadRecurso() {
        return capacidadRecurso;
    }

    public void setCapacidadRecurso(String capacidadRecurso) {
        this.capacidadRecurso = capacidadRecurso;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public void setResourceTypeList(List<ResourceType> resourceTypeList) {
        this.resourceTypeList = resourceTypeList;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public List<ResourceType> getResourceTypeList() {
        return resourceTypeList;
    }

}
