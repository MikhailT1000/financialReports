package entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeUser", length = 10, discriminatorType = DiscriminatorType.STRING)
@Table(name = "Users")
@NamedQueries(
        @NamedQuery(name = User.FIND_BY_LOGIN_QUERY, query = "from User where login = :lll")
)
public class User {

    public static final String FIND_BY_LOGIN_QUERY = "findByLogin";

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 50)
    @Pattern(regexp = "[a-zA-Z0-9_-]+")
    private String login;

    @Column //(nullable = false)
    private String firstName;

    @Column //(nullable = false)
    private String secondName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first) {
        this.firstName = first;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String second) {
        this.secondName = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return login != null ? login.equals(user.login) : user.login == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

}
