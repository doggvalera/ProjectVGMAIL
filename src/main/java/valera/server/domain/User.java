package valera.server.domain;

import org.hibernate.annotations.GenericGenerator;
import valera.shared.model.UserRegistration;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    private String name;
    private String login;
    private String surname;
    //    @Transient
    private String password;
    @Transient
    private String passwordRpt;

    public User() {
    }

    public User(UserRegistration userRegistration) {
        login = userRegistration.getLogin();
        name = userRegistration.getName();
        surname = userRegistration.getSurname();
        password = userRegistration.getPassword();
       passwordRpt = userRegistration.getPasswordRpt();

    }

    public String getPasswordRpt() {
        return passwordRpt;
    }

    public void setPasswordRpt(String passwordRpt) {
        this.passwordRpt = passwordRpt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
