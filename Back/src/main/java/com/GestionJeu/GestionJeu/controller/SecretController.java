package com.GestionJeu.GestionJeu.controller;

import java.util.Optional;

import com.GestionJeu.GestionJeu.common.IDGen;
import com.GestionJeu.GestionJeu.domain.Secret;
import com.GestionJeu.GestionJeu.dto.SecretRequest;
import com.GestionJeu.GestionJeu.repository.SecretRepository;

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
public class SecretController {
    
    @Autowired
    private SecretRepository secretrepository;

    @GetMapping("/api/v1/secrets")
    @ResponseBody ResponseEntity<Iterable<Secret>> list(){
        return ResponseEntity.ok().body(secretrepository.findAll());
    }

    @PostMapping("/api/v1/secrets")
    @ResponseBody ResponseEntity<Secret> create(@RequestBody SecretRequest requestDTO){
        Secret secret = new Secret();
        String idtmp;
        do{
            idtmp = IDGen.secret();
        }while(secretrepository.existsById(idtmp));
        secret.setId_secret(idtmp);
        secret.setId_cible(requestDTO.id_cible);
        secret.setDescription(requestDTO.description);
        secretrepository.save(secret);
        return ResponseEntity.ok().body(secret);
    }

    @GetMapping("/api/v1/secrets/{id}")
    @ResponseBody ResponseEntity<Secret> get(@PathVariable String id){
    Optional<Secret> result = secretrepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/api/v1/secrets/{id}")
    @ResponseBody ResponseEntity<Secret> delete(@PathVariable String id){
    Optional<Secret> result = secretrepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    secretrepository.deleteById(id);
    return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/secrets/{id}")
    @ResponseBody ResponseEntity<Secret> modify(@PathVariable String id, @RequestBody SecretRequest requestDTO){
    Optional<Secret> result = secretrepository.findById(id);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    Secret secret = result.get();
    if(requestDTO.id_cible!=null)
        secret.setId_cible(requestDTO.id_cible);
    if(requestDTO.description!=null)
        secret.setDescription(requestDTO.description);
    secretrepository.save(secret);
    return ResponseEntity.ok().body(secret);
    }
}
