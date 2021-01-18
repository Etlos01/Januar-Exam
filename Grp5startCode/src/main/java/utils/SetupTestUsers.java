package utils;


import dtos.EventDTO;
import entities.Activity;
import entities.Calendar;
import entities.CityInfo;
import entities.Role;
import entities.User;
import entities.WeatherInfo;
import facades.EventFacade;
import facades.UserFacade;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class SetupTestUsers {

        private static UserFacade instance;

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//    EntityManager em = emf.createEntityManager();
//    EventFacade EVENTFACADE = EventFacade.getEventFacade(emf);
//    
//    User user = new User("user", "userPW");
//    User admin = new User("admin", "adminPW");
//    User both = new User("user_admin", "user_adminPW");
//    
//    // test af calendar
//    Calendar calendar1 = new Calendar();
//    calendar1.setTitle("testCalendar");
//    user.addCalendar(calendar1);
//    
//    // test af addEvent i EventFacaden
////    EventDTO eventDTO1 = new EventDTO("Test", "2020-11-25T12:00", "2020-11-25T13:00", "This is a test1", "Birthday", true);
////    EventDTO newEventDTO1 = EVENTFACADE.addEvent(eventDTO1);
////    EventDTO eventDTO2 = new EventDTO("Test", "2020-11-25T12:00", "2020-11-25T13:00", "This is a test2", "Birthday", true);
////    EventDTO newEventDTO2 = EVENTFACADE.addEvent(eventDTO2);
//    
//
//    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
//      throw new UnsupportedOperationException("You have not changed the passwords");
//
//    em.getTransaction().begin();
//    Role userRole = new Role("user");
//    Role adminRole = new Role("admin");
//    user.addRole(userRole);
//    admin.addRole(adminRole);
//    both.addRole(userRole);
//    both.addRole(adminRole);
//    em.persist(calendar1);
//    em.persist(userRole);
//    em.persist(adminRole);
//    em.persist(user);
//    em.persist(admin);
//    em.persist(both);
//    em.getTransaction().commit();
//    System.out.println("PW: " + user.getUserPass());
//    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
//    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
//    System.out.println("Created TEST Users");
//    System.out.println("Calendar list for user: " + user.getCalendarList());
   

       EntityManager em = emf.createEntityManager();
       
       
       
       User us1 = new User("Andreas", "kodeord1");
       User us2 = new User("Sarah", "kodeord2");
       
       Activity ac1 = new Activity("01-01-2020","Running", "12.10", 30, 10, "Ny rekord");
       Activity ac2 = new Activity("02-02-2020","Swimming", "09.30", 60, 8, "God tur");
       Activity ac3 = new Activity("03-03-2020","Hiking", "11.00", 180, 15, "Lang trave tur");
       
       WeatherInfo wi1 = new WeatherInfo(20,"Skyet",60,"10 m/s");
       WeatherInfo wi2 = new WeatherInfo(25,"Sol",50,"5 m/s");
       
       CityInfo ci1 = new CityInfo("Farum", 1000000, "Furesø",40000);
       CityInfo ci2 = new CityInfo("Hillerød", 2345553, "Hillerød",80000);
       Role ur = new Role("user");
       us1.addRole(ur);
       us2.addRole(ur);
       
       us1.addActivity(ac1);
       us2.addActivity(ac2);
       
       ac1.setCityInfo(ci1);
       ac2.setCityInfo(ci2);
       ac3.setCityInfo(ci2);
       
       ac1.setWeatherInfo(wi1);
       ac2.setWeatherInfo(wi2);
       ac3.setWeatherInfo(wi2);
       
       
       em.getTransaction().begin();
       em.persist(us1);
       em.persist(us2);
//       em.persist(ac1);
//       em.persist(ac2);
       em.getTransaction().commit();
       
       TypedQuery<Activity> q1 = em.createQuery("SELECT a FROM Activity a",Activity.class);
       List<Activity> activities1 = q1.getResultList();
       
       for(Activity a : activities1){
           System.out.println(a.getUser().getUserName() + " did some " + a.getType());
       }
//       em.getTransaction().begin();
//       ac3.setUser(us1);
//       em.getTransaction().commit();
       
       System.out.println(us1.getActivityList().contains(ac3));
       
//       em.getTransaction().begin();
//       us1.removeActivity(ac1);
//       us2.removeActivity(ac2);
//       em.getTransaction().commit();
       
              System.out.println(us1.getActivityList().contains(ac2));

       TypedQuery<Activity> q2 = em.createQuery("SELECT a FROM Activity a WHERE a.user.userName = :u_id",Activity.class);
       q2.setParameter("u_id", us1.getUserName());
       List<Activity> activities2 = q2.getResultList();
       
       for(Activity a : activities2){
           System.out.println(a.getUser().getUserName() + " have been " + a.getType() + " on the " + a.getDate() + " in " + a.getCityInfo().getName());
       }
       
       TypedQuery<Activity> q3 = em.createQuery("SELECT a FROM Activity a",Activity.class);
       List<Activity> activities3 = q3.getResultList();
       
       for(Activity a : activities3){
           System.out.println("All: " + a.getType());
       }
  }

}
