package DAO;

import entity.Operator;
import entity.User;

import javax.persistence.EntityManager;

import static entity.User.FIND_BY_LOGIN_QUERY;

public class UsersDAO {
    private EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public Operator createOperator(String firstName, String secondName,String login) {
        Operator operator = new Operator(firstName, secondName, login);
        em.persist(operator);
        return operator;
    }

    public User findUser(String login) {
        return em.createNamedQuery(FIND_BY_LOGIN_QUERY, User.class)
                .setParameter("lll", login)
                .getSingleResult();
    }

}
