package org.wecancodeit.birdwatcher.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String birdName;
    private String imageUrl;
    private String description;
    private String countryName;
    private String region;
    private String habitat;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Bird(){

    }

    public Bird(String birdName, String imageUrl, String description,
                String countryName, String region, String habitat) {
        this.birdName = birdName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.countryName = countryName;
        this.region = region;
        this.habitat = habitat;
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
        return "Bird{" +
                "birdName='" + birdName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", countryName='" + countryName + '\'' +
                ", region='" + region + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return birdName.equals(bird.birdName) && birdName.equals(bird.imageUrl) &&
                birdName.equals(bird.description) && birdName.equals(bird.countryName) &&
                region.equals(bird.region) && habitat.equals(bird.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birdName, imageUrl, description, countryName,
                region, habitat);
    }
}
