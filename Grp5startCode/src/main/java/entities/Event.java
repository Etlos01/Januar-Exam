/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.EventDTO;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nyxis
 */
@Entity
@Table(name = "events")
@XmlRootElement
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "calendar_id")
    private Integer calendarId;
    @Size(max = 255)
    @Column(name = "info")
    private String info;
    @Size(max = 45)
    @Column(name = "start")
    private String start;
    @Size(max = 45)
    @Column(name = "stop")
    private String stop;
    @Size(max = 125)
    @Column(name = "title")
    private String title;
    @Column(name = "fullday", nullable = false)
    private Boolean fullday;
    @JoinColumn(name = "category", referencedColumnName = "name")
    @ManyToOne
    private Category category;
    @ManyToMany(mappedBy = "eventList")
    private List<Calendar> calendarList;

    public Event() {   
    }

    public Event(String info, String start, String stop, String title, Boolean fullday, Category category) {
        this.info = info;
        this.start = start;
        this.stop = stop;
        this.title = title;
        this.fullday = fullday;
        this.calendarList = new ArrayList<>();
        this.category = category;
    }

   
    
    public Event(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Integer calendarId) {
        this.calendarId = calendarId;
    }


    public Boolean getFullday() {
        return fullday;
    }

    public void setFullday(Boolean fullday) {
        this.fullday = fullday;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<Calendar> getCalendarList() {
        return calendarList;
    }

    public void setCalendarList(List<Calendar> calendarList) {
        this.calendarList = calendarList;
    }
    
}
