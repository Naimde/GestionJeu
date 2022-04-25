package com.GestionJeu.GestionJeu.repository;

import com.GestionJeu.GestionJeu.domain.Objet;

import org.springframework.data.repository.CrudRepository;

public interface ObjetRepository extends CrudRepository<Objet, String> {
    public Iterable<Objet> findAllByJeu(String jeu);

}
