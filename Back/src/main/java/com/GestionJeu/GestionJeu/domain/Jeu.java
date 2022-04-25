package com.GestionJeu.GestionJeu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.GestionJeu.GestionJeu.composite.JeuComposite;

@Entity
@IdClass(JeuComposite.class)
public class Jeu {
    @Id
    private String jeu;
    private String id_personnage;
    @Id
    private String user;

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
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
   
}
