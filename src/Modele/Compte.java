package Modele;

public class Compte {
    private String numero;
    private double solde;
    private int id_proprietaire;

    public Compte(int id, String numero, double solde, String type, int id_proprietaire) {
        this.numero = numero;
        this.solde = solde;
        this.id_proprietaire = id_proprietaire;
    }

    public Compte(String c002, int i, int solde) {
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }

    public Object setSolde() {
        return null;
    }

    public Object setid_Proprietaire(int idProprietaire) {
        return null;
    }

    public void setNumero(String numero) {
        return;
    }
}
