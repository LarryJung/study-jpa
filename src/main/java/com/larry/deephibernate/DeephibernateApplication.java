package com.larry.deephibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@SpringBootApplication
public class DeephibernateApplication implements CommandLineRunner {

    @Autowired
    private EntityManagerFactory emf;

    public static void main(String[] args) {
        SpringApplication.run(DeephibernateApplication.class, args);
    }

    private void logic(EntityManager em) {
        Delivery delivery = new Delivery();
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        em.persist(order);
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
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
