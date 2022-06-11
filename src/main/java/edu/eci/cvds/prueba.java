package edu.eci.cvds;

import com.google.inject.Injector;
import edu.eci.cvds.entities.Reserve;
import edu.eci.cvds.entities.Resource;
import edu.eci.cvds.persistence.mybatisimpl.DAOs.*;
import edu.eci.cvds.persistence.mybatisimpl.MybatisDAOs.*;
import edu.eci.cvds.services.ExceptionServices;
import edu.eci.cvds.services.implementation.CiclasServices;
import edu.eci.cvds.services.implementation.CiclasServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class prueba {

    private static prueba instance = new prueba();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);

                bind(CiclasServices.class).to(CiclasServicesImpl.class);

                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(ResourceDAO.class).to(MyBatisResourceDAO.class);
                bind(ResourceTypeDAO.class).to(MyBatisResourceTypeDAO.class);
                bind(LocationDAO.class).to(MyBatisLocationDAO.class);
                bind(ReserveDAO.class).to(MyBatisReserveDAO.class);
            }
        });
    }

    private prueba() {
        optInjector = Optional.empty();
    }

    public CiclasServices getServiciosAlquiler() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development", "mybatis-config.xml"));
        }

        return optInjector.get().getInstance(CiclasServices.class);
    }


    public Resource createResource() {
        Resource resource = new Resource(
                1, 2, "HOLAAAAAA", "Activo", 99);
        return resource;
    }

//    public Reserve createReserve() {
//        Reserve reserve = new Reserve(
//                3,
//                new Time(12, 30, 40),
//                new Time(13, 30, 40),
//                "frente",
//                new Date(2, 12, 5));
//        return reserve;
//    }

    public Reserve createReserve() {
        Reserve reserve = new Reserve(
                4,1,
                new Time(12, 30, 40),
                new Time(13, 30, 40),
                "poca",
                new Date(2, 12, 5));
        return reserve;
    }

    public static prueba getInstance() {
        return instance;
    }

    public static void main(String[] args) throws ExceptionServices {



        // System.out.println("-------------------------------- CONSULAR CLIENTES
        // --------------------------------");
        // System.out.println(instance.getServiciosAlquiler().getUser().getApellidos());
        // System.out.println(instance.getServiciosAlquiler().getUser().getNombres());



//        System.out.println("------------------CREAR RECURSO ----------------------------------------");

//        Resource resource = getInstance().createResource();
//        instance.getServiciosAlquiler().createResource(resource);
//         //System.out.println(instance.getServiciosAlquiler().getResource().getNombre());



        // System.out.println("------------------CONSULTAR tipoRECURSO
        // ----------------------------------------");
        // System.out.println(instance.getServiciosAlquiler().getResourceType().getDescripcion());



        // System.out.println("------------------CONSULTAR RECURSO
        // ----------------------------------------");
        // System.out.println(instance.getServiciosAlquiler().getLocation().getHoraMaxima());
        //
//
//        ReportFile.loadReport("------------------CONSULTAR lista adsfdsaf ----------------------------------------");
//
//        ReportFile.loadReport("------------------CONSULTAR lista RECURSO ----------------------------------------");
//        System.out.println("------------------CONSULTAR lista RECURSO ----------------------------------------");
//        List<Resource> listaRecursos = instance.update();
//        System.out.println(listaRecursos);
//        for (Resource i : listaRecursos) {
//            System.out.println(i.getEstado());
//        }


        // System.out.println("------------------Actualizar recurso
        // estado----------------------------------------");
        // instance.getServiciosAlquiler().updateResource(listaRecursos.get(1));
        // List<Resource> listaRecursos1 = instance.update();
        // for (Resource i : listaRecursos1) {
        // System.out.println(i.getEstado());
        //
        // }



//         System.out.println("------------------INSERTAR RESERVA----------------------------------------");
//         Reserve reserve = getInstance().createReserve();
//         instance.getServiciosAlquiler().createReserve(reserve);
//        //System.out.println(instance.getServiciosAlquiler().getListReserve());
//         List<Reserve> reserves = instance.getServiciosAlquiler().getListReserve();
//         reserves.add(reserve);
//         for (Reserve r: reserves){
//            System.out.println(r.getPeriodicidad());
//         }
//
        System.out.println("---------------------------CONSULTAR RESERVA --------------------");
        List<Reserve> reserves = instance.getServiciosAlquiler().getListReserve();
        System.out.println(reserves);
        for (Reserve r: reserves){
            System.out.println(r.getPrograma());
        }
//

//        System.out.println("---------------------------ELIMINAR RESERVA --------------------");
//        List<Reserve> reserveList = instance.getServiciosAlquiler().getListReserve();
//        System.out.println(reserveList.get(0).getPrograma());
//        instance.getServiciosAlquiler().deleteReserve(reserveList.get(0));
//        reserveList = instance.getServiciosAlquiler().getListReserve();
//        for(Reserve r: reserveList){
//            System.out.println(r.getPrograma());
//        }
   }
//
//
    public List<Resource> update() {
        try {
            List<Resource> listaRecursos = instance.getServiciosAlquiler().getListActiveResources();
            return listaRecursos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

// System.out.println(instance.getServiciosAlquiler().getResource());
// Funcionaaaaaaaaa el select
// al menos algo, no esta solicitando el recurso
/*
 * System.out.println("---------------------------------- CONSULAR CLIENTE " +
 * documento + " ------------------------------------");
 * System.out.println(instance.getServiciosAlquiler().consultarCliente(documento
 * ).toString());
 * System.out.
 * println("----------------------------- CONSULAR ITEMS DEL CLIENTE " +
 * documento +" -----------------------------");
 * System.out.println(instance.getServiciosAlquiler().consultarItemsCliente(
 * 10999900099L).toString());
 */

// public static void main(String[] args) throws PersistenceException {
// ECIBookServices instance
//// System.out.println(instance.consultarCliente(2165711).toString());
//// System.out.println(instance.consultarRecursos());
// for(Recurso r: instance.consultarRecursos()){
// System.out.println(r.toString());
// }
//
// }
// }
