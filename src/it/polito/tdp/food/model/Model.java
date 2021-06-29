package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.Condiment;
import it.polito.tdp.food.db.FoodDao;

public class Model {

	private Graph<Condiment,DefaultWeightedEdge> grafo;
	private FoodDao dao;
	private Map<Integer,Condiment> idMap;
	private List<Condiment> listaOttima;
	private double costoOttimo;
	
	public Model() {
		dao = new FoodDao();
		idMap = new HashMap<>();
	}
	
	public void creaGrafo(double cal) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		dao.listIngredienti(cal, idMap);
		Graphs.addAllVertices(grafo, idMap.values());

		for(Adiacenti a : dao.getArchi(idMap, cal)) {
			Graphs.addEdge(grafo, a.getC1(), a.getC2(), a.getPeso());
		}
		System.out.println("GRAFO CREATO:\n#VERTICI: " + grafo.vertexSet().size() + "\n#ARCHI: " + grafo.edgeSet().size());
	}
	
	public List<Condiment> getVertici(){
		List<Condiment> result = new ArrayList<>(grafo.vertexSet());
		Collections.sort(result);
		return result;
	}
	
	public int getNCibi(Condiment cInput) {
		int result = 0;
		for(Condiment c : Graphs.neighborListOf(grafo, cInput)) {
			DefaultWeightedEdge e = grafo.getEdge(c, cInput);
			result += (int) grafo.getEdgeWeight(e);
		}
		
		return result;
	}
	
	public List<Condiment> calcolaDieta(Condiment partenza){
		this.listaOttima = new ArrayList<>();
		this.costoOttimo = 0;
		List<Condiment> parziale = new ArrayList<>();
		parziale.add(partenza);
		List<Condiment> ricerca = getVertici();
		ricerca.removeAll(Graphs.neighborListOf(grafo, partenza));
		ricerca.remove(partenza);
		cerca(parziale,ricerca,partenza.getCondiment_calories());
		return listaOttima;
	}

	private void cerca(List<Condiment> parziale, List<Condiment> ricerca, Double costoParziale) {
		// TODO Auto-generated method stub
		if(costoParziale > costoOttimo) {
			listaOttima = new ArrayList<>(parziale);
			costoOttimo = costoParziale;
		}
		
		for(Condiment c : ricerca) {
			if(!parziale.contains(c)) {
				parziale.add(c);
				List<Condiment> nuovaRicerca = new ArrayList<>(ricerca);
				nuovaRicerca.removeAll(Graphs.neighborListOf(grafo, c));
				nuovaRicerca.remove(c);
				cerca(parziale,nuovaRicerca, costoParziale + c.getCondiment_calories());
				parziale.remove(c);
			}
		}
	}
}
