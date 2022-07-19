package com.blochain.api.models;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name = "cadena")
public class Chain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	 
	@Column(name="hashcode")
	private String hashcode;
	
	@Column(name="value")
	private String content;  
	
	public Chain(Object previa, String values) {		
		this.hashcode = ""+previa.hashCode();
		this.content  = values;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getHashcode() {
		return this.hashcode;
	}  

	public String getContent() {
		return this.content;
	}
}
