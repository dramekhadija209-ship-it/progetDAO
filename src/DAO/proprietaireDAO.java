package DAO;

import Config.Connexion;
import Modele.proprietaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class proprietaireDAO {
    public ArrayList<proprietaire> getproprietaires() {
        ArrayList<proprietaire> proprietaires = new ArrayList<>();
        String sql = "select id,nom,prenom,adresse from proprietaires";


        try (Connection cn = (Connection) Connexion.Ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                proprietaire p = new proprietaire(id, nom, prenom, adresse);
                proprietaire.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur:" +ex.getMessage());
        }

        return proprietaires;

    }

    public proprietaire rechercherproprietaires(int id) throws SQLException {
        String sql = "select ,nom,prenom,adresse from proprietaires where id = ?";


        int idp;
        try (Connection cn = Connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idp = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                proprietaire P = new proprietaire(id, nom, prenom, adresse);

                return P;
            }


        } catch (SQLException NullPointerException ){
            System.out.println("Erreur:" + id);
        }

        return null;


    }
public void Ajouter(proprietaire p){
    String sql ="INSERT INTO proprietaire(nom,prenom,Adresse)VALUES(?,?,?)";
    try(Connection cn = Connexion.ouvrir();
    PreparedStatement ps = cn.prepareStatement(sql);) {
        ps.setString(1,p.getNom());
        ps.setString(2,p.getPrenom());
        ps.setString(3,p.getAdresse());
        ps.executeUpdate();


    }catch (SQLException ex){
        System.out.println();
    }
}
public void modifier(proprietaire p) {
    String sql = "UPDATE proprietaire SET nom=?,prenom=?,Adresse=? WHERE id=?";
    try (Connection cn = Connexion.ouvrir();
         PreparedStatement ps = cn.prepareStatement(sql);) {
        ps.setInt(1, p.getId());
        ps.executeUpdate();


    } catch (SQLException ex) {
        System.out.println("Ereur:"+ex.getMessage());
    }
}
public void supprimer(proprietaire p) {
    String sql = "DELETE FROM proprietaire WHERE id=?";
    try (Connection cn = Connexion.ouvrir();
         PreparedStatement ps = cn.prepareStatement(sql);) {
        ps.setString(1, p.getNom());
        ps.setString(2, p.getPrenom());
        ps.setString(3, p.getAdresse());
        ps.setInt(4, p.getId());
        ps.executeUpdate();


    } catch (SQLException ex) {
        System.out.println("Ereur:"+ex.getMessage());
    }
}

    public proprietaire rechercherproprietaire(int i) {
        return null;
    }
}

