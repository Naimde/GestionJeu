package com.GestionJeu.GestionJeu.controller;

import java.util.Optional;

import com.GestionJeu.GestionJeu.composite.JeuComposite;
import com.GestionJeu.GestionJeu.domain.Jeu;
import com.GestionJeu.GestionJeu.dto.JeuRequest;
import com.GestionJeu.GestionJeu.repository.JeuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class JeuController {
    
    @Autowired
    private JeuRepository jeurepository;

    @GetMapping("/api/v1/jeu")
    @ResponseBody ResponseEntity<Iterable<Jeu>> list(){
        return ResponseEntity.ok().body(jeurepository.findAll());
    }

    @GetMapping("/api/v1/jeu/{jeu}")
    @ResponseBody ResponseEntity<Iterable<Jeu>> list(@PathVariable String jeu){
        return ResponseEntity.ok().body(jeurepository.findAllByJeu(jeu));
    }

    @PostMapping("/api/v1/jeu")
    @ResponseBody ResponseEntity<Jeu> create(@RequestBody JeuRequest requestDTO){
        Jeu jeu = new Jeu();
        jeu.setJeu(requestDTO.jeu);
        jeu.setId_personnage(requestDTO.id_personnage);
        jeu.setUser(requestDTO.user);
        jeurepository.save(jeu);
        return ResponseEntity.ok().body(jeu);
    }

    @GetMapping("/api/v1/jeu/{id}/{user}")
    @ResponseBody ResponseEntity<Jeu> get(@PathVariable String id, @PathVariable String user){
    Optional<Jeu> result = jeurepository.findById(new JeuComposite(id,user));
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/api/v1/jeu/{id}/{user}")
    @ResponseBody ResponseEntity<Jeu> delete(@PathVariable String id, @PathVariable String user){
        JeuComposite cle = new JeuComposite(id,user);
        Optional<Jeu> result = jeurepository.findById(cle);
        if(result.isEmpty())
            return ResponseEntity.notFound().build();
        jeurepository.deleteById(new JeuComposite(id,user));
        return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/jeu/{id}/{user}")
    @ResponseBody ResponseEntity<Jeu> modify(@PathVariable String id, @PathVariable String user, @RequestBody JeuRequest requestDTO){
        JeuComposite cle = new JeuComposite(id,user);
        Optional<Jeu> result = jeurepository.findById(cle);
        if(result.isEmpty())
            return ResponseEntity.notFound().build();
        Jeu jeu = result.get();
        if(requestDTO.id_personnage!=null)
            jeu.setId_personnage(requestDTO.id_personnage);
        jeurepository.save(jeu);
        return ResponseEntity.ok().body(jeu);
    }
}
