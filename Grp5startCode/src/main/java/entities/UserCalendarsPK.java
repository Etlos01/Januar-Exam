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
import javax.validation.constraints.Size;

/**
 *
 * @author Alex Wagner
 */
@Embeddable
public class UserCalendarsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "user_user_name")
    private String userUserName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calendar_id")
    private int calendarId;

    public UserCalendarsPK() {
    }

    public UserCalendarsPK(String userUserName, int calendarId) {
        this.userUserName = userUserName;
        this.calendarId = calendarId;
    }

    public String getUserUserName() {
        return userUserName;
    }

    public void setUserUserName(String userUserName) {
        this.userUserName = userUserName;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userUserName != null ? userUserName.hashCode() : 0);
        hash += (int) calendarId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCalendarsPK)) {
            return false;
        }
        UserCalendarsPK other = (UserCalendarsPK) object;
        if ((this.userUserName == null && other.userUserName != null) || (this.userUserName != null && !this.userUserName.equals(other.userUserName))) {
            return false;
        }
        if (this.calendarId != other.calendarId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserCalendarsPK[ userUserName=" + userUserName + ", calendarId=" + calendarId + " ]";
    }
    
}
