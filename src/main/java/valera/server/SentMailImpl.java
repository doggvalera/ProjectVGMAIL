package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import valera.server.domain.MailRepository;
import valera.server.domain.Mails;
import valera.shared.BeanTransformer;
import valera.shared.SentMailService;
import valera.shared.model.CreateMail;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by valerijszemlanikins on 04.01.14.
 */
public class SentMailImpl extends RemoteServiceServlet implements SentMailService{
    MailRepository mailRepository = new MailRepository();
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<CreateMail> getMailsFrom(String login) {
        List<Mails> mails = mailRepository.loadFrom(login);

        return BeanTransformer.transform(mails);
    }
}
