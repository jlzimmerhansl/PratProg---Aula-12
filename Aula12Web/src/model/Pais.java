package model;

import java.io.Serializable;

public class Pais implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private long populacao;
	private double area;
	private String continente;
	
	
	public Pais(){
		 
	}
	
	public Pais(int id, String nome, long populacao, double area, String continente) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
		this.continente = continente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}
	
	@Override
	public String toString() {
		
		return "Nome: " + this.getNome() + "Populacao: " + this.getPopulacao() + "Area: " + this.getArea() + "Continente: " + this.getContinente(); 
	}


}
