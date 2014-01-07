package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import valera.server.domain.MessageRepository;
import valera.server.domain.Messages;
import valera.shared.BeanTransformer;
import valera.shared.SentMailService;
import valera.shared.model.CreateMail;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by valerijszemlanikins on 04.01.14.
 */
public class SentMailImpl extends RemoteServiceServlet implements SentMailService{
   // MailRepository mailRepository = new MailRepository();
    MessageRepository messageRepository = new MessageRepository();
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<CreateMail> getMailsFrom(String login) {
        List<Messages> mails = messageRepository.loadFrom(login);

        return BeanTransformer.transform(mails);
    }
}
