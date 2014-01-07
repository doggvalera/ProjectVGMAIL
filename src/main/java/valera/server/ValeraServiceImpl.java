package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import valera.server.domain.MailRepository;
import valera.server.domain.User;
import valera.server.domain.UserRepository;
import valera.shared.ValeraService;
import valera.shared.model.UserRegistration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

public class ValeraServiceImpl extends RemoteServiceServlet implements ValeraService {
    UserRepository userRepositry = new UserRepository();
    MailRepository mailRepository = new MailRepository();
    private Logger logger = Logger.getLogger(this.getClass().getName());


    @Override
    public boolean register(UserRegistration userRegistration) {
        logger.info("Test");

        User user = new User(userRegistration);
//
        boolean canRegistr = false;

        if (!userRepositry.loginExis(user)) {

            System.out.println("userExists");

            if (userRepositry.checkLogin(user)) {

                System.out.println("wrong login");
                if (userRepositry.passwordVerif(user)) {
                    canRegistr = true;
                }

            }

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
    public void autorize(String login) {
        User user = userRepositry.getUserByLogin(login);
        HttpServletRequest request = getThreadLocalRequest();
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
    }

    @Override
    public boolean isAutorized() {
        HttpServletRequest request = getThreadLocalRequest();
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") != null) {
            return true;

        } else
            return false;
    }

    @Override
    public String sendMailAuthor() {
        HttpServletRequest request = getThreadLocalRequest();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        String userName = user.getLogin();
        return userName;
    }


//    @Override
//    public boolean sendMail(CreateMail mail) {
//        Mails mails = new Mails(mail);
//        if (mail.getLoginTo() != null) {
//
//            mailRepository.save(mails);
//            return true;
//
//        } else return false;
//    }
////

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
