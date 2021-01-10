/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ckfol
 */
public class CalendarFacade {

    private static EntityManagerFactory emf;
    private static CalendarFacade instance;

    private CalendarFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static CalendarFacade getCalendarFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CalendarFacade();
        }
        return instance;
    }
}
