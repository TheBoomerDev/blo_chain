package com.blochain.api.models.nft;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 
public abstract class Transferible { 
	
	
	public Long idOwner;
	public Long price;
	public String name; 
}
