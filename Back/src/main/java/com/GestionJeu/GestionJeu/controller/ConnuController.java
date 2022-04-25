package com.GestionJeu.GestionJeu.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import com.GestionJeu.GestionJeu.composite.ConnuComposite;
import com.GestionJeu.GestionJeu.domain.Connu;
import com.GestionJeu.GestionJeu.dto.ConnuRequest;
import com.GestionJeu.GestionJeu.repository.ConnuRepository;

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
public class ConnuController {
    
    @Autowired
    private ConnuRepository connuRepository;

    @GetMapping("/api/v1/connus")
    @ResponseBody ResponseEntity<Iterable<Connu>> list(){
        return ResponseEntity.ok().body(connuRepository.findAll());
    }

    @PostMapping("/api/v1/connus")
    @ResponseBody ResponseEntity<Connu> create(@RequestBody ConnuRequest requestDTO){
        Connu connu = new Connu();
        connu.setidPersonnage(requestDTO.idPersonnage);
        connu.setidCible(requestDTO.idCible);
        connu.setDescription(requestDTO.description);
        connu.setNote(requestDTO.note);
        connu.setDate_ajout(Timestamp.from(Instant.now()));
        connuRepository.save(connu);
        return ResponseEntity.ok().body(connu);
    }

    @GetMapping("/api/v1/connus/{id}/{element}")
    @ResponseBody ResponseEntity<Connu> get(@PathVariable String id,@PathVariable String element){
    ConnuComposite cle = new ConnuComposite(id, element);
    Optional<Connu> result = connuRepository.findById(cle);
    if(result.isEmpty())
    return ResponseEntity.notFound().build();
    return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/api/v1/connus/{id}/{element}")
    @ResponseBody ResponseEntity<Connu> delete(@PathVariable String id,@PathVariable String element){
        ConnuComposite cle = new ConnuComposite(id, element);
        Optional<Connu> result = connuRepository.findById(cle);
        if(result.isEmpty())
            return ResponseEntity.notFound().build();
        connuRepository.deleteById(cle);
        return ResponseEntity.ok().body(result.get());
    }

    @PutMapping("/api/v1/connus/{id}/{element}")
    @ResponseBody ResponseEntity<Connu> modify(@PathVariable String id,@PathVariable String element, @RequestBody ConnuRequest requestDTO){
        ConnuComposite cle = new ConnuComposite(id, element);
        Optional<Connu> result = connuRepository.findById(cle);
        if(result.isEmpty())
            return ResponseEntity.notFound().build();
        Connu connu = result.get();
        if(requestDTO.note!=null)
            connu.setNote(requestDTO.note);

        connuRepository.save(connu);
        return ResponseEntity.ok().body(connu);
    }
}
