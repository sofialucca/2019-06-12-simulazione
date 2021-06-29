package it.polito.tdp.food.model;

import it.polito.tdp.food.db.Condiment;

public class Adiacenti {

	private Condiment c1;
	private Condiment c2;
	private double peso;
	
	public Adiacenti(Condiment c1, Condiment c2, double peso) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.peso = peso;
	}

	public Condiment getC1() {
		return c1;
	}

	public void setC1(Condiment c1) {
		this.c1 = c1;
	}

	public Condiment getC2() {
		return c2;
	}

	public void setC2(Condiment c2) {
		this.c2 = c2;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
