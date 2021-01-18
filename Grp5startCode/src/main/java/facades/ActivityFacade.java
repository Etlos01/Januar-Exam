/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.ActivityDTO;
import entities.Activity;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Nyxis
 */
public class ActivityFacade {
    
    private static EntityManagerFactory emf;
    private static ActivityFacade instance;
    
    private ActivityFacade(){
    }
    
    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static ActivityFacade getActivityFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ActivityFacade();
        }
        return instance;
    }
    
    public ActivityDTO addActivity(ActivityDTO a, String userName){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, userName);
        Activity activity = new Activity(a.getDate(),a.getType(),a.getTimeOfDay(),a.getDuration(),a.getDistance(),a.getComment());
        user.addActivity(activity);
        try{
            em.getTransaction().begin();
            em.persist(activity);
            em.getTransaction().commit();
        } catch (Exception error) {
            
        } finally {
            em.close();
        }
        ActivityDTO newA = new ActivityDTO(activity);
        return newA;
    }
    
    public List<ActivityDTO> getActivities (String userName) {
        List<ActivityDTO> ActivityDTOList = new ArrayList<>();
        
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, userName);
        List<Activity> activities = user.getActivityList();
        
        for (Activity activity : activities) {
            ActivityDTOList.add(new ActivityDTO(activity));
        }
        return ActivityDTOList;
    }
}
