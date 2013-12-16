package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import valera.server.domain.User;
import valera.server.domain.UserRepository;
import valera.shared.ValeraService;
import valera.shared.model.UserRegistration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

public class ValeraServiceImpl extends RemoteServiceServlet implements ValeraService {
    UserRepository userRepositry = new UserRepository();
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public boolean register(UserRegistration userRegistration) {
        logger.info("Test");

        User user = new User(userRegistration);
//        boolean canRegistr = !userRepositry.loginExis(user);
//        if (canRegistr == true) {
//            if (userRepositry.checkLogin(user) != true) {
//                userRepositry.save(user);
//            }
//        }
//        return false;
        boolean canRegistr = true;
        if (userRepositry.loginExis(user) == true) {
            canRegistr = false;
            System.out.println("userExists");

        }
        if (userRepositry.checkLogin(user) != true) {
            canRegistr = false;
            System.out.println("wrong login");
        }
        if (canRegistr == true) {
            userRepositry.save(user);
            return true;
        } else
            return false;
    }




    @Override
    public boolean loginEnter(String login, String password) {
        if (userRepositry.loginEnterCheck(login, password) == true) {

            return true;
        } else return false;
    }


    @Override
    public void autorize(String login){
        User user = userRepositry.getUserByLogin(login);
        HttpServletRequest request = getThreadLocalRequest();
        HttpSession session = request.getSession(true);
        session.setAttribute("user",user);
    }

    @Override
    public boolean isAutorized() {
        HttpServletRequest request = getThreadLocalRequest();
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user")!=null){
            return true;

        }
        else
        return false;
    }

    @Override
    public UserRegistration getUserRegistration(String login, String name, String surname, String password) {

        User u = userRepositry.loadById(1);

        UserRegistration e = new UserRegistration();

        e.setLogin(u.getName());
        e.setName(surname);
        e.setSurname(surname);
        e.setPassword(password);

        System.out.println(login);
        System.out.println(name);
        System.out.println(surname);
        System.out.println(password);
        System.out.println(u);
        return e;
    }
}
