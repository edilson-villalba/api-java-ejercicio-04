package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Estado;
import com.example.demo.service.EstadoService;

@RestController
@RequestMapping("/estados/")
public class EstadoRest {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("{id}")
    private ResponseEntity<List<Estado>> getAllEstadoByPais(@PathVariable("id") Long id){
    	return ResponseEntity.ok(estadoService.findAllByEstados(id));
    }
}
