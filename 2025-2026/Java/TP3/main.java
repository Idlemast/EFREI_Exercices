package tp3;

import java.time.LocalDate;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	//Test Livre
	Livre livre1 = new Livre("Harry Potter a l'ecole des sorciers", "1111111111111", 350);
	Livre livre2 = new Livre("Harry Potter et la Chambre des Secrets", "1111111111112", 350);
	Livre livre3 = new Livre("Harry Potter et la Prison l'Azkaban", "1111111111113", 350);
	Livre livre4 = new Livre("Harry Potter et la Coupe de feu", "1111111111114", 350);
	Livre livre5 = new Livre("Harry Potter et l'Ordre du Phenix", "1111111111115", 350);
	Livre livre6 = new Livre("Harry Potter et le Prince de Sang-Mele", "1111111111116", 350);
	Livre livre7 = new Livre("Harry Potter et les Reliques de la Mort", "1111111111117", 350);
	Livre livre17 = new Livre("Harry Potter et les Reliques de la Mort 6", 99, 2, "1111111111148", 350);
	System.out.println(livre1);
	System.out.println(livre5);
	
	//Test Manuel
	Manuel manuel1 = new Manuel("Apprendre le mandarin", "1111111111121", 350);
	Manuel manuel2 = new Manuel("Apprendre la biologie", "1111111111122", 350);
	Manuel manuel3 = new Manuel("Apprendre le russe", "1111111111123", 350);
	Manuel manuel4 = new Manuel("Apprendre l'anglais", "1111111111124", 350);
	Manuel manuel5 = new Manuel("Apprendre Java", "1111111111125", 350);
	Manuel manuel6 = new Manuel("Apprendre Python", "1111111111126", 350);
	Manuel manuel7 = new Manuel("Apprendre SQL", "1111111111127", 350);
	System.out.println(manuel1);
	System.out.println(manuel5);
	
	//Test Magazine
        Magazine magazine0= new Magazine("Pokemon - les aventures de pikachu ", 10.0, 1, "00000001",Magazine.Periodicite.M,
        LocalDate.now().minusMonths(5));
	Magazine magazine1 = new Magazine("Louis Vuitton - La mode made in France", "11111111");
	Magazine magazine2 = new Magazine("Shein, le nouvel eldorado", "11111122");
	Magazine magazine3 = new Magazine("Uniqlo, le style japonais", "11111123");
	Magazine magazine4 = new Magazine("Bershka, le style des faux riches", "11111124");
	Magazine magazine5 = new Magazine("Channel : Alta Sartoria, magnifique", "11111125");
	Magazine magazine6 = new Magazine("Kiabi : la mode un peu moins accesible", "11111126");
	Magazine magazine7 = new Magazine("Issey Miyake : l'outsider", "11111127");
	System.out.println(magazine1);
	System.out.println(magazine5);
	
	//Test LigneDepot
	LigneDepot ligneDepot1 = new LigneDepot(magazine7.getISSN(), 2);
	LigneDepot ligneDepot2 = new LigneDepot(magazine6.getISSN(), 3);
	LigneDepot ligneDepot3 = new LigneDepot(magazine5.getISSN(), 5);
	LigneDepot ligneDepot4 = new LigneDepot(magazine4.getISSN(), 1);
	LigneDepot ligneDepot5 = new LigneDepot(magazine3.getISSN(), 7);
	LigneDepot ligneDepot6 = new LigneDepot(manuel7.getISBN(), 1);
	System.out.println(ligneDepot1);
	System.out.println(ligneDepot6);
	
	//Test BonDepot
	BonDepot bonDepot1 = new BonDepot("+33 6 01 01 01 01");
	BonDepot bonDepot2 = new BonDepot("+33 7 77 77 77 77");
        
        bonDepot1.ajouterLigne(ligneDepot2.getCodeArticle(), ligneDepot2.getNbExemplairesDepot());
        System.out.println(bonDepot1);

        bonDepot1.ajouterLigne(ligneDepot3.getCodeArticle(), ligneDepot3.getNbExemplairesDepot());
        System.out.println(bonDepot1);

        bonDepot1.ajouterLigne(ligneDepot6.getCodeArticle(), ligneDepot6.getNbExemplairesDepot());
        System.out.println(bonDepot1);

        bonDepot1.ajouterLigne(ligneDepot6.getCodeArticle(), ligneDepot6.getNbExemplairesDepot());
	
        // Test du dépassement de la limite du bon de dépot 1 (9 lignes max) 
        bonDepot1.ajouterLigne(ligneDepot1.getCodeArticle(), ligneDepot1.getNbExemplairesDepot()); // 5e ligne
        bonDepot1.ajouterLigne(ligneDepot4.getCodeArticle(), ligneDepot4.getNbExemplairesDepot()); // 6e ligne
        bonDepot1.ajouterLigne(ligneDepot5.getCodeArticle(), ligneDepot5.getNbExemplairesDepot()); // 7e ligne
        bonDepot1.ajouterLigne("101020102010", 1); // 8e ligne
        bonDepot1.ajouterLigne("1020130230101", 1); // 9e ligne
        bonDepot1.ajouterLigne("0312031023013", 1); // 10e ligne : en théorie, ça doit être refusé

        System.out.println("\nBonDepot1 après tentative d'ajouter 10 lignes :");
        System.out.println(bonDepot1);
        
	//Test Etablissement
	Etablissement etablissement1 = new Etablissement("BHV", 4, 10);
	Etablissement etablissement2 = new Etablissement("Grande Epicerie de Paris", 4, 5);
