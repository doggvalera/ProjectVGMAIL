package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import valera.server.domain.MailRepository;
import valera.server.domain.Mails;
import valera.server.domain.User;
import valera.shared.SendMailService;
import valera.shared.model.CreateMail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* Created by valerijszemlanikins on 05.01.14.
*/
public class SendMailImpl extends RemoteServiceServlet implements SendMailService {
    MailRepository mailRepository = new MailRepository();
    @Override
    public String sendMailAuthor() {
        HttpServletRequest request = getThreadLocalRequest();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        String userName = user.getLogin();
        return userName;
    }



    @Override
    public boolean sendMail(CreateMail mail) {
        Mails mails = new Mails(mail);

boolean sendMails = false;
       // if (mail.getLoginTo() != null && mail.getLoginFrom() != null) {
if(mailRepository.nameVerefication(mail) == true){
            mailRepository.save(mails);

             sendMails = true;

        } else sendMails =  false;
        return sendMails;
    }
}
