package org.wecancodeit.birdwatcher.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private Date date;
    @Lob
    private String wishes;

    @ManyToMany
    private Collection<Bird> birds;

    @ManyToOne
    private Country country;

//    @ManyToOne
//    private Region region;

    public Travel() {
    }

    public Travel(String userName, Date date, String wishes, Country country/*, Region region*/) {
        this.userName = userName;
        this.date = date;
        this.wishes = wishes;
        this.country = country;
       // this.region =  region;
        this.birds =  new ArrayList<>(Arrays.asList());
    }

    public void addBird(Bird bird){
        birds.add(bird);
    }
    HashMap<Long, Bird> bird = new HashMap<>();
    public Bird getBird(Long Id){
        return bird.get(Id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public Collection<Bird> getBirds() {
        return birds;
    }

    public void setBirds(Collection<Bird> birds) {
        this.birds = birds;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

//    public Region getRegion() {
//        return region;
//    }
//
//    public void setRegion(Region region) {
//        this.region = region;
//    }

    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                ", wishes='" + wishes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return userName.equals(travel.userName) && date.equals(travel.date) && wishes.equals(travel.wishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, date, wishes);
    }
}
