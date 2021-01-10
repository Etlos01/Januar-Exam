/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.HolidayDTO;
import entities.Holiday;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alex Wagner
 */
public class HolidayFacade {

    private static HolidayFacade instance;
    private static EntityManagerFactory emf;

    private HolidayFacade() {

    }

    public static HolidayFacade getHolidayFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HolidayFacade();
        }
        return instance;
    }

    public HolidayDTO getHolidays() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Holiday> q = em.createQuery("SELECT h FROM Holiday h", Holiday.class);
            return new HolidayDTO(q.getResultList());

        } finally {
            em.close();
        }

    }

}
