package valera.server.domain;

import valera.shared.model.CreateMail;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by valerijszemlanikins on 06.01.14.
 */
public class MessageRepository {

    EntityManager em = EntityManagerFactoryClass.getEntityManager();

    public Messages loadById(int id) {
        return em.find(Messages.class, id);
    }

    public void save(Messages mails) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mails);
        transaction.commit();
        // em.merge(user);

    }
    public List<Messages> loadFrom (String user) {
        return em.createQuery("select m from Messages m where m.sendBy = :user ORDER BY m.id DESC", Messages.class)
                .setParameter("user", user)
                .getResultList();
    }

    public List<Messages> loadFor (String user){
        return em.createQuery("select m from Messages m where m.sendTo =:user ORDER BY m.id DESC", Messages.class)
                .setParameter("user", user)
                .getResultList();

    }


    public boolean nameVerefiaction(Messages messages){
        if(messages.getSendBy()!= null && messages.getSendTo() != null ){
            if(!messages.getSendBy().isEmpty() && !messages.getSendTo().isEmpty()){
                System.out.println("sdsdsdsd");
                return true;

            }
        }


        return false;
    }



}
