package com.GestionJeu.GestionJeu.controller;

import java.util.Optional;

import com.GestionJeu.GestionJeu.domain.AppUser;
import com.GestionJeu.GestionJeu.domain.Role;
import com.GestionJeu.GestionJeu.dto.AppUserRequest;
import com.GestionJeu.GestionJeu.dto.AppUserRoleRequest;
import com.GestionJeu.GestionJeu.repository.AppUserRepository;
import com.GestionJeu.GestionJeu.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

    @Autowired 
    private RoleRepository roleRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/api/v1/users")
    public @ResponseBody ResponseEntity<Iterable<AppUser>> find() {
        Iterable<AppUser> users = appUserRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/api/v1/users/{id}")
    public @ResponseBody ResponseEntity<AppUser> getid(@PathVariable String id) {
        Optional<AppUser> result = appUserRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.notFound().build();
        AppUser appuser = result.get();
        return ResponseEntity.ok().body(appuser);
    }

    @PostMapping("/api/v1/users")
    public @ResponseBody ResponseEntity<AppUser> createproject(@RequestBody AppUserRequest requestDto) {
        Optional<AppUser> result = appUserRepository.findById(requestDto.username);
        if (result.isEmpty()){
            AppUser appUser = new AppUser();
            appUser.setUsername(requestDto.username);
            appUser.setPassword(passwordEncoder.encode(requestDto.password));
            appUser.setMail(requestDto.mail);
            appUserRepository.save(appUser);
            return ResponseEntity.ok().body((appUser));
        }
        return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/api/v1/users/{id}")
    public @ResponseBody ResponseEntity<AppUser> modifyProject(@PathVariable String id,
            @RequestBody AppUserRequest requestDto) {
        Optional<AppUser> result = appUserRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        AppUser appUser = result.get();
        appUser.setUsername(requestDto.username);
        appUser.setPassword(requestDto.password);
        appUser.setMail(requestDto.mail);
        appUserRepository.save(appUser);
        return ResponseEntity.ok().body((appUser));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/api/v1/users/{id}")
    public @ResponseBody ResponseEntity<AppUser> delete(@PathVariable String id) {
        Optional<AppUser> result = appUserRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.notFound().build();
            appUserRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/api/v1/users/{id}/roles")
    public @ResponseBody ResponseEntity<AppUser> addRole(@PathVariable String id,
            @RequestBody AppUserRoleRequest userRoleDto) {
        Optional<AppUser> resultUser = appUserRepository.findById(id); 
        if (resultUser.isEmpty()) { 
            return ResponseEntity.notFound().build();
        }
        AppUser user = resultUser.get(); 
        Optional<Role> result = roleRepository.findById(userRoleDto.roleId);                                                         
                                                                                         
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        user.getRoles().add(result.get());
        System.out.println(user.getRoles());
        appUserRepository.save(user); 
        return ResponseEntity.ok().body((user)); 
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/api/v1/users/{id}/roles/{roleId}")
    public @ResponseBody ResponseEntity<AppUser> deleteRole(@PathVariable String id, @PathVariable int roleId) {
        Optional<AppUser> result = appUserRepository.findById(id); 
        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        AppUser user = result.get(); 
        Optional<Role> resultRole = roleRepository.findById(roleId); 
                                      
        user.getRoles().remove(resultRole.get()); 
        appUserRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
