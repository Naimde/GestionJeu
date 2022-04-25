package com.GestionJeu.GestionJeu.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Personnage {
    @Id
    private String id_personnage;
    private String id_reelle;
    private String image;
    private String nom;
    private String prenom;
    private String surnom;
    private String genre;
    private LocalDate naissance;
    private String localisation;
    private String background;
    private String info_public;
    private String jeu;
    
    public String getJeu() {
        return jeu;
    }
    public void setJeu(String jeu) {
        this.jeu = jeu;
    }
    
    public String getId_personnage() {
        return id_personnage;
    }
    public void setId_personnage(String id_personnage) {
        this.id_personnage = id_personnage;
    }
    public String getId_reelle() {
        return id_reelle;
    }
    public void setId_reelle(String id_reelle) {
        this.id_reelle = id_reelle;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public LocalDate getNaissance() {
        return naissance;
    }
    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }
    public String getLocalisation() {
        return localisation;
    }
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public String getBackground() {
        return background;
    }
    public void setBackground(String background) {
        this.background = background;
    }
    public String getInfo_public() {
        return info_public;
    }
    public void setInfo_public(String info_public) {
        this.info_public = info_public;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getSurnom() {
        return surnom;
    }
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

}
