/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.CityInfo;

/**
 *
 * @author Nyxis
 */
public class CityInfoDTO {
    
    private String name;
    private int geoCoordinates;
    private String municipality;
    private int population;

    public CityInfoDTO(CityInfo c) {
        this.name = c.getName();
        this.geoCoordinates = c.getGeoCoordinates();
        this.municipality = c.getMunicipality();
        this.population = c.getPopulation();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(int geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    
    
}
