package it.polito.tdp.food.model;

import java.util.List;

import it.polito.tdp.food.db.Condiment;

public class TestModel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m = new Model();
		m.creaGrafo(50);
		List<Condiment> listaVertici = m.getVertici();
		System.out.println(listaVertici);
		System.out.println(m.getNCibi(listaVertici.get(0)));
		System.out.println("DIETA EQUILIBRATA  " + listaVertici.get(0));
		System.out.println(m.calcolaDieta(listaVertici.get(33)));
	}
}
