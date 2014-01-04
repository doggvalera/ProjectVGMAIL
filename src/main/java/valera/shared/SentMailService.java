package valera.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import valera.shared.model.CreateMail;

import java.util.List;


/**
 * Created by valerijszemlanikins on 04.01.14.
 */@RemoteServiceRelativePath("sentmailservice")
public interface SentMailService extends RemoteService {
    List<CreateMail> getMailsFrom(String login);

}
