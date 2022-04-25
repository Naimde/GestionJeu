package com.GestionJeu.GestionJeu.repository;

import com.GestionJeu.GestionJeu.composite.MembreComposite;
import com.GestionJeu.GestionJeu.domain.Membre;

import org.springframework.data.repository.CrudRepository;

public interface MembreRepository extends CrudRepository<Membre, MembreComposite> {
    public Iterable<Membre> findAllByIdPersonnage(String id_personnage);
    public Iterable<Membre> findAllByIdGroupe(String id_groupe);
}
