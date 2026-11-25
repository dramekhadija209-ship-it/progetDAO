import DAO.compteDAO;
import DAO.proprietaireDAO;
import Modele.Compte;
import Modele.proprietaire;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    compteDAO dao = new compteDAO();
    Compte c1 = new Compte("C001", 50000, 1);
    Compte c2 = new Compte("C002", 75000, 1);

    dao.ajouter(c1);
    dao.ajouter(c2);
    //afficher tous les comptes
    System.out.println("tous les comptes :");
    for (Compte c : dao.listertous()) {
        System.out.println(c.getNumero() + "" + c.getSolde());
    }
    //modifier le solde
    dao.modifierSolde("C001", 100000);
    //verifier la modification
    Compte resultat = dao.chercherparNumero("C001");
    if (resultat != null) {
        System.out.println("nouveau solde :" + resultat.setSolde());
    }
    //suprimer un comtpte
    dao.supprimer("C002");
    //bonus
    System.out.println("Comptes du proprietaire 1 :");
    for (Compte c : dao.listerparProprietaire(1)) {
        System.out.println(c.getNumero());
    }
}











//proprietaireDAO pDAO =new proprietaireDAO();
    //proprietaire p =pDAO.rechercherproprietaire(3);
    //p.setAdresse("keur massar");
    //pDAO.modifier(p);
//proprietaire p =new proprietaire("faye","absa","mbao");
//pDAO.Ajouter(P);
//if (p !=null){
    //System.out.println(p);

    //Arraylist<proprietaire>proprietaire=pDAO.getproprietaires();
   // for (proprietaire p : proprietaires){
       // System.out.println(p);
  //  }
//}

        //private proprietaire[] proprietaires;
