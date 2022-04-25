package com.GestionJeu.GestionJeu.repository;

import com.GestionJeu.GestionJeu.domain.Personnage;

import org.springframework.data.repository.CrudRepository;

public interface PersonnageRepository extends CrudRepository<Personnage, String> {
    public Iterable<Personnage> findAllByLocalisation(String localisation);
    public Iterable<Personnage> findAllByJeu(String jeu);
}
