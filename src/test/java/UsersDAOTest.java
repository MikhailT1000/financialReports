import DAO.UsersDAO;
import entity.Operator;
import entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class UsersDAOTest {

    private EntityManagerFactory factory;
    private EntityManager em;
    private UsersDAO users;

    @Before
    public void setup() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        users = new UsersDAO(em);
    }

    @Test
    public void testCreateOperator() {
        em.getTransaction().begin();
        Operator operator = users.createOperator("Ivan","Ivanov", "operator1");
        em.getTransaction().commit();

        assertNotEquals(0L, operator.getId());
        assertEquals("operator1", operator.getLogin());
        assertEquals("Ivan", operator.getFirstName());
        assertEquals("Ivanov", operator.getSecondName());

        Operator found = em.find(Operator.class, operator.getId());
        assertNotNull(found);
        assertEquals("operator1", found.getLogin());

        User foundByLogin = users.findUser("operator1");
        assertNotNull(foundByLogin);
        if (!(foundByLogin instanceof Operator)) {
            fail("Expected an instance of Operator but " + foundByLogin.getClass().getSimpleName() + " found");
        }
    }

    @After
    public void stop() {
        if (em != null) {
            em.close();
        }
        if (factory != null) {
            factory.close();
        }
    }

}
