package com.blochain.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blochain.api.models.Chain;
import com.blochain.api.services.ChainService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/chains")
public class ChainController {

	@Autowired
	ChainService servicio;
	
	@PostMapping()
	public Chain save(@RequestBody Object obj) {
		Gson gson = new Gson();
		
		String value = gson.toJson(obj);
		return servicio.guardar(value);
	}
	
	@GetMapping( path = "/{code}")
	public Object getByHashcode(@PathVariable("code") String hCode) {
		try {
			return servicio.getByHascode(hCode);
		} catch (Exception e) { 
			e.printStackTrace();
			return "NO HAY TOKEN";
		}
	}
	
	
	
	/*
	 * x- Guardar Cadena
	 * x- Comprobar si existe el hashcode
	 * - Comprobar si Fue modificado <- No se si nos dará tiempo
	 * - Devolver el Ultimo Chain <- para comprobaciones
	 */
	
}
