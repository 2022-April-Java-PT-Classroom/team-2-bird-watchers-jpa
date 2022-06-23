package org.wecancodeit.birdwatcher.model;
import javax.persistence.*;
import java.util.*;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regionName;
    @ManyToMany
    private Collection<Country> countries;

    @ManyToMany
    private Collection<Habitat> habitats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Region(){

    }

    public Region(String regionName) {
        this.regionName = regionName;
        this.countries =  new ArrayList<>(Arrays.asList());
        this.habitats =  new ArrayList<>(Arrays.asList());
    }

    public void addCountry(Country country){
        countries.add(country);
    }
    HashMap<Long, Country> country = new HashMap<>();
    public Country getCountry(Long Id){
        return country.get(Id);
    }

    public void addHabitat(Habitat habitat){
        habitats.add(habitat);
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Collection<Country> getCountries() {
        return countries;
    }

    public void setCountries(Collection<Country> countries) {
        this.countries = countries;
    }

    public Collection<Habitat> getHabitat() {
        return habitats;
    }

    public void setHabitat(Collection<Habitat> habitats) {
        this.habitats = habitats;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return regionName.equals(region.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionName);
    }
}
