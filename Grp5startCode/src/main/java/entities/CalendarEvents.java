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
@Table(name = "calendar_events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarEvents.findAll", query = "SELECT c FROM CalendarEvents c"),
    @NamedQuery(name = "CalendarEvents.findByCalendarId", query = "SELECT c FROM CalendarEvents c WHERE c.calendarEventsPK.calendarId = :calendarId"),
    @NamedQuery(name = "CalendarEvents.findByEventId", query = "SELECT c FROM CalendarEvents c WHERE c.calendarEventsPK.eventId = :eventId")})
public class CalendarEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalendarEventsPK calendarEventsPK;
    @JoinColumns({
        @JoinColumn(name = "calendar_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "calendar_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Calendar calendar;
    @JoinColumns({
        @JoinColumn(name = "event_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "event_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Event event;

    public CalendarEvents() {
    }

    public CalendarEvents(CalendarEventsPK calendarEventsPK) {
        this.calendarEventsPK = calendarEventsPK;
    }

    public CalendarEvents(int calendarId, int eventId) {
        this.calendarEventsPK = new CalendarEventsPK(calendarId, eventId);
    }

    public CalendarEventsPK getCalendarEventsPK() {
        return calendarEventsPK;
    }

    public void setCalendarEventsPK(CalendarEventsPK calendarEventsPK) {
        this.calendarEventsPK = calendarEventsPK;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarEventsPK != null ? calendarEventsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarEvents)) {
            return false;
        }
        CalendarEvents other = (CalendarEvents) object;
        if ((this.calendarEventsPK == null && other.calendarEventsPK != null) || (this.calendarEventsPK != null && !this.calendarEventsPK.equals(other.calendarEventsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CalendarEvents[ calendarEventsPK=" + calendarEventsPK + " ]";
    }
    
}
