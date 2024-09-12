package io.sekiro.springdatajdbc.tennis_player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@NamedQuery(
        name="get_all_players",
        query = "SELECT p FROM Player p"
)
public class Player {
    @Id
    private Integer id;
    private String name;

    @Column(name = "nationality")
    private String Nationality;
    private Date birth_date;
    private int titles;

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Nationality='" + Nationality + '\'' +
                ", birth_date=" + birth_date +
                ", titles=" + titles +
                '}';
    }

    public Player(Integer id, String name, String nationality, Date birth_date, int titles) {
        this.id = id;
        this.name = name;
        Nationality = nationality;
        this.birth_date = birth_date;
        this.titles = titles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }
}
