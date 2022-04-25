package com.GestionJeu.GestionJeu.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.GestionJeu.GestionJeu.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, String> {
    Optional<AppUser> findByUsername(String username);
}
