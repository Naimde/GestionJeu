package com.GestionJeu.GestionJeu.repository;

import com.GestionJeu.GestionJeu.domain.Groupe;

import org.springframework.data.repository.CrudRepository;

public interface GroupeRepository extends CrudRepository<Groupe, String> {
    public Iterable<Groupe> findAllByJeu(String jeu);
}