//	System.out.println(etablissement1);
//	System.out.println(etablissement2);

        BonDepot bonE1 = etablissement1.ajouter("+33 6 01 01 01 01");
        BonDepot bonE2 = etablissement1.ajouter("+33 7 77 77 77 77");


        bonE1.ajouterLigne(ligneDepot4.getCodeArticle(), ligneDepot4.getNbExemplairesDepot());
        bonE1.ajouterLigne(ligneDepot5.getCodeArticle(), ligneDepot5.getNbExemplairesDepot());


        etablissement1.ajouterArticle(livre17);
        etablissement1.ajouterArticle(livre4);

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
	System.out.println("\nDate de publication du Magazine : 01/01/2020, Periodicite : " + magazine0.getPeriodicite().toString() + " et prix : " + magazine0.getPrixInitialVente());
	magazine1.setDateDePublication(LocalDate.parse("2020-01-01"));
	System.out.println("Prix magazine -75% attendu : " + magazine0.calculerPrix());
       
        Magazine magRecent = new Magazine(
            "Hebdo frais", 4.0, 10,
            "22222222", Magazine.Periodicite.H,
            LocalDate.now() 
        );
        System.out.println("prix initial de magRecent " + magRecent.getPrixInitialVente());
        
        System.out.println("Prix magazine récent (sans réduction) : " + magRecent.calculerPrix());

        Magazine mag50 = new Magazine(
            "Mensuel -50%", 10.0, 5,
            "33333333", Magazine.Periodicite.M,
            LocalDate.now().minusMonths(3)
        );
        System.out.println("prix initial de mag50 " + mag50.getPrixInitialVente());
        System.out.println("Prix magazine -50% attendu : " + mag50.calculerPrix());
        
	//Test ajout Livre depuis Etablissement
	System.out.println("\n" + etablissement1);
	System.out.println("\nNombre de places : " + etablissement1.getNbArticles() + "/" + etablissement1.getLimiteArticles());
	etablissement1.ajouterLivre("Harry Potter et l'Enfant Maudit", 25, 1, "1231591475684", 359);
	
	
        etablissement1.ajouterManuel("Manuel de Statistiques CP", 2.2, 30, "010000001", 291, Manuel.Matiere.MATHS, Manuel.Niveau.CP
        );
        
        Article manuelStats = etablissement1.rechercher("010000001");
        System.out.println("\nManuel ajouté :");
        System.out.println(manuelStats);
        
        Article rien = etablissement1.rechercher("00000000000001919919919");
        System.out.println("Recherche d'un article qui n'existe pas : " + rien);
        
        System.out.println("\nAvant ajout via Etablissement : " + livre17.getNbExemplaires());
        etablissement1.ajouter(livre17.getISBN(), 1000);
        System.out.println("Après ajout via Etablissement (+1000) : " + livre17.getNbExemplaires());
        etablissement1.retirer(livre17.getISBN(), 2);
        System.out.println("Après retrait via Etablissement (-2) : " + livre17.getNbExemplaires());
        
        
	
//	Manuel m1 = new Manuel("Le bitcoin pour les nuls", 1111111112, 350, Manuel.Matiere.INFO, Manuel.Niveau.CE1);
//	System.out.println(m1);
//	
//	BonDepot bd1 = new BonDepot("+6 66 66 66 66");
//	BonDepot bd2 = new BonDepot("+7 77 77 77 77");
//	
//	System.out.println(bd1);
//	System.out.println(bd2);
//	
//	LigneDepot ld1 = new LigneDepot(l1.getISBN());
//	LigneDepot ld2 = new LigneDepot(m1.getISBN(), 5);
//	LigneDepot ld3 = new LigneDepot(m1.getISBN(), 2);
//	LigneDepot ld4 = new LigneDepot(m1.getISBN(), 3);
//	LigneDepot ld5 = new LigneDepot(m1.getISBN(), 10);
//	
//	bd1.ajouterLigne(ld1);
//	System.out.println(bd1);
//	bd1.ajouterLigne(ld2);
//	System.out.println(bd1);
//	System.out.println(bd2);
//	
//	Etablissement e1 = new Etablissement("E1", 1, 10);
//	e1.addArticle(m1);
//	System.out.println(e1);
//	
//	bd1.ajouterLigne(ld5);
//	System.out.println(bd1);
	
    }
    
}
