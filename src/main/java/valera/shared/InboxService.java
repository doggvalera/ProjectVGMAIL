package valera.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.XsrfProtect;
import valera.shared.model.CreateMail;

import java.util.List;

/**
 * Created by valerijszemlanikins on 27.12.13.
 */
@RemoteServiceRelativePath("inboxService")
@XsrfProtect
public interface InboxService extends RemoteService {

    List<CreateMail> getMailsTo(String login);

}
