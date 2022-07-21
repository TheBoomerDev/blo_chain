package com.blochain.api.controllers.models;

import com.blochain.api.models.nft.Transferible;

public class DTOTransaccion {
	public long idOrigin;
	public long idDestino; 
	public long amount;
	
	public Transferible obj;
	 
	public long getIdOrigin() {
		return idOrigin;
	}
	public long getIdDestino() {
		return idDestino;
	}
	public long getAmount() {
		return amount;
	}  
}
