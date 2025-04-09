package models;

public class Objet {

	private String type;
    private String marque;
    private String numeroSerie;
    private boolean statut;

    public Objet(String type, String marque, String numeroSerie, boolean statut) {
        this.type = type;
        this.marque = marque;
        this.numeroSerie = numeroSerie;
        this.statut = statut;
    }

    public String getType() { return type; }
    public String getMarque() { return marque; }
    public String getNumeroSerie() { return numeroSerie;}
    public boolean getStatut () { return statut;}

}
