/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Nyxis
 */
public class UserDTO {

    private String fname;
    private String password;

    private List<HolidayDTO> holidays = new ArrayList<>();

    private static EntityManagerFactory emf;

    public UserDTO(User u) {
        this.fname = u.getUserName();
        this.password = u.getUserPass();
    }

    public String getFname() {
        return fname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<HolidayDTO> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<HolidayDTO> holidays) {
        this.holidays = holidays;
    }

}
