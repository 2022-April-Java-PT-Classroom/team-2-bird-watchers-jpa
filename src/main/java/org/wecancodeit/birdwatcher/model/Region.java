package org.wecancodeit.birdwatcher.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String countryName;
    private String region;
    private String habitat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Region(){

    }

    public Region(String countryName, String region, String habitat) {
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
        return "Region{" +
                "countryName='" + countryName + '\'' +
                ", region='" + region + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return countryName.equals(region.countryName) && region.equals(region.region) && habitat.equals(region.habitat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryName, region, habitat);
    }

}
