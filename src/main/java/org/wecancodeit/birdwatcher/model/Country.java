package org.wecancodeit.birdwatcher.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Entity
public class Country {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Long id;

    //    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idOne;
    private String countryName;
    private String region;
    private String habitat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country(){

    }

    public Country(String countryName, String region, String habitat) {
        this.countryName = countryName;
        this.region = region;
        this.habitat = habitat;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegion() {
        return region;
    }

    public String getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", region='" + region + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryName.equals(country.countryName) && region.equals(country.region) && habitat.equals(country.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, region, habitat);
    }
}
