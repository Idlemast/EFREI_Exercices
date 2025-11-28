package tp2;

import java.util.ArrayList;
import java.util.Comparator;

public class Groupe {
    private ArrayList<Etudiant> etudiants;

    public Groupe() {
        etudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant e) {
        etudiants.add(e);
        System.out.println("Étudiant ajouté : " + e.getPrenom() + " " + e.getNom());
    }

    public void afficherEtudiants() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant dans le groupe.");
        } else {
            for (Etudiant e : etudiants) {
                System.out.println(e);
            }
        }
    }

    public void trierParAge() {
        etudiants.sort(Comparator.comparingInt(Etudiant::getAge));
        System.out.println("Étudiants triés par âge !");
    }

    public void specialiteParNum(int num) {
        for (Etudiant e : etudiants) {
            if (e.getNumEtudiant() == num) {
                System.out.println("Spécialité de l'étudiant " + e.getPrenom() + ": " + e.getSpecialite());
                return;
            }
        }
        System.out.println("Aucun étudiant avec le numéro " + num);
    }

    public ArrayList<String> prenomsParAge(int age) {
        ArrayList<String> prenoms = new ArrayList<>();
        for (Etudiant e : etudiants) {
            if (e.getAge() == age) {
                prenoms.add(e.getPrenom());
            }
        }
        return prenoms;
    }
}
