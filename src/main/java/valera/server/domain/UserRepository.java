package valera.server.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserRepository {
    
	EntityManager em = EntityManagerFactoryClass.getEntityManager();
	
	public User loadById(int id) {
		return em.find(User.class, id);
	}

    public void save(User user){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
       // em.merge(user);
    }
}
