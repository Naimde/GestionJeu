package com.GestionJeu.GestionJeu.service;

import java.util.Optional;

import com.GestionJeu.GestionJeu.domain.AppUser;
import com.GestionJeu.GestionJeu.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<AppUser> result = appUserRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
        return result.get();
    }
    
}
