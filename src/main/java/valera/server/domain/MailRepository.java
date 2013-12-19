package valera.server.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by valerijszemlanikins on 17.12.13.
 */
public class MailRepository {


    EntityManager em = EntityManagerFactoryClass.getEntityManager();

    public Mails loadById(int id) {
        return em.find(Mails.class, id);
    }

    public void save(Mails mails){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mails);
        transaction.commit();
        // em.merge(user);

    }
}
