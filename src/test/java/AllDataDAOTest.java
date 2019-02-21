import DAO.AllDataDAO;
import DAO.UsersDAO;
import entity.AllData;
import entity.Operator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AllDataDAOTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private UsersDAO users;
    @Autowired
    private AllDataDAO allDatas;

//    @Before
//    public void setup() {
//        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
//        em = factory.createEntityManager();
//        users = new UsersDAO(em);
//        allDatas = new AllDataDAO(em);
//    }
//
//    @After
//    public void stop() {
//        if (em != null) {
//            em.close();
//        }
//        if (factory != null) {
//            factory.close();
//        }
//    }

    @Test
    public void testCreateAllData() {
        em.getTransaction().begin();

        Date purchaseDate = new Date (2018,10,11);
        Date saleDate = new Date (2018, 10, 17);

        Operator operator = users.createOperator("Petr", "Petrov","operator2");
        AllData allData = allDatas.createAllData(operator,
                purchaseDate,
                saleDate,
                "Jaguar",
                "XE",
                3836155.93,
                5115600.00,
                300.00,
                3250979.60,
                "new",
                1);

        em.getTransaction().commit();
    }

    @Test
    public void testFindOperatorsAllData() {
        em.getTransaction().begin();

        Date purchaseDate = new Date (2018,10,17);
        Date saleDate = new Date (2018, 11, 23);

        Operator operator = users.createOperator("Alex", "Alexandrov","operator3");
        AllData allData = allDatas.createAllData(operator,
                purchaseDate,
                saleDate,
                "JaguarF",
                "F-Pace",
                3382779.66,
                4332000.00,
                300.00,
                3250979.60,
                "used",
                1);
        operator.setAllData(Arrays.asList(allData));

        em.getTransaction().commit();

        em.refresh(operator);

        List<AllData> found = operator.getAllData();
        System.out.println(found);
        assertNotNull(found);
        assertNotEquals(0, found.size());
        assertSame(allData, found.get(0));
    }

}
