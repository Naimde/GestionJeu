package com.GestionJeu.GestionJeu.controller;

import java.util.Optional;

import com.GestionJeu.GestionJeu.common.IDGen;
import com.GestionJeu.GestionJeu.domain.Personnage;
import com.GestionJeu.GestionJeu.dto.PersonnageRequest;
import com.GestionJeu.GestionJeu.repository.PersonnageRepository;

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
public class PersonnageController {
    
    @Autowired
    private PersonnageRepository personnagerepository;

    @GetMapping("/api/v1/personnages/jeu/{jeu}")
    @ResponseBody ResponseEntity<Iterable<Personnage>> list(@PathVariable String jeu){
        return ResponseEntity.ok().body(personnagerepository.findAllByJeu(jeu));
    }

    @PostMapping("/api/v1/personnages")
    @ResponseBody ResponseEntity<Personnage> create(@RequestBody PersonnageRequest requestDTO){
        Personnage personnage = new Personnage();
        String idtmp;
        do{
            idtmp = IDGen.personnage();
        }while(personnagerepository.existsById(idtmp));
        personnage.setId_personnage(idtmp);
        personnage.setId_reelle(requestDTO.id_reelle);
        personnage.setNom(requestDTO.nom);
        personnage.setPrenom(requestDTO.prenom);
        personnage.setSurnom(requestDTO.surnom);
        personnage.setImage(requestDTO.image);
        personnage.setGenre(requestDTO.genre);
        personnage.setNaissance(requestDTO.naissance);
        personnage.setLocalisation(requestDTO.localisation);
        personnage.setBackground(requestDTO.background);
        personnage.setInfo_public(requestDTO.info_public);
        personnage.setJeu(requestDTO.jeu);
        personnagerepository.save(personnage);
        return ResponseEntity.ok().body(personnage);
    }

    @GetMapping("/api/v1/personnages/{id}")
    @ResponseBody ResponseEntity<Personnage> get(@PathVariable String id){
        Optional<Personnage> result = personnagerepository.findById(id);
        if(result.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/api/v1/personnages/{id}")
    @ResponseBody ResponseEntity<Personnage> delete(@PathVariable String id){
        Optional<Personnage> result = personnagerepository.findById(id);
        if(result.isEmpty())
        return ResponseEntity.notFound().build();
        personnagerepository.deleteById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/personnages/{id}")
    @ResponseBody ResponseEntity<Personnage> modify(@PathVariable String id, @RequestBody PersonnageRequest requestDTO){
        Optional<Personnage> result = personnagerepository.findById(id);
        if(result.isEmpty())
        return ResponseEntity.notFound().build();
        Personnage personnage = result.get();
        if(requestDTO.id_reelle!=null)
            personnage.setId_reelle(requestDTO.id_reelle);
        if(requestDTO.nom!=null)
            personnage.setNom(requestDTO.nom);
        if(requestDTO.prenom!=null)
           personnage.setPrenom(requestDTO.prenom);
        if(requestDTO.surnom!=null)
           personnage.setSurnom(requestDTO.surnom);
        if(requestDTO.image!=null)
            personnage.setImage(requestDTO.image);
        if(requestDTO.genre!=null)
            personnage.setGenre(requestDTO.genre);
        if(requestDTO.naissance!=null)
            personnage.setNaissance(requestDTO.naissance);
        if(requestDTO.localisation!=null)
            personnage.setLocalisation(requestDTO.localisation);
        if(requestDTO.background!=null)
            personnage.setBackground(requestDTO.background);
        if(requestDTO.info_public!=null)
            personnage.setInfo_public(requestDTO.info_public);
        personnagerepository.save(personnage);
        return ResponseEntity.ok().body(personnage);
    }
}
