package org.wecancodeit.birdwatcher.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String birdName;
    private String imageUrl;
    private String description;

    @ManyToMany
    private Collection<Country> countries;

   @ManyToOne
   private Travel travel;

//    @ManyToMany
//    private Collection<Region> regions;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Bird(){

    }

    public Bird(String birdName, String imageUrl, String description) {
        this.birdName = birdName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.countries =  new ArrayList<>(Arrays.asList());
//        this.regions =  new ArrayList<>(Arrays.asList());
    }

    public void addCountry(Country country){
        countries.add(country);
    }
    HashMap<Long, Country> country = new HashMap<>();
    public Country getCountry(Long Id){
        return country.get(Id);
    }

    public String getBirdName() {
        return birdName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

//    public Travel getTravel() {
//        return travel;
//    }
//
//    public void setTravel(Travel travel) {
//        this.travel = travel;
//    }

    public Collection<Country> getCountries() {
        return countries;
    }
//    public Collection<Region> getRegions() {
//        return regions;
//    }
    public void setCountries(Collection<Country> countries) {
        this.countries = countries;
    }
//    public void setRegions(Collection<Region> regions) {
//        this.regions = regions;
//    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", birdName='" + birdName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return birdName.equals(bird.birdName) && imageUrl.equals(bird.imageUrl)
                && description.equals(bird.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birdName, imageUrl, description);
    }
}
