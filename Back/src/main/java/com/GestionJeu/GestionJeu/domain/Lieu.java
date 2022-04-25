package com.GestionJeu.GestionJeu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lieu {
    @Id
    private String id_lieu;
    private String genre;
    private String nom;
    private String description;
    private String jeu;
    
    public String getJeu() {
        return jeu;
    }
    public void setJeu(String jeu) {
        this.jeu = jeu;
    }

    public String getId_lieu() {
        return id_lieu;
    }
    public void setId_lieu(String id_lieu) {
        this.id_lieu = id_lieu;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

}
