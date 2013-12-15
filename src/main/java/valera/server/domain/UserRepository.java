package valera.server.domain;

import valera.shared.model.UserRegistration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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
    public boolean loginExis(User user){
        String loginfrombd = user.getLogin();
        List<String> login = em.createQuery("SELECT u.login FROM User u where :loginfrombd=u.login ", String.class)
               .setParameter("loginfrombd", loginfrombd)
                            .getResultList();

        return login != null && !login.isEmpty();
    }

}
