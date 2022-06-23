package org.wecancodeit.birdwatcher.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", nullable = false)
    private Long id;
    private String userName;
    private Date date;
    @Lob
    private String wishes;

    @ManyToOne
    private Bird bird;

    @ManyToOne
    private Country country;

    @ManyToOne
    private Region region;

    @ManyToOne
    private Habitat habitat;


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

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Excursion{" +
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
        Excursion excursion = (Excursion) o;
        return userName.equals(excursion.userName) && date.equals(excursion.date)
                && wishes.equals(excursion.wishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, date, wishes);
    }
}
