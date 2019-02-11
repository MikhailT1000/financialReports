package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends User {

    public Manager() {
    }

    public Manager(String firstName, String secondName, String login) {
        setFirstName(firstName);
        setSecondName(secondName);
        setLogin(login);
    }
}
