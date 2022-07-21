package com.blochain.api.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blochain.api.controllers.models.DTOComprobacion;
import com.blochain.api.controllers.models.DTOTransaccion;
import com.blochain.api.models.Chain;
import com.blochain.api.services.ChainService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/chains")
public class ChainController {

	@Autowired
	ChainService servicio;
	
	Gson gson = new Gson();
	
	@PostMapping()
	public Chain save(@RequestBody DTOTransaccion obj) throws NoSuchAlgorithmException {
		System.out.println(obj);
		 
		String value = gson.toJson(obj);
		return servicio.guardar(value);
	}
	
	@GetMapping( path = "/last")
	public Object getLastBloque() {
		return servicio.getLast();
	}
	
	@GetMapping( path = "/{code}")
	public Object getByHashcode(@PathVariable("code") String hCode) {
		try {
			
			Chain chain = servicio.getByHascode(hCode); 
			return gson.toJson(chain);
		} catch (Exception e) { 
			e.printStackTrace();
			return "NO HAY TOKEN";
		}
	}

	@GetMapping( path = "/{id}/{code}")
	public Object funcionComprobacion(@PathVariable("code") String hCode, @PathVariable("id") Long id) throws NoSuchAlgorithmException {
		Chain chain = servicio.getById(id);
			
		boolean isOk = (chain.getHashcode().equals(hCode));
		
		DTOComprobacion check = new DTOComprobacion();
		check.hashCode = hCode;
		check.idBChain = id;
		check.isCorrupt = !isOk;
		
		return check;
	}
	
	
	
	
	/*
	 * x - Guardar Cadena
	 * x - Comprobar si existe el hashcode
	 * - Comprobar si Fue modificado <- No se si nos dará tiempo
	 * x - Devolver el Ultimo Chain <- para comprobaciones
	 */
	
}
