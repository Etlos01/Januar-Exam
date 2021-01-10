/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.EventDTO;
import entities.Category;
import entities.Event;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nyxis
 */
public class EventFacade {

    private static EntityManagerFactory emf;
    private static EventFacade instance;

    private EventFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static EventFacade getEventFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EventFacade();
        }
        return instance;
    }

    public EventDTO addEvent(EventDTO e, String userName) {
        EntityManager em = emf.createEntityManager();
        //Finder category object i databasen ud fra category string i EventDTO e
        User user = em.find(User.class, userName);
        Category category = em.find(Category.class, e.getCategory());

        Event event = new Event(e.getInfo(), e.getStartDate(), e.getEndDate(), e.getTitle(), e.getFullday(), category);
        user.getCalendarList().get(0).addEvent(event);
        try {
            em.getTransaction().begin();
            em.persist(event);
            em.getTransaction().commit();
        } catch (Exception error) {

        } finally {
            em.close();
        }
        EventDTO newE = new EventDTO(event);

        return newE;

    }
    
    public List<EventDTO> getEvents (String userName) {
        List<EventDTO> eventDTOList = new ArrayList<>();
        
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, userName);
        List<Event> eventList = user.getCalendarList().get(0).getEventList();
        
        for (Event event : eventList) {
            eventDTOList.add(new EventDTO(event));
        }
        return eventDTOList;
    }

    public EventDTO getEventsByCalendar(int calendarId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e INNER JOIN e.calendarList c WHERE c.id = :c_id", Event.class);
            query.setParameter("c_id", calendarId);
            return new EventDTO(query.getResultList());
        } finally {
            em.close();
        }

    }
}
