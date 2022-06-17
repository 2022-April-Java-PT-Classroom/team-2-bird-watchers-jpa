package org.wecancodeit.birdwatcher.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regionName;
    private String habitat;

    public Region() {
    }

    public Region(String region, String habitat) {
        this.regionName = region;
        this.habitat = habitat;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return regionName.equals(region.regionName) && habitat.equals(region.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionName, habitat);
    }
}
