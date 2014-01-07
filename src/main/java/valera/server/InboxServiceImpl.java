package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import valera.server.domain.*;
import valera.shared.BeanTransformer;
import valera.shared.InboxService;
import valera.shared.model.CreateMail;

import java.util.List;
import java.util.logging.Logger;

public class InboxServiceImpl extends RemoteServiceServlet implements InboxService {
//    MailRepository mailRepository = new MailRepository();
//    private Logger logger = Logger.getLogger(this.getClass().getName());
//
//    @Override
//    public List<CreateMail> getMailsTo(String login) {
//        List<Mails> mails = mailRepository.loadFor(login);
//
//        return BeanTransformer.transform(mails);
//    }
//}
    MessageRepository mailRepository = new MessageRepository();
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<CreateMail> getMailsTo(String login) {
        List<Messages> mails = mailRepository.loadFor(login);

        return BeanTransformer.transform(mails);
    }
}