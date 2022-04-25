package com.GestionJeu.GestionJeu.repository;

import com.GestionJeu.GestionJeu.domain.Secret;

import org.springframework.data.repository.CrudRepository;

public interface SecretRepository extends CrudRepository<Secret, String> {
    
}
