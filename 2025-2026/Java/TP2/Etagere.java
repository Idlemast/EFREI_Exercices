package tp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Etagere {
    private int code;
    private String domaine;
    private int capacite;
    private Livre[] livres;
    
    public Etagere(){
	this.code = 001;
	this.domaine = "Blabla";
	this.capacite = 5000;
	this.livres = new Livre[capacite];
    }
    
    public Etagere(int c, String d, int cap){
	this.code = c;
	this.domaine = d;
	this.capacite = cap;
	this.livres = new Livre[capacite];
    }
    
    public Livre[] getLivres(){return livres;}
    
    
    public void ajouterLivre(Livre l){
	boolean ok = false;
	for(int i = 0; i <= livres.length - 1 && ok == false; i++){
	    if(livres[i] == null) {
		livres[i] = l;
		ok = true;
	    }
	}
	if(ok){System.out.println("\nLe livre " + l.getTitre() + " a été ajouté !");}
	else{System.out.println("\nIl n'y a plus de place, il faut prendre une plus grosse étagère");}
    }
    
    public void supprimerLivre(int code) {
        boolean ok = false;
        for (int i = 0; i < livres.length; i++) {
            if (livres[i] != null && livres[i].getCode() == code) {
                System.out.println("\nLe livre \"" + livres[i].getTitre() + "\" a été supprimé !");
                livres[i] = null;
                ok = true;
                break;
            }
        }
        if (!ok) {
            System.out.println("\nAucun livre avec le code " + code + " trouvé.");
        }
    }


    
    public int sommePages(){
	int x = 0;
	for(int i = 0; i <= livres.length - 1; i++){
	    if(livres[i] != null) {
		x += livres[i].getNbPages();
	    }
	}
	return x;
    }
    
    public String chercherLivreParTitre(String titre){
        for(int i = 0; i < livres.length; i++){
            if(livres[i] != null && livres[i].getTitre().equalsIgnoreCase(titre)) {
                return "Le livre que vous avez demandé ("+ titre +") est le numéro " + livres[i].getCode();
            }
        }
        return "\nIl n'y avait pas de livre avec ce nom";
    }

    

    public void chercherPetitsLivres(int seuil){
        boolean ok = false;
        System.out.println("Livres avec moins de " + seuil + " pages :");
        for(int i = 0; i < livres.length; i++){
            if(livres[i] != null && livres[i].getNbPages() < seuil) {
                System.out.println(livres[i]);
                ok = true;
            }
        }
        if(ok== false){
            System.out.println("Aucun livre trouvé en dessous de " + seuil + " pages");
        }
    }

    
    public void afficherNouveauxLivres(int anneeActuelle){
	boolean ok = false;
	for(int i = 0; i <= livres.length - 1; i++){
	    if(livres[i] != null && livres[i].getAnneeEdition() == anneeActuelle) {
		System.out.println("[" + livres[i].getCode() + "] " + livres[i].getTitre());
		ok = true;
	    }
	}
	if(ok == false){System.out.println("\nAucun livre de " + anneeActuelle);}
    }
    
    public void changerNbPages(int code, int nbPages) {
        boolean ok= false;
        for (int i = 0; i < livres.length; i++) {
            if (livres[i] != null && livres[i].getCode() == code) {
                livres[i].setNbPages(nbPages);
                ok = true;
                break;
            }
        }
        if (ok==false) {
            System.out.println("Livre avec code " + code + " non trouvé !");
        }
    }
    
    public void afficherLivres(){
	boolean ok = false;
	for(int i = 0; i <= livres.length - 1; i++){
	    if(livres[i] != null) {
		System.out.println("\n" + livres[i].toString());
		ok = true;
	    }
	}
	if(ok == false){System.out.println("\nAucun livre");}
    }
    
    private int nbLivres() {
        int count = 0;
        for (Livre l : livres) {
            if (l != null) count++;
        }
        return count;
    }

    public void trier() {
        Arrays.sort(livres, 0, nbLivres(), Comparator.comparingInt(Livre::getNbPages));
    }

    public String[] chercherTitresParAuteur(String auteur) {
        ArrayList<String> titres = new ArrayList<>();

        for (Livre l : livres) {
            if (l != null && l.getAuteur().equalsIgnoreCase(auteur)) {
                titres.add(l.getTitre());
            }
        }

        return titres.toArray(new String[0]);
    }

}
