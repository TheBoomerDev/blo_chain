package com.blochain.api.services;

import java.util.ArrayList;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blochain.api.models.Chain;
import com.blochain.api.repositories.ChainRepo;
 
@Service
public class ChainService { 
	
	@Autowired
	ChainRepo repo;
	
	public Chain getByHascode(String hCode) throws Exception {
		
		ArrayList<Chain> cadenas = repo.findByHashcode(hCode);
		if (cadenas.size() <= 0) {
			throw new Exception("No hay Tokens");
		}
		return cadenas.get(0);
	}
	
	public Chain getLast() {
		return repo.getLast();
	}
    
	public Chain guardar(String contenido) {
		
		Chain lastChain = repo.getLast(); 
		Chain cadena = new Chain(lastChain, contenido);

		return repo.save(cadena);
	}

}
