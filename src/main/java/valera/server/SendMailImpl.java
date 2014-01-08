package valera.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import valera.server.domain.*;
import valera.shared.SendMailService;
import valera.shared.model.CreateMail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* Created by valerijszemlanikins on 05.01.14.
*/
public class SendMailImpl extends RemoteServiceServlet implements SendMailService {

    MessageRepository mailRepository = new MessageRepository();
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
        Messages mails = new Messages(mail);

            if  (mailRepository.nameVerefiaction(mails)==true){
            mailRepository.save(mails);

            return true;
            }
            else
                return false;

//
    }
}
