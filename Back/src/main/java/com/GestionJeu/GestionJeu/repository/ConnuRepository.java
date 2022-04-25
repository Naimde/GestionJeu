package com.GestionJeu.GestionJeu.repository;

import com.GestionJeu.GestionJeu.composite.ConnuComposite;
import com.GestionJeu.GestionJeu.domain.Connu;

import org.springframework.data.repository.CrudRepository;

public interface ConnuRepository extends CrudRepository<Connu, ConnuComposite> {
    public Iterable<Connu> findAllByIdPersonnage(String idPersonnage);
    public Iterable<Connu> findAllByIdCible(String idCible);
}
