/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Category;
import entities.Role;
//pending implementation...
//import entities.Category;
import entities.Holiday;
import dtos.HolidayDTO;
import java.io.IOException;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alex Wagner
 */
public class SetupDatabase {

    public static void main(String[] args) throws IOException {

        //Fetch Holidays from foreign API and persist in database.
        setupHolidays();

        //pending implementation...
        //setupCategories();
        setupEventCategories();
        
        //not planned yet 
//        setupRoles();
    }

    //use this on a clean database, to populate Roles
    private static void setupRoles() {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Role r1 = new Role("Role-1");
        Role r2 = new Role("Role-2");
        Role r3 = new Role("Role-3");

        em.persist(r1);
        em.persist(r2);
        em.persist(r3);

        em.getTransaction().commit();
    }

    private static void setupHolidays() throws IOException {

        Collection<HolidayDTO> holidays = new facades.DataFetcherFacade().getHolidaysDTO();

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        for (HolidayDTO h : holidays) {

            em.persist(new Holiday(h));
        }

        em.getTransaction().commit();
    }

    private static void setupEventCategories() {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Category c1 = new Category("Vacation");
        Category c2 = new Category("Birthday");
        Category c3 = new Category("Reminder");
        Category c4 = new Category("Work appointment");

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);

        em.getTransaction().commit();

    }
}
