package tp2;

import java.util.ArrayList;
import java.util.Comparator;

public class EtagereV2 {
    private int code;
    private String domaine;
    private int capacite;
    private ArrayList<Livre> livres;

    public EtagereV2() {
        this.code = 002;
        this.domaine = "Blablou";
        this.capacite = 5000;
        this.livres = new ArrayList<>();
    }

    public EtagereV2(int code, String domaine, int capacite) {
        this.code = code;
        this.domaine = domaine;
        this.capacite = capacite;
        this.livres = new ArrayList<>();
    }
    public ArrayList<Livre> getLivres() {
        return livres;
    }

    public void ajouterLivre(Livre l) {
        if (livres.size() < capacite) {
            livres.add(l);
            System.out.println("\nLe livre \"" + l.getTitre() + "\" a été ajouté !");
        } else {
            System.out.println("\nIl n'y a plus de place, il faut prendre une plus grosse étagère");
        }
    }

    public void supprimerLivre(int code) {
        boolean ok = false;
        for (int i = 0; i < livres.size(); i++) {
            if (livres.get(i).getCode() == code) {
                System.out.println("\nLe livre \"" + livres.get(i).getTitre() + "\" a été supprimé !");
                livres.remove(i);
                ok = true;
                break;
            }
        }
        if (!ok) {
            System.out.println("\nAucun livre avec le code " + code + " trouvé.");
        }
    }


    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("\nAucun livre sur l'étagère");
        } else {
            for (Livre l : livres) {
                System.out.println("\n" + l.toString());
            }
        }
    }

    public int sommePages() {
        int total = 0;
        for (Livre l : livres) {
            total += l.getNbPages();
        }
        return total;
    }

    public String chercherLivreParTitre(String titre) {
        for (Livre l : livres) {
            if (l.getTitre().equalsIgnoreCase(titre)) {
                return "Le livre que vous avez demandé (" + titre + ") est le numéro " + l.getCode();
            }
        }
        return "Aucun livre trouvé avec le titre \"" + titre + "\"";
    }

    public void chercherPetitsLivres(int seuil) {
        boolean found = false;
        System.out.println("\nLivres avec moins de " + seuil + " pages :");
        for (Livre l : livres) {
            if (l.getNbPages() < seuil) {
                System.out.println(l);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun livre trouvé en dessous de " + seuil + " pages");
        }
    }

    public void afficherNouveauxLivres(int anneeActuelle) {
        boolean found = false;
        for (Livre l : livres) {
            if (l.getAnneeEdition() == anneeActuelle) {
                System.out.println("[" + l.getCode() + "] " + l.getTitre());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun livre de " + anneeActuelle);
        }
    }

    public void changerNbPages(int code, int nbPages) {
        for (Livre l : livres) {
            if (l.getCode() == code) {
                l.setNbPages(nbPages);
                System.out.println("Le livre " + l.getTitre() + " a maintenant " + nbPages + " pages !");
                return;
            }
        }
        System.out.println("Livre avec code " + code + " non trouvé !");
    }

    public void trier() {
        livres.sort(Comparator.comparingInt(Livre::getNbPages));
    }

    public String[] chercherTitresParAuteur(String auteur) {
        ArrayList<String> titres = new ArrayList<>();
        for (Livre l : livres) {
            if (l.getAuteur().equalsIgnoreCase(auteur)) {
                titres.add(l.getTitre());
            }
        }
        return titres.toArray(new String[0]);
    }
}
