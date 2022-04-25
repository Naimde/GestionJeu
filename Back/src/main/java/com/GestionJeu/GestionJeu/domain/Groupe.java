package com.GestionJeu.GestionJeu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Groupe {
    @Id
    private String id_groupe;
    private String genre;
    private String nom;
    private String description;
    private boolean visionautre;
    private String leader;
    private String jeu;
    
    public String getJeu() {
        return jeu;
    }
    public void setJeu(String jeu) {
        this.jeu = jeu;
    }
    
    public String getId_groupe() {
        return id_groupe;
    }
    public void setId_groupe(String id_groupe) {
        this.id_groupe = id_groupe;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
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
    public String getLeader() {
        return leader;
    }
    public void setLeader(String leader) {
        this.leader = leader;
    }
    public boolean isVisionautre() {
        return visionautre;
    }
    public void setVisionautre(boolean visionautre) {
        this.visionautre = visionautre;
    }

}
