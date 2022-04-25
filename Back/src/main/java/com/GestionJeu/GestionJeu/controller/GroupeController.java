package com.GestionJeu.GestionJeu.controller;

import java.util.Optional;

import com.GestionJeu.GestionJeu.common.IDGen;
import com.GestionJeu.GestionJeu.domain.Groupe;
import com.GestionJeu.GestionJeu.dto.GroupeRequest;
import com.GestionJeu.GestionJeu.repository.GroupeRepository;

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
public class GroupeController {
    
    @Autowired
    private GroupeRepository grouperepository;

    @GetMapping("/api/v1/groupes/jeu/{jeu}")
    @ResponseBody ResponseEntity<Iterable<Groupe>> list(@PathVariable String jeu){
        return ResponseEntity.ok().body(grouperepository.findAllByJeu(jeu));
    }

    @PostMapping("/api/v1/groupes")
    @ResponseBody ResponseEntity<Groupe> create(@RequestBody GroupeRequest requestDTO){
        Groupe groupe = new Groupe();
        String idtmp;
        do{
            idtmp = IDGen.groupe(requestDTO.genre);
        }while(grouperepository.existsById(idtmp));
        groupe.setId_groupe(idtmp);
        groupe.setGenre(requestDTO.genre);
        groupe.setNom(requestDTO.nom);
        groupe.setDescription(requestDTO.description);
        groupe.setVisionautre(true);
        groupe.setLeader(requestDTO.leader);
        groupe.setJeu(requestDTO.jeu);
        grouperepository.save(groupe);
        return ResponseEntity.ok().body(groupe);
    }

    @GetMapping("/api/v1/groupes/{id}")
    @ResponseBody ResponseEntity<Groupe> get(@PathVariable String id){
    Optional<Groupe> result = grouperepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/api/v1/groupes/{id}")
    @ResponseBody ResponseEntity<Groupe> delete(@PathVariable String id){
    Optional<Groupe> result = grouperepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    grouperepository.deleteById(id);
    return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/groupes/{id}")
    @ResponseBody ResponseEntity<Groupe> modify(@PathVariable String id, @RequestBody GroupeRequest requestDTO){
    Optional<Groupe> result = grouperepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    Groupe groupe = result.get();
    if(requestDTO.nom!=null)
        groupe.setNom(requestDTO.nom);
    if(requestDTO.description!=null)
        groupe.setDescription(requestDTO.description);
    if(requestDTO.visionautre!=null)
        groupe.setVisionautre(requestDTO.visionautre);
    if(requestDTO.leader!=null)
        groupe.setLeader(requestDTO.leader);
    grouperepository.save(groupe);
    return ResponseEntity.ok().body(groupe);
    }
}
