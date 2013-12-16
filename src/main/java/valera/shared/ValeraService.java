package valera.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import valera.shared.model.UserRegistration;

@RemoteServiceRelativePath("valeraservice")
public interface ValeraService extends RemoteService { 

	UserRegistration getUserRegistration(String login, String name, String surname, String password);
     boolean register(UserRegistration userRegistration);
    boolean loginEnter(String login, String password);

}
