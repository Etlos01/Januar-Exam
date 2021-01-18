/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.persistence.tools.schemaframework.PopulationManager;

/**
 *
 * @author Nyxis
 */
@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int geoCoordinates;
    private String municipality;
    private int population;
    
    @OneToMany(mappedBy = "cityInfo")
    private List<Activity> activityList;

    public CityInfo() {
    }

    public CityInfo(String name, int geoCoordinates, String municipality, int population) {
        this.name = name;
        this.geoCoordinates = geoCoordinates;
        this.municipality = municipality;
        this.population = population;
        this.activityList = new ArrayList<>();
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
