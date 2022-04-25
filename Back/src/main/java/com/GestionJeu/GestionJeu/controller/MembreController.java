package com.GestionJeu.GestionJeu.controller;

import java.util.Optional;

import com.GestionJeu.GestionJeu.composite.MembreComposite;
import com.GestionJeu.GestionJeu.domain.Membre;
import com.GestionJeu.GestionJeu.dto.MembreRequest;
import com.GestionJeu.GestionJeu.repository.MembreRepository;

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
public class MembreController {
    
    @Autowired
    private MembreRepository membrerepository;

    @GetMapping("/api/v1/membres")
    @ResponseBody ResponseEntity<Iterable<Membre>> list(){
        return ResponseEntity.ok().body(membrerepository.findAll());
    }

    @GetMapping("/api/v1/membres/groupe/{id}")
    @ResponseBody ResponseEntity<Iterable<Membre>> listByGroup(@PathVariable String id){
        return ResponseEntity.ok().body(membrerepository.findAllByIdGroupe(id));
    }

    @PostMapping("/api/v1/membres")
    @ResponseBody ResponseEntity<Membre> create(@RequestBody MembreRequest requestDTO){
        Membre membre = new Membre();
        membre.setIdGroupe(requestDTO.idGroupe);
        membre.setIdPersonnage(requestDTO.idPersonnage);
        membre.setDescription(requestDTO.description);
        membrerepository.save(membre);
        return ResponseEntity.ok().body(membre);
    }

    @GetMapping("/api/v1/membres/{id}/{groupe}")
    @ResponseBody ResponseEntity<Membre> get(@PathVariable String id,@PathVariable String groupe){
        MembreComposite cle = new MembreComposite(id, groupe);
        Optional<Membre> result = membrerepository.findById(cle);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/api/v1/membres/{id}/{groupe}")
    @ResponseBody ResponseEntity<Membre> delete(@PathVariable String id,@PathVariable String groupe){
        MembreComposite cle = new MembreComposite(id, groupe);
        Optional<Membre> result = membrerepository.findById(cle);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    membrerepository.deleteById(cle);
    return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/membres/{id}/{groupe}")
    @ResponseBody ResponseEntity<Membre> modify(@PathVariable String id,@PathVariable String groupe, @RequestBody MembreRequest requestDTO){
        MembreComposite cle = new MembreComposite(id, groupe);
        Optional<Membre> result = membrerepository.findById(cle);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    Membre membre = result.get();
    if(requestDTO.description!=null)
        membre.setDescription(requestDTO.description);
    membrerepository.save(membre);
    return ResponseEntity.ok().body(membre);
    }
}
