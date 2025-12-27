package projet_final;

/**
GRP : William WAN & Hsiao-Wen-Paul LO
 */
public class Projet_final {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=======Test de la classe Client=======");
        System.out.println("======================================");
        System.out.println();
        // avec email
        Client client1 = new Client(1,"John", "0101","johndoe@gmail.com");
        System.out.println(client1);
        // sans email
        Client client2 = new Client(2,"Bill", "0102");
        Client client3 = new Client(3,"Bill", "0103");
        System.out.println(client2);
        System.out.println();  
        
        System.out.println("----Test des getters de client1----");
        System.out.println(client1.getNumero());
        System.out.println(client1.getNom());
        System.out.println(client1.getTelephone());
        System.out.println(client1.getEmail());
        System.out.println(client1);
        System.out.println();  
        
        System.out.println("----Test des méthodes----");
        System.out.println("Client1(John) après Client2(Bill) ? " + client1.placerApres(client2));
        System.out.println("Client2(Bill) après Client1(John) ? " + client2.placerApres(client1));
        System.out.println("Client2(Bill 0102) après Client3(Bill 0103) ?( test téléphone ) " + client2.placerApres(client3));
        System.out.println();  
        
        System.out.println();
        System.out.println("======================================");
        System.out.println("=====Test des classes Prestations=====");
        System.out.println("======================================");
        System.out.println(); 
        System.out.println("======================================");
        System.out.println("=======Test de la classe Express======");
        System.out.println("======================================");
        System.out.println(); 
        
        System.out.println("Sans intérieur");
        PrestationExpress PrestaExpress1 = new PrestationExpress('A', false);
        System.out.println(PrestaExpress1);
        System.out.println(PrestaExpress1.getCategorieVehicule());
        System.out.println("Nettoyage intérieur : " + PrestaExpress1.isNettoyageInterieur());
        System.out.println();
        
        System.out.println("Avec intérieur");
        PrestationExpress PrestaExpress2 = new PrestationExpress('B', true);
        System.out.println(PrestaExpress2);
        System.out.println(PrestaExpress2.getCategorieVehicule());
        System.out.println("Nettoyage intérieur : " + PrestaExpress2.isNettoyageInterieur());
        System.out.println();
        
        System.out.println("======================================");
        System.out.println("========Test de la classe Sale========");
        System.out.println("======================================");
        System.out.println(); 
        
        PrestationSale PrestaSale1 = new PrestationSale('C');
        System.out.println(PrestaSale1);
        System.out.println("Catégorie : " + PrestaSale1.getCategorieVehicule());
        System.out.println();
        
        System.out.println("======================================");
        System.out.println("======Test de la classe TrèsSale======");
        System.out.println("======================================");
        System.out.println();  
        
        PrestationTresSale PrestaTresSale1 = new PrestationTresSale('A', 1);
        System.out.println(PrestaTresSale1);
        System.out.println("Type de salissure : " + PrestaTresSale1.getTypeSalissure());
        System.out.println();
        PrestationTresSale PrestaTresSale2 = new PrestationTresSale('A', 2);
        System.out.println(PrestaTresSale2);
        PrestationTresSale PrestaTresSale3 = new PrestationTresSale('B',6);
        System.out.println(PrestaTresSale3);
        System.out.println();  
        
        System.out.println("======================================");
        System.out.println("=====Test de la classe Rendezvous=====");
        System.out.println("======================================");
        System.out.println(); 
        
        RendezVous RendezVous1 = new RendezVous(client1, PrestaExpress1, 3.2);
        System.out.println(RendezVous1);
        System.out.println();
        
        System.out.println("Client du rendezvous1 : " + RendezVous1.getClient().getNom());
        System.out.println("Prix du rendezvous1 : " + RendezVous1.getPrix() + " €");
        System.out.println("Catégorie véhicule du rendezvous1 : " + RendezVous1.getPrestation().getCategorieVehicule());
        System.out.println();
        
        System.out.println("Prix initial rendezvous1 : " + RendezVous1.getPrix() + " €");
        RendezVous1.setPrix(67.5);
        System.out.println("Prix modifié rendezvous1 : " + RendezVous1.getPrix() + " €");
        System.out.println();
        
        System.out.println("======================================");
        System.out.println("==Test de la classe établissement=====");
        System.out.println("======================================");
        System.out.println(); 
        
              
        Etablissement etablissement = new Etablissement("Shibuya Station");  
        etablissement.ajouter("John", "0101", "johndoe@mail.com");
        etablissement.ajouter("Bill", "0102");
        etablissement.ajouter("Charlie", "0103");
        
        System.out.println(etablissement);
        Client recherche1 = etablissement.rechercher("John", "0101");
        Client recherche2 = etablissement.rechercher("Johnny", "0101");
        if (recherche1 != null) {
        System.out.println( recherche1 );
        } else {
        System.out.println("Recherche1 : Aucun client avec ce critère");
        }
        if (recherche2 != null) {
        System.out.println( recherche2 );
        } else {
        System.out.println("Recherche 2 : Aucun client avec ce critère");
        }
        System.out.println(); 
        
        System.out.println("======================================");
        System.out.println("===========Test des lavages===========");
        System.out.println("======================================");
        System.out.println();         
        
        System.out.println("Prestation Express sans nettoyage inté");
        PrestationExpress presta1 = new PrestationExpress('A', false);
        System.out.println("Lavage : " + presta1.lavage() + " €");
        System.out.println("Séchage : " + presta1.sechage() + " €");
        System.out.println("Prix total : " + presta1.nettoyage() + " €");
        System.out.println();  
        System.out.println("Prestation Express avec nettoyage inté ");
        PrestationExpress presta2 = new PrestationExpress('A', true);
        System.out.println("Lavage : " + presta2.lavage() + " €");
        System.out.println("Nettoyage Intérieur : "+presta2.prixNettoyageInterieur() + " €");
        System.out.println("Séchage : " + presta2.sechage() + " €");
        System.out.println("Prix total : " + presta2.nettoyage() + " €");
        System.out.println();  
        
        System.out.println("Prestation Sale ");
        PrestationSale presta3 = new PrestationSale('C');
        System.out.println("Prélavage : " + presta3.prelavage() + " €");
        System.out.println("Lavage : " + presta3.lavage() + " €");
        System.out.println("Nettoyage Intérieur : "+presta3.prixNettoyageInterieur() + " €");
        System.out.println("Séchage : " + presta3.sechage() + " €");
        System.out.println("Prix total : " + presta3.nettoyage() + " €");
        System.out.println();  
        
        System.out.println("Prestation Très Sale");
        PrestationTresSale presta4 = new PrestationTresSale('A', 1);
        System.out.println("Prélavage : " + presta4.prelavage() + " €");
        System.out.println("Lavage : " + presta4.lavage() + " €");
        System.out.println("Nettoyage Intérieur : "+presta4.prixNettoyageInterieur() + " €");
        System.out.println("Séchage : " + presta4.sechage() + " €");
        System.out.println("Prix total : " + presta4.nettoyage() + " €");
        System.out.println();  
    }
    
}
