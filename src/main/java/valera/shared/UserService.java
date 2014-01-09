package valera.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.XsrfProtect;
import valera.server.domain.User;
import valera.shared.model.CreateMail;
import valera.shared.model.UserRegistration;

@RemoteServiceRelativePath("userservice")
@XsrfProtect
public interface UserService extends RemoteService {

    UserRegistration getUserRegistration(String login, String name, String surname, String password, String passwordReapet);

    boolean register(UserRegistration userRegistration);

    boolean loginEnter(String login, String password);

    public void autorize(String login);

    public boolean isAutorized();

   // public boolean sendMail(CreateMail mail);

    public String sendMailAuthor();

}
