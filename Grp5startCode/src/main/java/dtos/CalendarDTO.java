/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Calendar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ckfol
 */
public class CalendarDTO {
    private int id;
    private String title;
    
    private List<HolidayDTO> holidays = new ArrayList<>();

    public CalendarDTO(Calendar calendar) {
        this.id = calendar.getId();
        this.title = calendar.getTitle();
    }
    
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    
}
