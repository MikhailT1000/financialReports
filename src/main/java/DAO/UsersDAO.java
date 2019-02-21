package DAO;


import entity.Manager;
import entity.Operator;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import java.util.List;

import static entity.User.FIND_BY_LOGIN_QUERY;

@Service
@Transactional
public class UsersDAO {

    @PersistenceContext
    private EntityManager em;

    public Operator createOperator(String firstName, String secondName, String login) {
        Operator operator = new Operator(firstName, secondName, login);
        em.persist(operator);
        return operator;
    }

    public User createUser(String typeUser, String firstName, String secondName, String login) {
        User user;

        switch (typeUser) {
            case "operator":
                user = new Operator(firstName, secondName, login);
                break;
            case "manager":
                user = new Manager(firstName, secondName, login);
                break;
            default:
                return null;
        }

        em.persist(user);

        return user;
    }

    public User findUser(String login) {
        return em.createNamedQuery(FIND_BY_LOGIN_QUERY, User.class)
                .setParameter("lll", login)
                .getSingleResult();
    }

    public List<User> listUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    public void delete(long id) {
        User user = em.find(User.class, id);
        if (user == null) throw new EntityNotFoundException("User with id " + id + " is not found");
        em.remove(user);
    }


}
