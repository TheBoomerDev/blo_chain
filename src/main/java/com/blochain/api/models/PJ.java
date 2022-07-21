package com.blochain.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blochain.api.models.nft.*;

@Entity
@Table(name = "personaje")
public class PJ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	public Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="level")
	private int level = 1;
	
	@Column(name="brazo")
	private Brazo brazo;
	
	@Column(name="casco")
	private Casco casco;
	
	@Column(name="escudo")
	private Escudo escudo;
	
	@Column(name="pechera")
	private Pechera pechera;
	
	@Column(name="piernas")
	private Piernas piernas;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Brazo getBrazo() {
		return brazo;
	}

	public void setBrazo(Brazo brazo) {
		this.brazo = brazo;
	}

	public Casco getCasco() {
		return casco;
	}

	public void setCasco(Casco casco) {
		this.casco = casco;
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}

	public Pechera getPechera() {
		return pechera;
	}

	public void setPechera(Pechera pechera) {
		this.pechera = pechera;
	}

	public Piernas getPiernas() {
		return piernas;
	}

	public void setPiernas(Piernas piernas) {
		this.piernas = piernas;
	}
	
	

}
