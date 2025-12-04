package tp3;

import java.time.LocalDate;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	//Test Livre
	System.out.println("On cree 3 livres et on les affiche");
	Livre livre1 = new Livre("Harry Potter a l'ecole des sorciers");
	Livre livre2 = new Livre("Harry Potter et la Chambre des Secrets", 102);
	Livre livre3 = new Livre("Harry Potter et la Prison l'Azkaban", 99, 2, "1111111111148", 350);
	System.out.println(livre1);
	System.out.println(livre2);
	System.out.println(livre3);
	
	//Test Manuel
	System.out.println("On cree 3 manuels et on les affiche");
	Manuel manuel1 = new Manuel("Apprendre Java");
	Manuel manuel2 = new Manuel("Apprendre Python", "8455968767453", 545, Manuel.Matiere.EN, Manuel.Niveau._3e);
	Manuel manuel3 = new Manuel("Apprendre SQL");
	System.out.println(manuel1);
	System.out.println(manuel2);
	System.out.println(manuel3);
	
	//Test Magazine
	System.out.println("On cree 3 magazines et on les affiche");
	Magazine magazine1 = new Magazine("Louis Vuitton - La mode made in France", 99.9, 2, "15264512", Magazine.Periodicite.T, LocalDate.of(2025, 05, 13));
	Magazine magazine2 = new Magazine("Shein, le nouvel eldorado");
	Magazine magazine3 = new Magazine("Uniqlo, le style japonais");
	System.out.println(magazine1);
	System.out.println(magazine2);
	System.out.println(magazine3);
	
	//Test LigneDepot
	System.out.println("On cree 3 lignes et on les affiche");
	LigneDepot ligneDepot1 = new LigneDepot(magazine1.getNumero(), 2);
	LigneDepot ligneDepot2 = new LigneDepot(livre1.getNumero(), 3);
	LigneDepot ligneDepot3 = new LigneDepot(manuel1.getNumero(), 5);
	System.out.println(ligneDepot1);
	System.out.println(ligneDepot2);
	System.out.println(ligneDepot3 + "\n");
	
	//Test BonDepot
	System.out.println("On cree 2 bons de depot et on les affiche");
	BonDepot bonDepot1 = new BonDepot("+33 6 01 01 01 01");
	BonDepot bonDepot2 = new BonDepot("+33 7 77 77 77 77");
	System.out.println(bonDepot1);
	System.out.println(bonDepot2);
        
	//Test BonDepot -> Ligne
	System.out.println("On ajoute les lignes dans Bon de Depot 1");
        bonDepot1.ajouterLigne(ligneDepot2.getNumeroArticle(), ligneDepot2.getNbExemplairesDepot());
        bonDepot1.ajouterLigne(ligneDepot3.getNumeroArticle(), ligneDepot3.getNbExemplairesDepot());
        System.out.println("On met la limite de lignes a 2 (defaut a 9) et on essaye d'ajoute un article");
	bonDepot1.setLimite(2);
	bonDepot1.ajouterLigne(magazine1);
	//Si la limite d'articles du bon est atteinte, ici 2
	if(!bonDepot1.ajouterLigne(magazine1)){
	    System.out.println("Impossible d'ajouter la ligne");
	}
	System.out.println(bonDepot1);
	
	
	
	//Test Etablissement
	System.out.println("On cree des etablissements et on les affiche");
	Etablissement etablissement1 = new Etablissement("BHV", 4, 10);
	Etablissement etablissement2 = new Etablissement("Grande Epicerie de Paris", 4, 5);
	System.out.println(etablissement1);
	System.out.println(etablissement2);
	
	//Test Etablissement -> BonDepot
        System.out.println("On cree BonDepot et on les affiche");
	etablissement1.ajouter("+33 1 11 11 11 11");
	System.out.println(etablissement1);
	
	//Test getNumero()
	System.out.println("Numero (Livre ou Manuel): " + livre1.getNumero());
	System.out.println("Numero (Magazine): " + magazine1.getNumero());
	
	//Test placerApres()
	System.out.println("\nplacerApres() (Magazine sur Livre) : " + magazine1.placerApres(livre1));
	
	//Test ajouter et retirer
	System.out.println("\nQuantite avant ajout : " + livre1.getNbExemplaires());
	livre1.ajouter(5);
	System.out.println("Quantite apres ajout (+5) : " + livre1.getNbExemplaires());
	livre1.retirer(3);
	System.out.println("Quantite apres retrait (-3) : " + livre1.getNbExemplaires());
	livre1.retirer(8);
	
	//Test calculerPrix
	System.out.println("\nDate de publication du Magazine : 01/01/2020, Periodicite : " + magazine1.getPeriodicite().toString() + " et prix : " + magazine1.getPrixInitialVente());
	magazine1.setDateDePublication(LocalDate.parse("2020-01-01"));
	System.out.println("Calcul du prix : " + magazine1.calculerPrix());
	
	//Test ajout Livre depuis Etablissement
	System.out.println("\n" + etablissement1);
	System.out.println("\nNombre d'articles : " + etablissement1.getNbArticles() + "/" + etablissement1.getLimiteArticles());
	etablissement1.ajouterLivre("Harry Potter et l'Enfant Maudit", 25, 1, "1231591475684", 359);
	
	Manuel m1 = new Manuel("Le bitcoin pour les nuls", 26, 156, "1111111112", 350, Manuel.Matiere.INFO, Manuel.Niveau._CE1);
	System.out.println(m1);
	
	BonDepot bd1 = new BonDepot("+6 66 66 66 66");
	BonDepot bd2 = new BonDepot("+7 77 77 77 77");
	
	System.out.println(bd1);
	System.out.println(bd2);
	System.out.println(bd1);
	
	etablissement1.ajouterManuel("Manuel de Statistiques CP", 2.2, 30, "010000001", 291, Manuel.Matiere.MATHS, Manuel.Niveau._CP);
        
	System.out.println("Recherche d'un article existant");
        Article manuelStats = etablissement1.rechercher("010000001");
        System.out.println("\nManuel ajouté :");
        System.out.println(manuelStats);
        
	System.out.println("Recherche d'un article inexistant : 00000000000001919919919");
	//Article qui n'existe pas
	if(etablissement1.rechercher("00000000000001919919919") == null){
	    System.out.println("L'article n'existe pas");
	}
	
	System.out.println("Ajout et retrait de quantite sur un Article de Etablissement");
	System.out.println("Si non ajoute :");
	etablissement1.ajouter(livre3.getNumero(), 1000);
        etablissement1.ajouterArticle(livre3);
	System.out.println("Suite a l'ajout :");
        System.out.println("\nAvant ajout via Etablissement : " + livre3.getNbExemplaires());
	etablissement1.ajouter(livre3.getNumero(), 1000);
        System.out.println("Après ajout via Etablissement (+1000) : " + livre3.getNbExemplaires());
        etablissement1.retirer(livre3.getNumero(), 2);
        System.out.println("Après retrait via Etablissement (-2) : " + livre3.getNbExemplaires());
    }
    
}
