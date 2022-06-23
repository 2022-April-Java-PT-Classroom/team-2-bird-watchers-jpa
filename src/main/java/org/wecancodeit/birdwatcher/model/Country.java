package org.wecancodeit.birdwatcher.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryName;
    private String description;
    private String imgUrl;

    @ManyToMany
    private Collection<Bird> birds;

    @ManyToMany
    private Collection<Region> regions;

    public Country(){

    }

    public Country(String countryName, String description, String imgUrl) {
        this.countryName = countryName;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Collection<Bird> getBirds() {
        return birds;
    }

    public void setBirds(Collection<Bird> birds) {
        this.birds = birds;
    }

    public Collection<Region> getRegions() {
        return regions;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryName.equals(country.countryName) && description.equals(country.description) && imgUrl.equals(country.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, description, imgUrl);
    }
}
