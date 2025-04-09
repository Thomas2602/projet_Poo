package models;

import java.util.Date;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone;
	private Date date_inscription;

	public Client(int id, String nom, String prenom, String adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.date_inscription = date_inscription;
	}
	public int getId () { return id;}
	public String getNom () { return nom;}
	public String getPrenom () { return prenom;}
	public String getAdresse () { return adresse;}
	public String getEmail () { return email;}
	public String getTelephone () { return telephone;}
	public Date getDateInscription () { return date_inscription;}
}
