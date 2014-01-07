package valera.server.domain;

import org.hibernate.annotations.GenericGenerator;
import valera.shared.model.CreateMail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by valerijszemlanikins on 06.01.14.
 */
@Entity
@Table(name = "messages")
public class Messages {






        @Id
        @GeneratedValue(generator = "increment")
        @GenericGenerator(name = "increment", strategy = "increment")

        private int id;
        private String sendBy;
        private String sendTo;
        private String theme;
        private String textMessages;
        private Date dateField;

        public Messages() {
        }

        public Messages(CreateMail createMail) {
            sendBy = createMail.getLoginTo();
            sendTo = createMail.getLoginFrom();
            theme = createMail.getTheme();
            textMessages = createMail.getTextMail();
            dateField = createMail.getDateField();
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getTextMessages() {
        return textMessages;
    }

    public void setTextMessages(String textMessages) {
        this.textMessages = textMessages;
    }

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date date) {
        this.dateField = date;
    }
}
