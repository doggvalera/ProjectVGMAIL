package valera.server.domain;

import valera.shared.model.UserRegistration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserRepository {

    EntityManager em = EntityManagerFactoryClass.getEntityManager();

    public User loadById(int id) {
        return em.find(User.class, id);
    }

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        user.setPassword(codePassword(user.getPassword()));
        em.persist(user);
        transaction.commit();
        // em.merge(user);

    }

    public String codePassword(String password) {
        String codedPassword = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes(), 0, password.length());
            codedPassword = new BigInteger(1, md5.digest()).toString(16);

        } catch(NoSuchAlgorithmException ex) {

        }
        return codedPassword;
    }



    public boolean loginEnterCheck(String loginfrombd, String password) {
        List<String> logins = em.createQuery("SELECT u.login FROM User u where :loginfrombd=u.login AND :password=u.password", String.class)
                .setParameter("loginfrombd", loginfrombd)
                .setParameter("password", codePassword(password))
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
    public boolean loginVerif(User user){
        String login = user.getLogin();
        if (login!=null && login.length()>4){
            return true;
        }
        return false;
    }

}
