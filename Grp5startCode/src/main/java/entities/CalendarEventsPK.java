/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alex Wagner
 */
@Embeddable
public class CalendarEventsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "calendar_id")
    private int calendarId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_id")
    private int eventId;

    public CalendarEventsPK() {
    }

    public CalendarEventsPK(int calendarId, int eventId) {
        this.calendarId = calendarId;
        this.eventId = eventId;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) calendarId;
        hash += (int) eventId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarEventsPK)) {
            return false;
        }
        CalendarEventsPK other = (CalendarEventsPK) object;
        if (this.calendarId != other.calendarId) {
            return false;
        }
        if (this.eventId != other.eventId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CalendarEventsPK[ calendarId=" + calendarId + ", eventId=" + eventId + " ]";
    }
    
}
