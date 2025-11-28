package tp2;

public class BibliothequeTest {
    
    public static void main(String[] args) {
        Etagere etagereChimie = new Etagere(1, "Chimie", 10);
        Etagere etagereInfo = new Etagere(2, "Informatique", 10);

        etagereChimie.ajouterLivre(new Livre("La chimie organique", 201, "John McMurry", 1200, 2019));
        etagereChimie.ajouterLivre(new Livre("Introduction à la chimie analytique", 202, "Daniel C. Harris", 800, 2021));
        etagereChimie.ajouterLivre(new Livre("Chimie générale", 203, "Raymond Chang", 1000, 2018));
        
        etagereInfo.ajouterLivre(new Livre("Introduction aux algorithmes", 301, "Thomas H. Cormen", 1300, 2020));
        etagereInfo.ajouterLivre(new Livre("Design Patterns", 302, "Erich Gamma", 400, 1994));
        etagereInfo.ajouterLivre(new Livre("Java pour les débutants", 303, "Herbert Schildt", 700, 2019));
        

        etagereChimie.afficherLivres();

        System.out.println("Total pages : " + etagereChimie.sommePages());

        System.out.println(etagereChimie.chercherLivreParTitre("Chimie générale"));

        etagereChimie.chercherPetitsLivres(1000);
        etagereChimie.afficherNouveauxLivres(2021);
        etagereChimie.changerNbPages(202, 850);
        etagereChimie.afficherLivres();
        etagereChimie.supprimerLivre(203); 
        etagereChimie.afficherLivres();
        etagereInfo.trier();
        etagereInfo.afficherLivres();

        String[] titres = etagereInfo.chercherTitresParAuteur("Erich Gamma");
        for (String titre : titres) {
            System.out.println("- " + titre);
        } 
    }
}