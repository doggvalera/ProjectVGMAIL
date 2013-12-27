package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import valera.server.domain.MailRepository;
import valera.server.domain.Mails;
import valera.server.domain.User;
import valera.server.domain.UserRepository;
import valera.shared.BeanTransformer;
import valera.shared.InboxService;
import valera.shared.ValeraService;
import valera.shared.model.CreateMail;
import valera.shared.model.UserRegistration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

public class InboxServiceImpl extends RemoteServiceServlet implements InboxService {
    MailRepository mailRepository = new MailRepository();
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<CreateMail> getMailsTo(String login) {
        List<Mails> mails = mailRepository.loadFor(login);

        return BeanTransformer.transform(mails);
    }
}
