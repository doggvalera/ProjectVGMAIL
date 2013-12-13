package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import valera.server.domain.User;
import valera.server.domain.UserRepository;
import valera.shared.ValeraService;
import valera.shared.model.UserRegistration;

public class ValeraServiceImpl extends RemoteServiceServlet implements ValeraService {
    UserRepository userRepositry = new UserRepository();

    @Override
    public void register(UserRegistration userRegistration) {
        User user = new User(userRegistration);
        userRepositry.save(user);
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
