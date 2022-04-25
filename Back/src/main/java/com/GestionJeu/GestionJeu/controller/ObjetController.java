package com.GestionJeu.GestionJeu.controller;

import java.util.Optional;

import com.GestionJeu.GestionJeu.common.IDGen;
import com.GestionJeu.GestionJeu.domain.Objet;
import com.GestionJeu.GestionJeu.dto.ObjetRequest;
import com.GestionJeu.GestionJeu.repository.ObjetRepository;

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
public class ObjetController {
    
    @Autowired
    private ObjetRepository objetrepository;

    @GetMapping("/api/v1/objets")
    @ResponseBody ResponseEntity<Iterable<Objet>> list(){
        return ResponseEntity.ok().body(objetrepository.findAll());
    }

    @PostMapping("/api/v1/objets")
    @ResponseBody ResponseEntity<Objet> create(@RequestBody ObjetRequest requestDTO){
        Objet objet = new Objet();
        String idtmp;
        do{
            idtmp = IDGen.objet();
        }while(objetrepository.existsById(idtmp));
        objet.setID_Objet(idtmp);
        objet.setNom(requestDTO.nom);
        objet.setDescription(requestDTO.description);
        objet.setPossesseur(requestDTO.possesseur);
        objet.setJeu(requestDTO.jeu);
        objetrepository.save(objet);
        return ResponseEntity.ok().body(objet);
    }

    @GetMapping("/api/v1/objets/{id}")
    @ResponseBody ResponseEntity<Objet> get(@PathVariable String id){
    Optional<Objet> result = objetrepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/api/v1/objets/{id}")
    @ResponseBody ResponseEntity<Objet> delete(@PathVariable String id){
    Optional<Objet> result = objetrepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    objetrepository.deleteById(id);
    return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/objets/{id}")
    @ResponseBody ResponseEntity<Objet> modify(@PathVariable String id, @RequestBody ObjetRequest requestDTO){
    Optional<Objet> result = objetrepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    Objet objet = result.get();
    if(requestDTO.nom!=null)
        objet.setNom(requestDTO.nom);
    if(requestDTO.description!=null)
        objet.setDescription(requestDTO.description);
    if(requestDTO.possesseur!=null)
        objet.setPossesseur(requestDTO.possesseur);
    objetrepository.save(objet);
    return ResponseEntity.ok().body(objet);
    }
}
