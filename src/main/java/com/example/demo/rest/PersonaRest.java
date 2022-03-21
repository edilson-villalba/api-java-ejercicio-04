package com.example.demo.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Persona;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/personas/")
public class PersonaRest {

	@Autowired
	private PersonaService personaService;

	@GetMapping
	private ResponseEntity<List<Persona>> getAllPersonas() {
		return ResponseEntity.ok(personaService.findAll());
	}

	@PostMapping
	private ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
		try {
			Persona per = personaService.save(persona);
			return ResponseEntity.created(new URI("/personas/" + per.getId())).body(per);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}