package inflearn.jpabasic.jpabasic01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaBasic01Application {

    public static void main(String[] args) {
//		SpringApplication.run(JpaBasic01Application.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 비영속
            Member member1 = new Member(3L, "A");
            Member member2 = new Member(4L, "5");

            // 영속
            System.out.println("=== Before ===");
            em.persist(member1);
            em.persist(member2);
            System.out.println("=== After ===");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
