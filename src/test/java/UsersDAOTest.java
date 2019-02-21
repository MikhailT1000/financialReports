import DAO.UsersDAO;
import entity.Operator;
import entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UsersDAOTest {
    @Autowired
    private EntityManager em;

    @Autowired
    private UsersDAO users;

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

}
