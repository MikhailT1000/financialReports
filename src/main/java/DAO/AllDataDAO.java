package DAO;

import entity.AllData;
import entity.Operator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Service
public class AllDataDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public AllData createAllData(Operator operator, Date purchaseDate, Date saleDate, String brand, String model, double purchasePrice, double salePrice, double discount, double costPrice, String type, int quantity) {
        AllData allData = new AllData(purchaseDate, saleDate, brand, model, purchasePrice, salePrice, discount, costPrice, type, quantity);
        allData.setOperator(operator);
        em.persist(allData);
        return allData;
    }
}
