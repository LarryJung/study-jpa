package com.larry.deephibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@SpringBootApplication
public class DeephibernateApplication implements CommandLineRunner {

    @Autowired
    private EntityManagerFactory emf;

    public static void main(String[] args) {
        SpringApplication.run(DeephibernateApplication.class, args);
    }

    private void logic(EntityManager em) {
        Member member1 = new Member();
        member1.setName("채균");

        em.persist(member1);
        em.detach(member1);
//        System.out.println(member1);
//        em.merge(member1);
//
//        member.setAge(20);
//
//        Member findMember = em.find(Member.class, id);
//        System.out.println(findMember);
//
//        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
//        System.out.println(members);
//
//        em.remove(member);
    }

    @Override
    public void run(String... args) throws Exception {
        // persistence unit name = default
        System.out.println(emf.getProperties().get("hibernate.ejb.persistenceUnitName").toString());
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            System.out.println("~~~~~~~~~~~~~~~~``");
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
