package DAO;

import entity.Operator;

import javax.persistence.EntityManager;

public class UsersDAO {
    private EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public Operator createOperator(String login) {
        Operator operator = new Operator(login);
        em.persist(operator);
        return operator;
    }

}
