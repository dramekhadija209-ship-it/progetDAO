package Modele;

public class proprietaire {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;

    public proprietaire(int id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    public proprietaire( String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public static void add(proprietaire p) {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse){
        this.adresse=adresse;
    }
    public String toString(){
        return prenom +" "+nom+" "+adresse;
    }
}
