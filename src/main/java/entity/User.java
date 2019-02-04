package entity;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type User", length = 10, discriminatorType = DiscriminatorType.STRING)
@Table(name = "Users")
//@NamedQueries(
//        @NamedQuery(name = User.FIND_BY_LOGIN_QUERY, query = "from User where login = :lll")
//)
public class User {

//    public static final String FIND_BY_LOGIN_QUERY = "findByLogin";

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


}
