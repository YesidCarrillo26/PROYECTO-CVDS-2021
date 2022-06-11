package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener; 
import edu.eci.cvds.managedbeans.*;
import edu.eci.cvds.persistence.mybatisimpl.DAOs.*;
import edu.eci.cvds.persistence.mybatisimpl.MybatisDAOs.*;
import edu.eci.cvds.services.implementation.CiclasServices;
import edu.eci.cvds.services.implementation.CiclasServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import edu.eci.cvds.security.SessionLogger;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {

				install(JdbcHelper.PostgreSQL);

				setEnvironmentId("development");

				setClassPathResource("mybatis-config.xml");

				//Inyeccion implementacion servicios
				bind(CiclasServices.class).to(CiclasServicesImpl.class);
				//Inyeccion DAOS
				bind(UserDAO.class).to(MyBatisUserDAO.class);
				bind(ResourceDAO.class).to(MyBatisResourceDAO.class);
				bind(ResourceTypeDAO.class).to(MyBatisResourceTypeDAO.class);
				bind(LocationDAO.class).to(MyBatisLocationDAO.class);
				bind(ReserveDAO.class).to(MyBatisReserveDAO.class);
				bind(BasePageBean.class).to(LoginBean.class);
                bind(SessionLogger.class).to(ShiroSession.class);
			}
		}

		);

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}