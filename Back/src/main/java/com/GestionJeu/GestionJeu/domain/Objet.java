package com.GestionJeu.GestionJeu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Objet {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String ID_Objet;
    private String nom;
    private String description;
    private String possesseur;
    private String jeu;
    
    public String getJeu() {
        return jeu;
    }
    public void setJeu(String jeu) {
        this.jeu = jeu;
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
    public String getPossesseur() {
        return possesseur;
    }
    public void setPossesseur(String possesseur) {
        this.possesseur = possesseur;
    }
    public String getID_Objet() {
        return ID_Objet;
    }
    public void setID_Objet(String iD_Objet) {
        ID_Objet = iD_Objet;
    }

}
