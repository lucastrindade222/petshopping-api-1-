package com.petshopping.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date dt_cadast;
	
	
	public Cliente() {
		
	}

	

	public Cliente(Date dt_cadast) {
		super();
		this.dt_cadast = dt_cadast;
	}



	public Date getDt_cadast() {
		return dt_cadast;
	}


	public void setDt_cadast(Date dt_cadast) {
		this.dt_cadast = dt_cadast;
	}
	
	
	
}
