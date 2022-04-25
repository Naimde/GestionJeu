package com.GestionJeu.GestionJeu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.GestionJeu.GestionJeu.composite.MembreComposite;

@Entity
@IdClass(MembreComposite.class)
public class Membre {
    @Id
    private String idGroupe;
    @Id
    private String idPersonnage;
    private String description;
    
    public String getIdGroupe() {
        return idGroupe;
    }
    public void setIdGroupe(String idGroupe) {
        this.idGroupe = idGroupe;
    }
    public String getIdPersonnage() {
        return idPersonnage;
    }
    public void setIdPersonnage(String idPersonnage) {
        this.idPersonnage = idPersonnage;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
