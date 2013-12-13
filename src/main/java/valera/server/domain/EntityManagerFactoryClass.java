package valera.server.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryClass {


    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("booking");
	
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
}
