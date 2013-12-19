package valera.server.domain;


import org.hibernate.annotations.GenericGenerator;
import valera.shared.model.CreateMail;


import javax.persistence.*;


/**
 * Created by valerijszemlanikins on 17.12.13.
 */
@Entity
@Table(name = "mails")
public class Mails {


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")

    private int id;
    private String loginTo;
    private String loginFrom;
    private String theme;
    private String textMail;
    public Mails(){}

    public Mails(CreateMail createMail){
        loginTo=createMail.getLoginTo();
        loginFrom=createMail.getLoginFrom();
        theme=createMail.getTheme();
        textMail=createMail.getTextMail();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginTo() {
        return loginTo;
    }

    public void setLoginTo(String loginTo) {
        this.loginTo = loginTo;
    }

    public String getLoginFrom() {
        return loginFrom;
    }

    public void setLoginFrom(String loginFrom) {
        this.loginFrom = loginFrom;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTextMail() {
        return textMail;
    }

    public void setTextMail(String textMail) {
        this.textMail = textMail;
    }
}
