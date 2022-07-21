package com.blochain.api.models;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;

import org.springframework.util.DigestUtils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets; 
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "cadena")
public class Chain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	public Long id;
	 
	@Column(name="hashcode")
	public String hashcode;
	
	@Column(name="value")
	public String content;  
	 
	
	public Chain setValues(Chain previa, String values) throws NoSuchAlgorithmException {		
	
		Chain instancia = new Chain();
		
		if (previa != null) {
			instancia.hashcode = ""+previa.getHashcode();
		}else {
			instancia.hashcode = "INIT";
		}
		instancia.content  = values;
		
		return instancia;
	} 
	
	public String getHashcode() throws NoSuchAlgorithmException {
		String str = ""+this.toString();
		
		String sha256hex = Hashing.sha256()
				  .hashString(str, StandardCharsets.UTF_8)
				  .toString();
		
		return sha256hex; 
	}
	
	@Override
	public String toString() {
		String formato = "ID:%d - H: %s - V: %s";
		return String.format(formato, this.id, this.hashcode, this.content);
	}
}
