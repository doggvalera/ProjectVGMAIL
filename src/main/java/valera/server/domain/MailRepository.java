package valera.server.domain;

import valera.shared.model.CreateMail;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by valerijszemlanikins on 17.12.13.
 */
public class MailRepository {


    EntityManager em = EntityManagerFactoryClass.getEntityManager();

    public Mails loadById(int id) {
        return em.find(Mails.class, id);
    }

    public void save(Mails mails) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mails);
        transaction.commit();
        // em.merge(user);

    }

    public List<Mails> loadFor(String user) {
        return em.createQuery("select m from Mails m where m.loginTo = :user", Mails.class)
                .setParameter("user", user)
                .getResultList();
    }

    public List<Mails> loadFrom (String user){
        return em.createQuery("select m from Mails m where m.loginFrom =:user", Mails.class)
                .setParameter("user", user)
                .getResultList();

    }
    public boolean nameVerefication(CreateMail mail) {
        if(mail.getLoginFrom() == null) { return false;}
        else return true;
    }
}
