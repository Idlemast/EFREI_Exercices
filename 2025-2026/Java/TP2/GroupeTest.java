package tp2;

import java.util.ArrayList;

public class GroupeTest {
    public static void main(String[] args) {
        Groupe groupe = new Groupe();

        groupe.ajouterEtudiant(new Etudiant(101, "Don", "Juan", 1, "Machine learning", 0.2));
        groupe.ajouterEtudiant(new Etudiant(102, "Bob", "Bob", 98, "Chimie", 18.0));
        groupe.ajouterEtudiant(new Etudiant(103, "Asal", "Reza", 9, "Politique", 19.5));

        groupe.afficherEtudiants();

        groupe.trierParAge();
        groupe.afficherEtudiants();

        groupe.specialiteParNum(102);
    }
}
