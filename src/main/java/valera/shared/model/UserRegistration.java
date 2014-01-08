package valera.shared.model;

import java.io.Serializable;

public class UserRegistration implements Serializable {
    private String login;
    private String name;
    private String surname;
    private String password;
    private String passwordRpt;



    public UserRegistration() {
    }

    public UserRegistration(String login, String name, String surname, String password,String passwordRpt) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.passwordRpt = passwordRpt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswordRpt() {
        return passwordRpt;
    }

    public void setPasswordRpt(String passwordRpt) {
        this.passwordRpt = passwordRpt;
    }

}
