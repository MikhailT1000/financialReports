package DAO;

import entity.AllData;
import entity.Operator;

import javax.persistence.EntityManager;

public class AllDataDAO {

    private EntityManager em;

    public AllDataDAO(EntityManager em) {
        this.em = em;
    }

    public AllData createAllData(Operator operator, String purchaseDate, String saleDate, String brand, String model, double price, int discount, double costPrice, String type, int quantity) {
        AllData allData = new AllData(purchaseDate, saleDate, brand, model, price, discount, costPrice, type, quantity);
        allData.setOperator(operator);
        em.persist(allData);
        return allData;
    }
}
