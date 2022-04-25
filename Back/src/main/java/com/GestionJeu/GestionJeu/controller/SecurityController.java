package com.GestionJeu.GestionJeu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.GestionJeu.GestionJeu.domain.AppUser;
import com.GestionJeu.GestionJeu.dto.TokenRequest;
import com.GestionJeu.GestionJeu.dto.TokenResponse;
import com.GestionJeu.GestionJeu.repository.AppUserRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class SecurityController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private AppUserRepository appUserRepository;

	@PostMapping("/authorize")
	public @ResponseBody ResponseEntity<?> authorize(@RequestBody TokenRequest requestDto) {
        // Authenticating user from username and password
		Authentication authentication = new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword());
		try {
			authentication = authenticationManager.authenticate(authentication);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
        // Generating a token (Json Web Token)
		AppUser user = (AppUser) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600 * 1000 * 10); //dernier paramètre, le nombre d'heure de validité
        String token =  Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, "GestionJeu")
            .compact();

        // Outputing results into a response dto
		TokenResponse responseDto = new TokenResponse();
		responseDto.setAccessToken(token);
		List<String> authoritiesDto = new ArrayList<String>();
		user.getAuthorities().forEach(x -> {
			authoritiesDto.add(x.getAuthority());
		});
		responseDto.setAuthorities(authoritiesDto);
        responseDto.setIssuedAt(now);
        responseDto.setExpiresAt(expiryDate);
		
		return ResponseEntity.ok(responseDto);
	}

    @GetMapping("/me")
    public @ResponseBody ResponseEntity<AppUser> me() {
        try {
            AppUser user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return ResponseEntity.ok().body(user);
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

	@PostMapping("/register")
	public @ResponseBody ResponseEntity<AppUser> register(@RequestBody TokenRequest requestDto) {
		AppUser appUser = new AppUser();
		appUser.setUsername(requestDto.getUsername());
		appUser.setPassword(passwordEncoder.encode(requestDto.getPassword()));
		appUserRepository.save(appUser);
		return ResponseEntity.ok(appUser);
	}
}
