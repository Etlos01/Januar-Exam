package utils;


import dtos.EventDTO;
import entities.Calendar;
import entities.Role;
import entities.User;
import facades.EventFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    EventFacade EVENTFACADE = EventFacade.getEventFacade(emf);
    
    User user = new User("user", "userPW");
    User admin = new User("admin", "adminPW");
    User both = new User("user_admin", "user_adminPW");
    
    // test af calendar
    Calendar calendar1 = new Calendar();
    calendar1.setTitle("testCalendar");
    user.addCalendar(calendar1);
    
    // test af addEvent i EventFacaden
//    EventDTO eventDTO1 = new EventDTO("Test", "2020-11-25T12:00", "2020-11-25T13:00", "This is a test1", "Birthday", true);
//    EventDTO newEventDTO1 = EVENTFACADE.addEvent(eventDTO1);
//    EventDTO eventDTO2 = new EventDTO("Test", "2020-11-25T12:00", "2020-11-25T13:00", "This is a test2", "Birthday", true);
//    EventDTO newEventDTO2 = EVENTFACADE.addEvent(eventDTO2);
    

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(calendar1);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    System.out.println("Calendar list for user: " + user.getCalendarList());
   
  }

}
