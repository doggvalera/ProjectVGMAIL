package valera.shared.model;

import sun.util.calendar.LocalGregorianCalendar;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by valerijszemlanikins on 17.12.13.
 */


public class CreateMail implements Serializable, Comparable<CreateMail> {


    private String loginTo;
    private String loginFrom;
    private String theme;
    private String textMail;
    private Date dateField;


    public CreateMail(String loginTo, String loginFrom, String theme, String textMail, Date dateField) {
        this.loginTo = loginTo;
        this.loginFrom = loginFrom;
        this.theme = theme;
        this.textMail = textMail;
        this.dateField = dateField;
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

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }
}
