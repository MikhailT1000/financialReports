package DAO;

import entity.AllData;
import entity.Operator;

import javax.persistence.EntityManager;
import java.util.Date;

public class AllDataDAO {

    private EntityManager em;

    public AllDataDAO(EntityManager em) {
        this.em = em;
    }

    public AllData createAllData(Operator operator, Date purchaseDate, Date saleDate, String brand, String model, double purchasePrice, double salePrice, double discount, double costPrice, String type, int quantity) {
        AllData allData = new AllData(purchaseDate, saleDate, brand, model, purchasePrice, salePrice, discount, costPrice, type, quantity);
        allData.setOperator(operator);
        em.persist(allData);
        return allData;
    }
}
