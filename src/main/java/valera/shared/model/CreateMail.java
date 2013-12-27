package valera.shared.model;

import java.io.Serializable;

/**
 * Created by valerijszemlanikins on 17.12.13.
 */


public class CreateMail implements Serializable, Comparable<CreateMail> {


    private String loginTo;
    private String loginFrom;
    private String theme;
    private String textMail;


    public CreateMail(String loginTo, String loginFrom, String theme, String textMail) {
        this.loginTo = loginTo;
        this.loginFrom = loginFrom;
        this.theme = theme;
        this.textMail = textMail;
    }

    public CreateMail() {
    }

    public int compareTo(CreateMail o) {
        return this.loginTo.compareTo(o.loginTo);
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
