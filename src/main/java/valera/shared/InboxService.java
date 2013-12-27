package valera.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import valera.shared.model.CreateMail;

import java.util.List;

/**
 * Created by valerijszemlanikins on 27.12.13.
 */
@RemoteServiceRelativePath("inboxService")
public interface InboxService extends RemoteService {

    List<CreateMail> getMailsTo(String login);

}
