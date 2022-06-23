package org.wecancodeit.birdwatcher.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Habitat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", nullable = false)
    private Long id;
    private String habitatName;
    @ManyToMany
    private Collection<Country> countries;
    @ManyToMany
    private Collection<Region> regions;


    public Habitat() {
    }

    public Habitat(String habitatName) {
        this.habitatName = habitatName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabitatName() {
        return habitatName;
    }

    public void setHabitatName(String habitatName) {
        this.habitatName = habitatName;
        this.countries =  new ArrayList<>(Arrays.asList());
    }

    public void addCountry(Country country){
        countries.add(country);
    }
    HashMap<Long, Country> country = new HashMap<>();
    public Country getCountry(Long Id){
        return country.get(Id);
    }

    public Collection<Country> getCountries() {
        return countries;
    }

    public void setCountries(Collection<Country> countries) {
        this.countries = countries;
    }

    public Collection<Region> getRegions() {
        return regions;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "id=" + id +
                ", habitatName='" + habitatName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitat habitat = (Habitat) o;
        return habitatName.equals(habitat.habitatName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitatName);
    }

}
