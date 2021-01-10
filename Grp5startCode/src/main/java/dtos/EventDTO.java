/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Event;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Nyxis
 */
public class EventDTO {
    
    private int id;
    private String title;
    private String startDate;
    private String endDate;
    private String info;
    private String category;
    private Boolean fullday;
    private List<EventDTO> allEvents = new ArrayList();

//    public EventDTO(String title, String startDate, String endDate, String info, String category, Boolean fullday) {
//        this.title = title;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.info = info;
//        this.category = category;
//        this.fullday = fullday;
//    }
    
    
    
    public EventDTO(Event e){
        this.id = e.getId();
        this.title = e.getTitle();
        this.startDate = e.getStart();
        this.endDate = e.getStop();
        this.info = e.getInfo();
        this.category = CheckCategory(e);
        this.fullday = e.getFullday();
    }
    
    
    
     public String CheckCategory(Event e){
         if (e.getCategory() == null) {
             return "";
         }else{
             return e.getCategory().getName();
         }
    }
    
    public EventDTO(List<Event> eventList){
        eventList.forEach((e) -> {
            allEvents.add(new EventDTO(e));
        });
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getFullday() {
        return fullday;
    }

    public void setFullday(Boolean fullday) {
        this.fullday = fullday;
    }
    
    
    
}
