/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Activity;

/**
 *
 * @author Nyxis
 */
public class ActivityDTO {
    
    private String date;
    private String type;
    private String timeOfDay;
    private int duration;
    private int distance;
    private String comment;
    private String cityName;

    public ActivityDTO(Activity a) {
        this.date = a.getDate();
        this.type = a.getType();
        this.timeOfDay = a.getTimeOfDay();
        this.duration = a.getDuration();
        this.distance = a.getDistance();
        this.comment = a.getComment();
        this.cityName = a.getCityInfo().getName();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    
}
