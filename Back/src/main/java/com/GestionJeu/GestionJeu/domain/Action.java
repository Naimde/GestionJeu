package com.GestionJeu.GestionJeu.domain;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Action {
    @Id
    private String id_action;
    private String id_personnage;
    private Timestamp moment;
    private String type_action;
    private String commentaire;
    private String id_cible;
    
    public String getId_personnage() {
        return id_personnage;
    }
    public void setId_personnage(String id_personnage) {
        this.id_personnage = id_personnage;
    }
    public Timestamp getMoment() {
        return moment;
    }
    public void setMoment(Timestamp moment) {
        this.moment = moment;
    }
    public String getType_action() {
        return type_action;
    }
    public void setType_action(String type_action) {
        this.type_action = type_action;
    }
    public String getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    public String getId_cible() {
        return id_cible;
    }
    public void setId_cible(String id_cible) {
        this.id_cible = id_cible;
    }
    public String getId_action() {
        return id_action;
    }
    public void setId_action(String id_action) {
        this.id_action = id_action;
    }

}
