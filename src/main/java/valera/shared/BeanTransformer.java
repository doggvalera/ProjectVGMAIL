package valera.shared;

import valera.server.domain.Mails;
import valera.shared.model.CreateMail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valerijszemlanikins on 27.12.13.
 */
public class BeanTransformer {

    public static List<CreateMail> transform(List<Mails> items){
        List<CreateMail> result = new ArrayList<CreateMail>();
        for (Mails item : items) {
            result.add(transform(item));
        }
        return result;
    }

    public static CreateMail transform(Mails item) {
        return new CreateMail(item.getLoginTo(), item.getLoginFrom(), item.getTheme(), item.getTextMail());
    }

}
