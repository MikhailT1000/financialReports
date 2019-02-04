package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends User {

    public Manager() {
    }

    public Manager(String login) {
        setLogin(login);
    }
}
