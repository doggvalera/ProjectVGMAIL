package valera.server.domain;

import org.hibernate.annotations.GenericGenerator;
import valera.shared.model.UserRegistration;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    private String name;
    @Transient
    private String password;

    public User(UserRegistration userRegistration) {
        name = userRegistration.getName();

        password = userRegistration.getPassword();

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

}
