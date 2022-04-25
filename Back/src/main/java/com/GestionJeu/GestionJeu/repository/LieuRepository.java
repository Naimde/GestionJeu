package com.GestionJeu.GestionJeu.repository;

import com.GestionJeu.GestionJeu.domain.Lieu;

import org.springframework.data.repository.CrudRepository;

public interface LieuRepository extends CrudRepository<Lieu, String> {
    public Iterable<Lieu> findAllByJeu(String jeu);
}
