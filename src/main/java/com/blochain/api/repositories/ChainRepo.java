package com.blochain.api.repositories; 

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blochain.api.models.Chain; 

@Repository
public interface ChainRepo extends CrudRepository<Chain, Long> {
	
	 @Query(value = "SELECT * FROM cadena ORDER BY id DESC LIMIT 1", nativeQuery = true)
	 Chain getLast();
	 
	 public abstract ArrayList<Chain> findByHashcode(String hashcode);
}
