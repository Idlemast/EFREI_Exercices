package tp2;

public class BibliothequeV2Test {
    public static void main(String[] args) {
        EtagereV2 etagere = new EtagereV2(1, "Chimie", 5);

        etagere.ajouterLivre(new Livre("La chimie organique", 201, "John McMurry", 1200, 2019));
        etagere.ajouterLivre(new Livre("Introduction à la chimie analytique", 202, "Daniel C. Harris", 800, 2021));
        etagere.ajouterLivre(new Livre("Chimie générale", 203, "Raymond Chang", 1000, 2018));


        etagere.afficherLivres();

        System.out.println("\nSomme totale des pages : " + etagere.sommePages());

        System.out.println(etagere.chercherLivreParTitre("Chimie générale"));
        System.out.println(etagere.chercherLivreParTitre("EOOOOOoeooeoeeoooeee"));

        etagere.chercherPetitsLivres(800);
        etagere.chercherPetitsLivres(1000);

        etagere.afficherNouveauxLivres(2018);
        etagere.afficherNouveauxLivres(1999); 

        etagere.changerNbPages(201, 420);
        etagere.changerNbPages(999, 123);

        etagere.trier();
        etagere.afficherLivres();

        String[] titresMcMurry = etagere.chercherTitresParAuteur("John McMurry");
        System.out.println("\nLivres de John McMurry :");
        for (String titre : titresMcMurry) {
            System.out.println("- " + titre);
        }


        String[] titresInconnu = etagere.chercherTitresParAuteur("Auteur Inconnu");
        System.out.println("\nNombre de livres d'un auteur inconnu : " + titresInconnu.length);

        etagere.supprimerLivre(202); 
        etagere.supprimerLivre(999); 
        etagere.afficherLivres();
    }
}
