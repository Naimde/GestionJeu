package com.GestionJeu.GestionJeu.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import com.GestionJeu.GestionJeu.common.IDGen;
import com.GestionJeu.GestionJeu.domain.Action;
import com.GestionJeu.GestionJeu.dto.ActionRequest;
import com.GestionJeu.GestionJeu.repository.ActionRepository;

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
public class ActionController {
    
    @Autowired
    private ActionRepository actionrepository;

    @GetMapping("/api/v1/actions")
    @ResponseBody ResponseEntity<Iterable<Action>> list(){
        return ResponseEntity.ok().body(actionrepository.findAll());
    }

    @PostMapping("/api/v1/actions")
    @ResponseBody ResponseEntity<Action> create(@RequestBody ActionRequest requestDTO){
        Action action = new Action();
        String idtmp;
        do{
            idtmp = IDGen.action();
        }while(actionrepository.existsById(idtmp));
        action.setId_action(idtmp);
        action.setId_personnage(requestDTO.id_personnage);
        action.setMoment(Timestamp.from(Instant.now()));
        action.setType_action(requestDTO.type_action);
        action.setCommentaire(requestDTO.commentaire);
        action.setId_cible(requestDTO.id_cible);
        actionrepository.save(action);
        return ResponseEntity.ok().body(action);
    }

    @GetMapping("/api/v1/actions/{id}")
    @ResponseBody ResponseEntity<Action> get(@PathVariable String id){
    Optional<Action> result = actionrepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/actions/{id}")

    @DeleteMapping("/api/v1/actions/{id}")
    @ResponseBody ResponseEntity<Action> delete(@PathVariable String id){
    Optional<Action> result = actionrepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    actionrepository.deleteById(id);
    return ResponseEntity.ok().body(result.get());
    }

}
