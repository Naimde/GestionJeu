package com.GestionJeu.GestionJeu.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.GestionJeu.GestionJeu.composite.ConnuComposite;

@Entity
@IdClass(ConnuComposite.class)
public class Connu {
    @Id
    private String idPersonnage;
    @Id
    private String idCible;
    private String description;
    private String note;
    private Timestamp date_ajout;

    public String getidPersonnage() {
        return idPersonnage;
    }
    public void setidPersonnage(String idPersonnage) {
        this.idPersonnage = idPersonnage;
    }
    public String getidCible() {
        return idCible;
    }
    public void setidCible(String idCible) {
        this.idCible = idCible;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Timestamp getDate_ajout() {
        return date_ajout;
    }
    public void setDate_ajout(Timestamp date_ajout) {
        this.date_ajout = date_ajout;
    }
    
}
