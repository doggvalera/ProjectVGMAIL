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

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        // em.merge(user);

    }


    public boolean loginEnterCheck(String loginfrombd, String password) {
        List<String> logins = em.createQuery("SELECT u.login FROM User u where :loginfrombd=u.login AND :password=u.password", String.class)
                .setParameter("loginfrombd", loginfrombd)
                .setParameter("password", password)
                .getResultList();
        System.out.println(loginfrombd);

        return logins != null && !logins.isEmpty();


    }

    public User getUserByLogin(String Login) {

        List<User> user = em.createQuery("FROM User u where :login=u.login", User.class)
                .setParameter("login", Login)
                .getResultList();
        return user.get(0);

    }


    public boolean loginExis(User user) {
        String loginfrombd = user.getLogin();
        List<String> login = em.createQuery("SELECT u.login FROM User u where :loginfrombd=u.login ", String.class)
                .setParameter("loginfrombd", loginfrombd)
                .getResultList();

        return login != null && !login.isEmpty();
    }

    public boolean checkLogin(User user) {
        String login = user.getLogin();
        //  if(login.matches("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$")){
        if (login.matches("^[a-zA-Z0-9]+$")) {
            return true;
        } else return false;

    }

    public boolean passwordVerif(User user) {
        String password = user.getPassword();
        if (password!=null && password.length()>4){
            return true;
        }return false;
    }

}
