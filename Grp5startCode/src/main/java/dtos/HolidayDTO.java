/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Holiday;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Wagner
 */
public class HolidayDTO {

    String date;
    String name;
    String localName;
    String countryCode;
    List<HolidayDTO> allHolidays = new ArrayList();

    public HolidayDTO(String date, String localName, String name, String countryCode) {
        this.date = date;
        this.name = name;
        this.localName = localName;
        this.countryCode = countryCode;
    }

    public HolidayDTO(Holiday h) {
        this.date = h.getDate();
        this.name = h.getName();
        this.localName = h.getLocalName();
        this.countryCode = h.getCountryCode();
    }
    
    public HolidayDTO(List<Holiday> h){
        h.forEach((hDTO) -> {
            allHolidays.add(new HolidayDTO(hDTO));
        });
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
