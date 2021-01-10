/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ckfol
 */
@Entity
@Table(name = "calendars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c"),
    @NamedQuery(name = "Calendar.findById", query = "SELECT c FROM Calendar c WHERE c.id = :id"),
    @NamedQuery(name = "Calendar.findByTitle", query = "SELECT c FROM Calendar c WHERE c.title = :title")})
public class Calendar implements Serializable {

    @Size(max = 125)
    @Column(name = "title")
    private String title;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinTable(name = "user_calendars", joinColumns = {
        @JoinColumn(name = "calendar_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_user_name", referencedColumnName = "user_name")})
    @ManyToMany
    private List<User> userList = new ArrayList<>();

    @JoinTable(name = "calendar_events", joinColumns = {
        @JoinColumn(name = "calendar_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "event_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Event> eventList;
    
    public Calendar() {
    }

    public Calendar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
    
    public void addEvent(Event event){
        if(event != null){
            this.eventList.add(event);
            event.getCalendarList().add(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
