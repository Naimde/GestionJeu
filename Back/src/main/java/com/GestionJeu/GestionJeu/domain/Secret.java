package com.GestionJeu.GestionJeu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Secret {
    @Id
    private String id_secret;
    private String id_cible;
    private String description;

    public String getId_secret() {
        return id_secret;
    }
    public void setId_secret(String id_secret) {
        this.id_secret = id_secret;
    }
    public String getId_cible() {
        return id_cible;
    }
    public void setId_cible(String id_cible) {
        this.id_cible = id_cible;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
