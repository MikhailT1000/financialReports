package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User{

    public Admin() {
    }

    public Admin(String firstName, String secondName, String login) {
        setFirstName(firstName);
        setSecondName(secondName);
        setLogin(login);
    }

}
