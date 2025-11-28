package tp2;
/* authors William WAN et Hsiao-Wen-Paul LO*/
public class Main {

    public static void main(String[] args) {
	System.out.println("------ [EXERCICE 1] ------");
	Exercice1 e1 = new Exercice1();
	System.out.println("Nombre total de pages : " + e1.sum());
	System.out.println("Nombre minimum de pages : " + e1.min());
	System.out.println("Nombre moyen de pages : " + e1.avg());
	e1.sort();
	System.out.println("Tableau dans l'ordre : ");
	e1.showTab();
	
	System.out.println("\n\n------ [EXERCICE 3] ------");
	//Partie1
	Livre l = new Livre();
	System.out.println(l.toString());
	Etagere e = new Etagere();
	e.afficherLivres();
	System.out.println(e.getLivres().length);
	e.ajouterLivre(l);
	e.afficherLivres();
	Livre l1 = new Livre("Test A", 20487, "Auteur A", 90, 2015);
	Livre l2 = new Livre("Test B", 25146, "Auteur B", 340, 2002);
	e.ajouterLivre(l1);
	e.ajouterLivre(l2);
	e.afficherLivres();
	//Partie2

         System.out.println("\n BibliothequeTest");
         BibliothequeTest.main(new String[]{});
         System.out.println("\n BibliothequeV2Test");
         BibliothequeV2Test.main(new String[]{});
         System.out.println("\n GroupeTest");
         GroupeTest.main(new String[]{});
    }
}
