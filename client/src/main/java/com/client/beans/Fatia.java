package com.client.beans;

import java.io.Serializable;

public class Fatia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double y;
	private String label;
	
	public Fatia(Double y, String label) {
		super();
		this.y = y;
		this.label = label;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	

}
