package valera.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import valera.shared.model.CreateMail;

/**
* Created by valerijszemlanikins on 05.01.14.
*/
@RemoteServiceRelativePath("sendmailservice")
public interface SendMailService extends RemoteService {
    public boolean sendMail(CreateMail mail);

   public String sendMailAuthor();
}
