//import entity.AllData;
//import entity.Operator;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.util.Date;
//
//public class App {
//    public static void main(String[] args) throws Exception {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
//        EntityManager em = factory.createEntityManager();
//
//        try {
//
//            em.getTransaction().begin();
//
//            try {
//                Operator operator = createOperator(em, "user1");
//                createAllData(em, operator, "09.01.2019", "29.01.2019", "Jaguar","E-TYPE", 3500000.00, 10, 3000000.00, "new", 1);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//                throw e;
//            }
//        } finally {
//            em.close();
//            factory.close();
//        }
//    }
//
//
//
//}
