package com.GestionJeu.GestionJeu.repository;

import com.GestionJeu.GestionJeu.composite.JeuComposite;
import com.GestionJeu.GestionJeu.domain.Jeu;

import org.springframework.data.repository.CrudRepository;

public interface JeuRepository extends CrudRepository<Jeu, JeuComposite> {
    public Iterable<Jeu> findAllByJeu(String jeu);
    public Iterable<Jeu> findAllByUser(String user);
}
