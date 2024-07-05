package com.examen_ci.gestion_produit;

public class Produit {
	
	Long id;
	String nom;
	double prix;
	int quantité;
	
	
	public Produit(Long id, String nom, double prix, int quantité) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantité = quantité;
	}
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	

	public int getQuantité() {
		return quantité;
	}
	
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	
}
