package com.psg.machineLearing.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MOVIE")
public class Movie {

    @Id
    @Column(name="ID")
    private int id;
    
    @Column(name="TITLE")
    private String title;
    
    @Column(name="GENRE")
    private String genre;
    
    @Column(name="DESCRIPTION")
    private String description;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
