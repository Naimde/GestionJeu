package com.GestionJeu.GestionJeu.dto;

import java.sql.Timestamp;

public class ActionRequest {
    public String id_action;
    public String id_personnage;
    public Timestamp moment;
    public String type_action;
    public String commentaire;
    public String id_cible;
}
