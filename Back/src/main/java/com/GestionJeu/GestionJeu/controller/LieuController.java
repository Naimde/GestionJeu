package com.GestionJeu.GestionJeu.controller;

import java.util.Optional;

import com.GestionJeu.GestionJeu.common.IDGen;
import com.GestionJeu.GestionJeu.domain.Lieu;
import com.GestionJeu.GestionJeu.dto.LieuRequest;
import com.GestionJeu.GestionJeu.repository.LieuRepository;

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
public class LieuController {
    
    @Autowired
    private LieuRepository lieurepository;

    @GetMapping("/api/v1/lieus")
    @ResponseBody ResponseEntity<Iterable<Lieu>> list(){
        return ResponseEntity.ok().body(lieurepository.findAll());
    }

    @PostMapping("/api/v1/lieus")
    @ResponseBody ResponseEntity<Lieu> create(@RequestBody LieuRequest requestDTO){
        Lieu lieu = new Lieu();
        String idtmp;
        do{
            idtmp = IDGen.lieu();
        }while(lieurepository.existsById(idtmp));
        lieu.setId_lieu(idtmp);
        lieu.setGenre(requestDTO.genre);
        lieu.setNom(requestDTO.nom);
        lieu.setDescription(requestDTO.description);
        lieu.setJeu(requestDTO.jeu);
        lieurepository.save(lieu);
        return ResponseEntity.ok().body(lieu);
    }

    @GetMapping("/api/v1/lieus/{id}")
    @ResponseBody ResponseEntity<Lieu> get(@PathVariable String id){
        Optional<Lieu> result = lieurepository.findById(id);
        if(result.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/api/v1/lieus/{id}")
    @ResponseBody ResponseEntity<Lieu> delete(@PathVariable String id){
        Optional<Lieu> result = lieurepository.findById(id);
        if(result.isEmpty())
            return ResponseEntity.notFound().build();
        lieurepository.deleteById(id);
        return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/lieus/{id}")
    @ResponseBody ResponseEntity<Lieu> modify(@PathVariable String id, @RequestBody LieuRequest requestDTO){
        Optional<Lieu> result = lieurepository.findById(id);
        if(result.isEmpty())
        return ResponseEntity.notFound().build();
        Lieu lieu = result.get();
        if(requestDTO.nom!=null)
            lieu.setNom(requestDTO.nom);
        if(requestDTO.description!=null)
            lieu.setDescription(requestDTO.description);
        lieurepository.save(lieu);
        return ResponseEntity.ok().body(lieu);
    }
}
