/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex Wagner
 */
@Entity
@Table(name = "user_calendars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserCalendars.findAll", query = "SELECT u FROM UserCalendars u"),
    @NamedQuery(name = "UserCalendars.findByUserUserName", query = "SELECT u FROM UserCalendars u WHERE u.userCalendarsPK.userUserName = :userUserName"),
    @NamedQuery(name = "UserCalendars.findByCalendarId", query = "SELECT u FROM UserCalendars u WHERE u.userCalendarsPK.calendarId = :calendarId")})
public class UserCalendars implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserCalendarsPK userCalendarsPK;
    @JoinColumns({
        @JoinColumn(name = "calendar_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "calendar_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Calendar calendar;
    @JoinColumns({
        @JoinColumn(name = "user_user_name", referencedColumnName = "user_name", insertable = false, updatable = false),
        @JoinColumn(name = "user_user_name", referencedColumnName = "user_name", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private User user;

    public UserCalendars() {
    }

    public UserCalendars(UserCalendarsPK userCalendarsPK) {
        this.userCalendarsPK = userCalendarsPK;
    }

    public UserCalendars(String userUserName, int calendarId) {
        this.userCalendarsPK = new UserCalendarsPK(userUserName, calendarId);
    }

    public UserCalendarsPK getUserCalendarsPK() {
        return userCalendarsPK;
    }

    public void setUserCalendarsPK(UserCalendarsPK userCalendarsPK) {
        this.userCalendarsPK = userCalendarsPK;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCalendarsPK != null ? userCalendarsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCalendars)) {
            return false;
        }
        UserCalendars other = (UserCalendars) object;
        if ((this.userCalendarsPK == null && other.userCalendarsPK != null) || (this.userCalendarsPK != null && !this.userCalendarsPK.equals(other.userCalendarsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserCalendars[ userCalendarsPK=" + userCalendarsPK + " ]";
    }
    
}
