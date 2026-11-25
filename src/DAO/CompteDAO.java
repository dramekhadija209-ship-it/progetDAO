package DAO;


import Config.Connexion;
import Modele.Compte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class compteDAO {
    public void ajouter(Compte c) {
        String sql = "INSERT INTO compte(numero,solde,id_proprietaire)VALUES (?,?,?)";
        try {
            Connexion con = Connexion.Ouvrir();
            PreparedStatement Ps = con.prepareStatement(sql);
            Ps.setString(1, c.getNumero());
            Ps.setDouble(2, c.getSolde());
            Ps.setInt(3, c.getId_proprietaire());

            Ps.executeUpdate();
            System.out.println("Compte ajouter avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Compte> listertous() {
        List<Compte> liste = new ArrayList<>();
        String sql = "SELECT * FROM Compte";
        try {
            Connexion con = Connexion.Ouvrir();
            PreparedStatement Ps = con.prepareStatement(sql);
            ResultSet rs = Ps.executeQuery();
            while (rs.next()) {
                Compte c = new Compte(
                        c   .setNumero(rs.getString("numero")),
                        c.setSolde(),
                        c.setid_Proprietaire(rs.getInt("id_proprietaire"))
                );

                liste.add(c);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;

    }

    public Compte chercherparNumero(String numero) {
        String sql = "SELECT * FROM compte WHERE numero = ?";
        try {
            Connexion con = Connexion.Ouvrir();
            PreparedStatement Ps = con.PrepareStatement(sql);
            Ps.setString(1, numero);
            ResultSet rs = Ps.executeQuery();
            if (rs.next()) {
                Compte c = new Compte(
                        c.setNumero(rs.getString("numero")),
                        c.setSolde(),
                        c.setid_Proprietaire(rs.getInt("id_proprietaire"))
                );

                return c;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void modifierSolde(String numero, double nouveauSolde) {
        String sql = "UPDATE comte SET solde = ? WHERE numero = ?";
        try {
            Connexion con = Connexion.Ouvrir();
            PreparedStatement Ps = con.PrepareStatement(sql);
            Ps.setDouble(1, nouveauSolde);
            Ps.setString(2, numero);
            Ps.executeUpdate();
            System.out.println("solde modifier avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimer(String numero) {
        String sql = "DELETE FROM compte WHERE numero =? ";
        try {
            Connexion con = Connexion.Ouvrir();
            PreparedStatement Ps = con.PrepareStatement(sql);
            Ps.setString(1, numero);
            Ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Compte> listerparProprietaire(int proprietaire) {
        List<Compte> liste = new ArrayList<>();
        String sql = "SELECT * FROM Comte WHERE id_proprietaire";
        try {
            Connexion con = Connexion.Ouvrir();
            PreparedStatement Ps = con.PrepareStatement(sql);
            Ps.setInt(1, proprietaire);
            ResultSet rs = Ps.executeQuery();
            while (rs.next()) {
                Compte c = new Compte(
                   c.setNumero( rs.getString("numero")),
                     c.setSolde(),
                    c.setid_Proprietaire( rs.getInt("id_proprietaire"))

                );
                liste.add(c);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return liste;
    }
}